package com.mm.mmcar.service.impl;

import com.mm.mmcar.dao.CarTypeMapper;
import com.mm.mmcar.dao.UserTypeMapper;
import com.mm.mmcar.entity.CarType;
import com.mm.mmcar.entity.CarTypeExample;
import com.mm.mmcar.entity.UserType;
import com.mm.mmcar.entity.UserTypeExample;
import com.mm.mmcar.service.CarTypeSevice;
import com.mm.mmcar.service.UserTypeSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 茂茂
 * @create 2022-02-12 13:45
 */
@Service("UserTypeSeviceImpl")
public class UserTypeSeviceImpl implements UserTypeSevice {

    @Autowired
    UserTypeMapper userTypeMapper;

    @Override
    public List<UserType> selectAllType() {
        return userTypeMapper.selectByExample(new UserTypeExample());
    }

}
