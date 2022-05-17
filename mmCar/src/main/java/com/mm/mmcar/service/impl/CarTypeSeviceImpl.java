package com.mm.mmcar.service.impl;

import com.mm.mmcar.dao.CarTypeMapper;
import com.mm.mmcar.entity.CarType;
import com.mm.mmcar.entity.CarTypeExample;
import com.mm.mmcar.service.CarTypeSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 茂茂
 * @create 2022-02-12 13:45
 */
@Service//("CarTypeSeviceImpl")
public class CarTypeSeviceImpl implements CarTypeSevice {

    @Autowired
    CarTypeMapper carTypeMapper;

    @Override
    public List<CarType> selectAllType() {
        return carTypeMapper.selectByExample(new CarTypeExample());
    }

}
