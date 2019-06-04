package com.cheer.mybatis.dao;

import com.cheer.mybatis.model.Author;
import com.cheer.mybatis.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AuthorMapperTest {
    @Test
    public void updateAuthorIfNecessary(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AuthorMapper authorMapper = sqlSession.getMapper(AuthorMapper.class);
        Author author = new Author();
        author.setId(1);
        author.setUsername("KKKKK");
        author.setBio("三年java开发经验");
        int result = authorMapper.updateAuthorIfNecessary(author);

        Assert.assertEquals(1, result);
        MybatisUtils.closeSqlSession(sqlSession);
    }

    @Test
    public void selectAuthorIn(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AuthorMapper authorMapper = sqlSession.getMapper(AuthorMapper.class);
        List<Integer> idList = new ArrayList<>(Arrays.asList(1,2,3));
        List<Author> authorList = authorMapper.selectAuthorIn(idList);
        Assert.assertEquals(3,authorList.size());
        MybatisUtils.closeSqlSession(sqlSession);
        for (Author author : authorList) {
            System.out.println(author);
        }
    }

}
