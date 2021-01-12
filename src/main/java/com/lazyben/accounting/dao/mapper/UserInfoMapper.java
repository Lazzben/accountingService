package com.lazyben.accounting.dao.mapper;

import com.lazyben.accounting.model.persistence.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {
    @Select("SELECT * FROM as_userinfo WHERE id = #{id}")
    UserInfo getUserInfoById(@Param("id") long id);
}
