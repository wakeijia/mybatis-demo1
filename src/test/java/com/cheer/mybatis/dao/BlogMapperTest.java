package com.cheer.mybatis.dao;

import com.cheer.mybatis.model.Blog;
import com.cheer.mybatis.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class BlogMapperTest {
    private SqlSession sqlSession;
    private BlogMapper blogMapper;
    @Before
    public void init(){
        sqlSession = MybatisUtils.getSqlSession();
        blogMapper = sqlSession.getMapper(BlogMapper.class);
    }

    @After
    public void destory(){
        MybatisUtils.closeSqlSession(sqlSession);
    }

    @Test
    public void findActiveBlogWithTitleLike(){
        List<Blog> blogList = blogMapper.findActiveBlogWithTitleLike("ACTIVE", "%贸易%");
        Assert.assertEquals(2, blogList.size());
        for (Blog blog : blogList) {
            System.out.println(blog);
        }

        List<Blog> blogList1 = blogMapper.findActiveBlogWithTitleLike("ACTIVE", null);
        Assert.assertEquals(2, blogList1.size());

        for (Blog blog : blogList1) {
            System.out.println(blog);
        }
    }

    @Test
    public void findActiveBlogLike() {
        // 构造参入列表
        Map<String, Object> params = new HashMap<>();
        params.put("state", "ACTIVE");
        params.put("title", "%贸易%");
        params.put("username", "KEITH");
        List<Blog> blogList = blogMapper.findActiveBlogLike(params);

        for (Blog blog : blogList) {
            System.out.println(blog);
        }

        Assert.assertEquals(1, blogList.size());

        Map<String, Object> params1 = new HashMap<>();
        params1.put("state", "ACTIVE");
        params1.put("username", "KEITH");
        List<Blog> blogList1 = blogMapper.findActiveBlogLike(params1);

        for (Blog blog : blogList1) {
            System.out.println(blog);
        }

        Assert.assertEquals(1, blogList1.size());
    }

    @Test
    public void findActiveBlogLike1() {
        // 构造参入列表
        Map<String, Object> params = new HashMap<>();
        params.put("state", "ACTIVE");
        params.put("title", "%贸易%");
        List<Blog> blogList = blogMapper.findActiveBlogLike1(params);

        for (Blog blog : blogList) {
            System.out.println(blog);
        }

        Assert.assertEquals(2, blogList.size());

        Map<String, Object> params1 = new HashMap<>();
        params1.put("state", "ACTIVE");
        params1.put("username", "KEITH");
        List<Blog> blogList1 = blogMapper.findActiveBlogLike1(params1);

        for (Blog blog : blogList1) {
            System.out.println(blog);
        }

        Assert.assertEquals(1, blogList1.size());
    }

    @Test
    public void findActiveBlogLike2() {
        // 构造参入列表
        List<Blog> blogList = blogMapper.findActiveBlogLike2(null);

        for (Blog blog : blogList) {
            System.out.println(blog);
        }

        Assert.assertEquals(3, blogList.size());

        Map<String, Object> params1 = new HashMap<>();
        params1.put("username", "KEITH");
        List<Blog> blogList1 = blogMapper.findActiveBlogLike2(params1);

        for (Blog blog : blogList1) {
            System.out.println(blog);
        }

        Assert.assertEquals(1, blogList1.size());
    }

}