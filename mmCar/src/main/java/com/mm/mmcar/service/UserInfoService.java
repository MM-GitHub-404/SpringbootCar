package com.mm.mmcar.service;

import com.github.pagehelper.PageInfo;
import com.mm.mmcar.entity.UserInfo;
import com.mm.mmcar.entity.UserInfo;
import com.mm.mmcar.entity.vo.UserInfoVo;
import com.mm.mmcar.entity.UserInfo;
import com.mm.mmcar.entity.vo.UserInfoVo;

import java.util.List;

/**
 * @author 茂茂
 * @create 2022-02-11 17:39
 */
public interface UserInfoService {

    /**
     * 查询所有用户信息
     *
     * @return 返回UserInfo对象List
     */
    List<UserInfo> selectAll();

    /**
     * 设置分页显示
     *
     * @param pageNum  开始页数
     * @param pageSize 每页记录条数
     * @return 返回分页后的用户信息的集合
     */
    PageInfo pagination(int pageNum, int pageSize);

    /**
     * 新增用户
     *
     * @param userInfo 承载带插入条件的对象
     * @return 返回影响的数据库记录条数
     */
    int insertUser(UserInfo userInfo);

    /**
     * 通过用户id查询用户所有信息
     *
     * @param cId 用户ID(主键)
     * @return 返回该id用户的所有信息
     */
    UserInfo selectById(Integer cId);

    /**
     * 更新用户信息
     *
     * @param userInfo 承载带更新条件的对象
     * @return 返回影响的数据库记录条数
     */
    int updateUserInfo(UserInfo userInfo);

    /**
     * 删除单个用户信息
     *
     * @param uId 需要删除的用户id
     * @return 返回影响的数据库记录条数
     */
    Integer deleteUser(int uId);

    /**
     * 批量删除用户信息
     *
     * @param uIds 需要删除的用户id数组
     * @return 返回影响的数据库记录条数
     */
    int deleteUserBatch(String[] uIds);

    /**
     * 多条件查询
     *
     * @param UserInfoVo 承载带查询条件的对象
     * @return 返回多条件查询结果list集合
     */
    List<UserInfo> selectConditions(UserInfoVo UserInfoVo);

    /**
     * 进行多条件查询或者跳转到相应页码
     *
     * @param UserInfoVo 承载带查询条件的对象
     * @param page      将要跳转到的页码
     * @return 返回多条件查询结果list集合或者相应页码记录的list集合
     */
    PageInfo selectConditionPagination(UserInfoVo userInfoVo, int page);
}
