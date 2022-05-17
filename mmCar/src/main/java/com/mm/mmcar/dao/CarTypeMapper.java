package com.mm.mmcar.dao;


import com.mm.mmcar.entity.CarType;
import com.mm.mmcar.entity.CarTypeExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface CarTypeMapper {
    int countByExample(CarTypeExample example);

    int deleteByExample(CarTypeExample example);

    int deleteByPrimaryKey(Integer typeId);

    int insert(CarType record);

    int insertSelective(CarType record);

    List<CarType> selectByExample(CarTypeExample example);

    CarType selectByPrimaryKey(Integer typeId);

    int updateByExampleSelective(@Param("record") CarType record, @Param("example") CarTypeExample example);

    int updateByExample(@Param("record") CarType record, @Param("example") CarTypeExample example);

    int updateByPrimaryKeySelective(CarType record);

    int updateByPrimaryKey(CarType record);
}