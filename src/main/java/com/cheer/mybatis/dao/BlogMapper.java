package com.cheer.mybatis.dao;

import com.cheer.mybatis.model.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    List<Blog> findActiveBlogWithTitleLike(@Param("state") String state, @Param("title") String title);

    List<Blog> findActiveBlogLike(Map<String, Object> params);

    List<Blog> findActiveBlogLike1(Map<String, Object> params);

    List<Blog> findActiveBlogLike2(Map<String, Object> params);

}
