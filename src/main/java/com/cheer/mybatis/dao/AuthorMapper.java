package com.cheer.mybatis.dao;

import com.cheer.mybatis.model.Author;

import java.util.List;

public interface AuthorMapper {
    int updateAuthorIfNecessary(Author author);

    List<Author> selectAuthorIn(List<Integer> idList);
}
