package com.vertexid.hdt;

import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface ExampleDao {

	String getUserName(@Param("userId") String userId);
	
	int insertUser(UserVo userVo);
	int updateUser(UserVo userVo);
	int deleteUser(UserVo userVo);
	UserVo getUser(UserVo userVo);
	List<UserVo> selectUser(@Param("userName") String userName);
}