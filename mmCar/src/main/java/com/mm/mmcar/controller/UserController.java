package com.mm.mmcar.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.mm.mmcar.entity.UserInfo;
import com.mm.mmcar.entity.vo.UserInfoVo;
import com.mm.mmcar.service.UserInfoService;
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
 * @create 2022-05-18 18:40
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    //设置分页显示每页条数
    private static final int USER_PAGE_SIZE = 3;
    //异步上传用户头像的名称
    String uploadUserFileName = "";

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("/selectAll")
    public String selectAll(HttpServletRequest request) {
        List<UserInfo> list = userInfoService.selectAll();
        request.setAttribute("list", list);
        return "admin/user";
    }

    @RequestMapping("/firstPage")
    public String firstPage(HttpServletRequest request) {
        PageInfo userInfo = null;
        //获取selectuserVo对象判断是否为带条件查询
        Object voObjet = request.getSession().getAttribute("userInfoVo");
        //有条件调用多条件查询方法
        if (voObjet != null) {
            userInfo = userInfoService.selectConditionPagination((UserInfoVo) voObjet, USER_PAGE_SIZE);
            //传入参数后将清理会话作用域中的无用对象
            request.getSession().removeAttribute("userInfoVo");
            //否则只返回所有结果的第一页记录
        } else {
            userInfo = userInfoService.pagination(1, USER_PAGE_SIZE);

        }
        //将查询结果封装为PageInfo类型属性赋予请求作用域返回user页面
        request.setAttribute("userInfo", userInfo);
        return "admin/user";
    }

    @ResponseBody
    @RequestMapping("/turnPages")
    public void turnPages(UserInfoVo userInfoVo, HttpSession httpSession) {
        //取出userInfoVo中带有要跳转到的页数page参数,调用selectConditionPagination()进行翻页
        PageInfo userInfo = userInfoService.selectConditionPagination(userInfoVo, USER_PAGE_SIZE);
        httpSession.setAttribute("userInfo", userInfo);
    }

    @ResponseBody
    @RequestMapping("/uploadPicture")
    public Object uploadPicture(MultipartFile uavatar, HttpServletRequest request) {
        //获取上传文件的名称,留置其他方法调用后再清除uploadUserFileName中信息
        if (uavatar != null) {
            uploadUserFileName = FileNameUtil.getUUIDFileName() + FileNameUtil.getFileType(uavatar.getOriginalFilename());
        } else {
            System.out.println(uploadUserFileName);
        }
        //获取文件存储路径
        String path = request.getServletContext().getRealPath("/image_big");
        try {
            //将文件传入服务器数据库
            uavatar.transferTo(new File(path + File.separator + uploadUserFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject object = new JSONObject();
        object.put("imgurl", uploadUserFileName);
        return object.toString();
    }

    @RequestMapping("/newUser")
    public String newuser(UserInfo userInfo, HttpServletRequest request) {
        //向userInfo承载文件名和时间的属性赋值,uploadUserFileName已由uploadPicture()方法赋值
        userInfo.setuAvatar(uploadUserFileName);
        userInfo.setuDate(new Date());
        int num = -1;
        try {
            //执行插入语句
            num = userInfoService.insertUser(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //判断是否插入成功,反馈信息到前端
        if (num > 0) {
            request.setAttribute("msg", "新增用户成功");
        } else {
            request.setAttribute("msg", "新增用户失败");
        }
        //最后清空承载上传文件名称的变量,请求转发跳转第一页显示
        uploadUserFileName = "";
        return "forward:/user/firstPage";
    }

    @RequestMapping("/selectByIdUser")
    public String selectByIdUser(Integer uId, UserInfoVo userInfoVo, Model model, HttpSession httpSession) {
        //通过获取的车型id进行查询
        UserInfo info = userInfoService.selectById(uId);
        //将车辆信息放入model的变量中,返回前端修改界面显示
        model.addAttribute("prod", info);
        //在会话作用域设置userInfoVo变量承载前端获得的查询条件,留置
        httpSession.setAttribute("userInfoVo", userInfoVo);
        return "admin/userUpdate";
    }

    @RequestMapping("/updateUserInfo")
    public String updateuserInfo(UserInfo userInfo, HttpServletRequest request) {
        //修改时间
        userInfo.setuDate(new Date());
        //如果上传文件名称变量中有值,则修改userInfo变量中的属性
        if (!"".equals(uploadUserFileName)) {
            userInfo.setuAvatar(uploadUserFileName);
        }
        int num = -1;
        try {
            //调用sql修改数据库信息
            num = userInfoService.updateUserInfo(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //判断是否更新成功,反馈信息到前端
        if (num > 0) {
            request.setAttribute("msg", "修改用户信息成功");
        } else {
            request.setAttribute("msg", "修改用户信息失败");
        }
        //最后清空承载上传文件名称的变量,跳转最初页面显示
        uploadUserFileName = "";
        return "forward:/user/firstPage";
    }

    @RequestMapping("/deleteUser")
    public String deleteuser(int uId, UserInfoVo userInfoVo, HttpServletRequest request) {
        int num = -1;
        try {
            //调用删除方法
            num = userInfoService.deleteUser(uId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //反馈前端删除结果,删除成功将页面状态信息放入会话作用域对象中提供deleteRefresh方法调用
        if (num > 0) {
            request.setAttribute("msg", "删除此用户类型成功");
            request.getSession().setAttribute("deleteUserVo", userInfoVo);
        } else {
            request.setAttribute("msg", "删除此用户类型失败");
        }
        return "forward:/user/deleteRefresh";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteRefresh", produces = "text/html;charset=UTF-8")
    public Object deleteRefresh(HttpServletRequest request) {
        PageInfo pageInfo = null;
        //获取userInfoVo对象中保存页面状态
        Object vo = request.getSession().getAttribute("deleteUserVo");
        //如果对象不为空则获取应跳转回的页面状态的车辆信息,否则获取第一页车辆信息
        if (vo != null) {
            pageInfo = userInfoService.selectConditionPagination((UserInfoVo) vo, USER_PAGE_SIZE);
            request.getSession().removeAttribute("deleteUserVo");
        } else {
            pageInfo = userInfoService.pagination(1, USER_PAGE_SIZE);
        }
        //将查询集合放入会话作用域中供前端获取信息(刷新页面)
        request.getSession().setAttribute("userInfo", pageInfo);
        //反馈前端删除结果
        return request.getAttribute("msg");
    }

    @RequestMapping("/deleteUserBatch")
    public String deleteuserBatch(String uIds, UserInfoVo userInfoVo, HttpServletRequest request) {
        //批量删除方法deleteuserBatch()参数为String数组,需要将要删除车辆id拆分装入数组
        String[] strs = uIds.split(",");
        int num = -1;
        try {
            //获取影响记录条数
            num = userInfoService.deleteUserBatch(strs);
            //反馈前端删除情况
            if (num > 0) {
                request.setAttribute("msg", "批量删除用户成功");
                //将批量删除页面信息装入会话作用域中供刷新方法使用
                request.getSession().setAttribute("deleteUserVo", userInfoVo);
            } else {
                request.setAttribute("msg", "批量删除用户失败");
            }
        } catch (Exception e) {
            request.setAttribute("msg", "其中有不可删除的用户类型");
        }
        //删除结束后刷新页面
        return "forward:/user/deleteRefresh";
    }

    @ResponseBody
    @RequestMapping("/selectConditions")
    public void selectConditions(UserInfoVo userInfoVo, HttpSession httpSession) {
        //按条件查询,将结果list放入会话作用域中等待调用
        List<UserInfo> list = userInfoService.selectConditions(userInfoVo);
        httpSession.setAttribute("list", list);
    }
}
