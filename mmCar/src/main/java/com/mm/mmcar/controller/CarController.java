package com.mm.mmcar.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.mm.mmcar.entity.CarInfo;
import com.mm.mmcar.entity.vo.CarInfoVo;
import com.mm.mmcar.service.CarInfoService;
import com.mm.mmcar.utils.FileNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author 茂茂
 * @create 2022-05-17 10:41
 */
@Controller
@RequestMapping(value = "/car")
public class CarController {

    //设置分页显示每页条数
    private static final int CAR_PAGE_SIZE = 7;
    //异步上传汽车图片的名称
    String uploadFileName = "";

    @Autowired
    CarInfoService carInfoService;

    @RequestMapping("/selectAll")
    public String selectAll(HttpServletRequest request) {
        List<CarInfo> list = carInfoService.selectAll();
        request.setAttribute("list", list);
        return "admin/car";
    }

    @RequestMapping("/firstPage")
    public String firstPage(HttpServletRequest request) {
        PageInfo info = null;
        //获取selectCarVo对象判断是否为带条件查询
        Object voObjet = request.getSession().getAttribute("carInfoVo");
        //有条件调用多条件查询方法
        if (voObjet != null) {
            info = carInfoService.selectConditionPagination((CarInfoVo) voObjet, CAR_PAGE_SIZE);
            //传入参数后将清理会话作用域中的无用对象
            request.getSession().removeAttribute("carInfoVo");
            //否则只返回所有结果的第一页记录
        } else {
            info = carInfoService.pagination(1, CAR_PAGE_SIZE);
        }
        //将查询结果封装为PageInfo类型属性赋予请求作用域返回car页面
        request.setAttribute("info", info);
        return "admin/car";
    }

    @ResponseBody
    @RequestMapping("/turnPages")
    public void turnPages(CarInfoVo carInfoVo, HttpSession httpSession) {
        //取出carInfoVo中带有要跳转到的页数page参数,调用selectConditionPagination()进行翻页
        PageInfo info = carInfoService.selectConditionPagination(carInfoVo, CAR_PAGE_SIZE);
        httpSession.setAttribute("info", info);
    }

