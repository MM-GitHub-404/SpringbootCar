package com.mm.mmcar.dao;

import com.mm.mmcar.entity.CarInfo;
import com.mm.mmcar.entity.CarInfoExample;
import com.mm.mmcar.entity.vo.CarInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface CarInfoMapper {
    int countByExample(CarInfoExample example);

    int deleteByExample(CarInfoExample example);

    int deleteByPrimaryKey(Integer cId);

    int insert(CarInfo record);

    int insertSelective(CarInfo record);

    List<CarInfo> selectByExample(CarInfoExample example);

    CarInfo selectByPrimaryKey(Integer cId);

    int updateByExampleSelective(@Param("record") CarInfo record, @Param("example") CarInfoExample example);

    int updateByExample(@Param("record") CarInfo record, @Param("example") CarInfoExample example);

    int updateByPrimaryKeySelective(CarInfo record);

    int updateByPrimaryKey(CarInfo record);

    int deleteCarBatch(String[] cars);

    List<CarInfo> selectConditions(CarInfoVo carInfoVo);
}