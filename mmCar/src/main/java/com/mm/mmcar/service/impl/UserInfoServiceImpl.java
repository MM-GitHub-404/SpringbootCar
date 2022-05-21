package com.mm.mmcar.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mm.mmcar.dao.UserInfoMapper;
import com.mm.mmcar.entity.UserInfo;
import com.mm.mmcar.entity.UserInfoExample;
import com.mm.mmcar.entity.vo.UserInfoVo;
import com.mm.mmcar.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 茂茂
 * @create 2022-02-11 17:41
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<UserInfo> selectAll() {
        //selectByExample方法参数为UserInfoExample类型
        return userInfoMapper.selectByExample(new UserInfoExample());
    }

    @Override
    public PageInfo pagination(int pageNum, int pageSize) {
        //优先使用PageHelper工具类进行分页设置
        PageHelper.startPage(pageNum, pageSize);
        UserInfoExample UserInfoExample = new UserInfoExample();
        //设置倒序查询语句
        UserInfoExample.setOrderByClause("u_id desc");
        //查询所有用户记录,装入list集合
        List<UserInfo> list = userInfoMapper.selectByExample(UserInfoExample);
        return new PageInfo<>(list);
    }

    @Override
    @Transactional
    public int insertUser(UserInfo UserInfo) {
        return userInfoMapper.insert(UserInfo);
    }

    @Override
    public UserInfo selectById(Integer cId) {
        return userInfoMapper.selectByPrimaryKey(cId);
    }

    @Override
    @Transactional
    public int updateUserInfo(UserInfo UserInfo) {
        return userInfoMapper.updateByPrimaryKey(UserInfo);
    }

    @Override
    @Transactional
    public Integer deleteUser(int cId) {
        return userInfoMapper.deleteByPrimaryKey(cId);
    }

    @Override
    @Transactional
    public int deleteUserBatch(String[] cIds) {
        return userInfoMapper.deleteUserBatch(cIds);
    }

    @Override
    public PageInfo<UserInfo> selectConditionPagination(UserInfoVo UserInfoVo, int page) {
        //优先使用PageHelper工具类进行分页设置
        PageHelper.startPage(UserInfoVo.getPage(), page);
        //调用多条件查询sql获取符合条件的用户信息列表
        List<UserInfo> list = userInfoMapper.selectConditions(UserInfoVo);
        return new PageInfo<>(list);
    }

    @Override
    public List<UserInfo> selectConditions(UserInfoVo UserInfoVo) {
        //按条件查询
        return userInfoMapper.selectConditions(UserInfoVo);
    }

}
