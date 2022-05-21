package com.mm.mmcar.service.impl;

import com.mm.mmcar.dao.AdminMapper;
import com.mm.mmcar.entity.Admin;
import com.mm.mmcar.entity.AdminExample;
import com.mm.mmcar.service.AdminService;
import com.mm.mmcar.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 茂茂
 * @create 2022-05-16 20:28
 */
@Service
public class AdminServiImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String userName, String passWord) {
        //首先创建对象,封装查询条件
        AdminExample ae = new AdminExample();
        if (userName==null){
            return null;
        }
        ae.createCriteria().andANameEqualTo(userName);
        List<Admin> list = adminMapper.selectByExample(ae);
        if (list.size() > 0) {
            Admin admin = list.get(0);
            //通过MD5Util加密后与数据库中密码对比
            String pw = MD5Util.getMD5(passWord);
            if (admin.getaPass().equals(pw)) {
                return admin;
            }
        }
        return null;
    }
}