    @ResponseBody
    @RequestMapping("/uploadPicture")
    public Object uploadPicture(MultipartFile cimage, HttpServletRequest request) {
        //获取上传文件的名称,留置其他方法调用后再清除uploadFileName中信息
        uploadFileName = FileNameUtil.getUUIDFileName() + FileNameUtil.getFileType(cimage.getOriginalFilename());
        //获取文件存储路径
        String path = request.getServletContext().getRealPath("/image_big");
        try {
            //将文件传入服务器数据库
            cimage.transferTo(new File(path + File.separator + uploadFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //将文件名转为json格式返回,供前端在使用修改,新增功能时上传图片及时回显
        JSONObject object = new JSONObject();
        object.put("imgurl", uploadFileName);
        return object.toString();
    }

    @RequestMapping("/newCar")
    public String newCar(CarInfo carInfo, HttpServletRequest request) {
        //向carInfo承载文件名和时间的属性赋值,uploadFileName已由uploadPicture()方法赋值
        carInfo.setcImage(uploadFileName);
        carInfo.setcDate(new Date());
        int num = -1;
        try {
            //执行插入语句
            num = carInfoService.insertCar(carInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //判断是否插入成功,反馈信息到前端
        if (num > 0) {
            request.setAttribute("msg", "新增汽车车型成功");
        } else {
            request.setAttribute("msg", "新增汽车车型失败");
        }
        //最后清空承载上传文件名称的变量,请求转发跳转第一页显示
        uploadFileName = "";
        return "forward:/car/firstPage";
    }

    @RequestMapping("/selectByIdCar")
    public String selectByIdCar(Integer cId, CarInfoVo carInfoVo, Model model, HttpSession httpSession) {
        //通过获取的车型id进行查询
        CarInfo info = carInfoService.selectById(cId);
        //将车辆信息放入model的变量中,返回前端修改界面显示
        model.addAttribute("prod", info);
        //在会话作用域设置carInfoVo变量承载前端获得的查询条件,留置
        httpSession.setAttribute("carInfoVo", carInfoVo);
        return "admin/carUpdate";
    }

    @RequestMapping("/updateCarInfo")
    public String updateCarInfo(CarInfo carInfo, HttpServletRequest request) {
        //修改时间
        carInfo.setcDate(new Date());
        //如果上传文件名称变量中有值,则修改carInfo变量中的属性
        if (!uploadFileName.equals("")) {
            carInfo.setcImage(uploadFileName);
        }
        int num = -1;
        try {
            //调用sql修改数据库信息
            num = carInfoService.updateCarInfo(carInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //判断是否更新成功,反馈信息到前端
        if (num > 0) {
            request.setAttribute("msg", "更新汽车信息成功");
        } else {
            request.setAttribute("msg", "更新汽车信息失败");
        }
        //最后清空承载上传文件名称的变量,跳转最初页面显示
        uploadFileName = "";
        return "forward:/car/firstPage";
    }

    @RequestMapping("/deleteCar")
    public String deleteCar(int cId, CarInfoVo carInfoVo, HttpServletRequest request) {
        int num = -1;
        try {
            //调用删除方法
            num = carInfoService.deleteCar(cId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //反馈前端删除结果,删除成功将页面状态信息放入会话作用域对象中提供deleteRefresh方法调用
        if (num > 0) {
            request.setAttribute("msg", "删除此汽车类型成功");
            request.getSession().setAttribute("deleteCarVo", carInfoVo);
        } else {
            request.setAttribute("msg", "删除此汽车类型失败");
        }

        return "forward:/car/deleteRefresh";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteRefresh", produces = "text/html;charset=UTF-8")
    public Object deleteRefresh(HttpServletRequest request) {
        PageInfo pageInfo = null;
        //获取carInfoVo对象中保存页面状态
        Object vo = request.getSession().getAttribute("deleteCarVo");
        //如果对象不为空则获取应跳转回的页面状态的车辆信息,否则获取第一页车辆信息
        if (vo != null) {
            pageInfo = carInfoService.selectConditionPagination((CarInfoVo) vo, CAR_PAGE_SIZE);
            request.getSession().removeAttribute("deleteCarVo");
        } else {
            pageInfo = carInfoService.pagination(1, CAR_PAGE_SIZE);
        }
        //将查询集合放入会话作用域中供前端获取信息(刷新页面)
        request.getSession().setAttribute("info", pageInfo);
        //反馈前端删除结果
        return request.getAttribute("msg");
    }

    @RequestMapping("/deleteCarBatch")
    public String deleteCarBatch(String cIds, CarInfoVo carInfoVo, HttpServletRequest request) {
        //批量删除方法deleteCarBatch()参数为String数组,需要将要删除车辆id拆分装入数组
        String[] strs = cIds.split(",");
        int num = -1;
        try {
            //获取影响记录条数
            num = carInfoService.deleteCarBatch(strs);
            //反馈前端删除情况
            if (num > 0) {
                request.setAttribute("msg", "批量删除汽车成功");
                //将批量删除页面信息装入会话作用域中供刷新方法使用
                request.getSession().setAttribute("deleteCarVo", carInfoVo);
            } else {
                request.setAttribute("msg", "批量删除汽车失败");
            }
        } catch (Exception e) {
            request.setAttribute("msg", "其中有不可删除的汽车类型");
        }
        //删除结束后刷新页面
        return "forward:/car/deleteRefresh";
    }

    @ResponseBody
    @RequestMapping("/selectConditions")
    public void selectConditions(CarInfoVo carInfoVo, HttpSession httpSession) {
        //按条件查询,将结果list放入会话作用域中等待调用
        List<CarInfo> list = carInfoService.selectConditions(carInfoVo);
        httpSession.setAttribute("list", list);
    }
}