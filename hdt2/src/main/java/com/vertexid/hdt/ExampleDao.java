package com.vertexid.hdt;

import org.apache.ibatis.annotations.Param;

public interface ExampleDao {

	String getUserName(@Param("userId") String userId);

}
