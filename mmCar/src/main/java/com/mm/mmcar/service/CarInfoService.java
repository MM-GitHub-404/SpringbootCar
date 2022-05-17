package com.mm.mmcar.service;

import com.github.pagehelper.PageInfo;
import com.mm.mmcar.entity.CarInfo;
import com.mm.mmcar.entity.vo.CarInfoVo;

import java.util.List;

/**
 * @author 茂茂
 * @create 2022-02-11 17:39
 */
public interface CarInfoService {

    /**
     * 查询所有车型信息
     *
     * @return 返回CarInfo对象List
     */
    List<CarInfo> selectAll();

    /**
     * 设置分页显示
     *
     * @param pageNum  开始页数
     * @param pageSize 每页记录条数
     * @return 返回分页后的车辆信息的集合
     */
    PageInfo pagination(int pageNum, int pageSize);

    /**
     * 新增车辆
     *
     * @param carInfo 承载带插入条件的对象
     * @return 返回影响的数据库记录条数
     */
    int insertCar(CarInfo carInfo);

    /**
     * 通过车辆id查询车辆所有信息
     *
     * @param cId 车型ID(主键)
     * @return 返回该id车辆的所有信息
     */
    CarInfo selectById(Integer cId);

    /**
     * 更新车辆信息
     *
     * @param carInfo 承载带更新条件的对象
     * @return 返回影响的数据库记录条数
     */
    int updateCarInfo(CarInfo carInfo);

    /**
     * 删除单条车辆信息
     *
     * @param cId 需要删除的车辆id
     * @return 返回影响的数据库记录条数
     */
    Integer deleteCar(int cId);

    /**
     * 批量删除车辆信息
     *
     * @param cIds 需要删除的车辆id数组
     * @return 返回影响的数据库记录条数
     */
    int deleteCarBatch(String[] cIds);

    /**
     * 多条件查询
     *
     * @param carInfoVo 承载带查询条件的对象
     * @return 返回多条件查询结果list集合
     */
    List<CarInfo> selectConditions(CarInfoVo carInfoVo);

    /**
     * 进行多条件查询或者跳转到相应页码
     *
     * @param carInfoVo 承载带查询条件的对象
     * @param page      将要跳转到的页码
     * @return 返回多条件查询结果list集合或者相应页码记录的list集合
     */
    PageInfo selectConditionPagination(CarInfoVo carInfoVo, int page);
}
