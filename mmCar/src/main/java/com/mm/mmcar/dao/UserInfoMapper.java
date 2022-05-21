package com.mm.mmcar.dao;

import com.mm.mmcar.entity.CarInfo;
import com.mm.mmcar.entity.UserInfo;
import com.mm.mmcar.entity.UserInfoExample;
import java.util.List;

import com.mm.mmcar.entity.vo.CarInfoVo;
import com.mm.mmcar.entity.vo.UserInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UserInfoMapper {
    long countByExample(UserInfoExample example);

    int deleteByExample(UserInfoExample example);

    int deleteByPrimaryKey(Integer uId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectByExample(UserInfoExample example);

    UserInfo selectByPrimaryKey(Integer uId);

    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    int deleteUserBatch(String[] Users);

    List<UserInfo> selectConditions(UserInfoVo userInfoVo);
}