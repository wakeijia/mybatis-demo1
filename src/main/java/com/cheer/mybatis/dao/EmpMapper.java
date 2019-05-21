package com.cheer.mybatis.dao;

import com.cheer.mybatis.model.Emp;

public interface EmpMapper {
    Emp getEmp(Integer empNo);

    int insert(Emp emp);

    int update(Emp emp);

    int delete(Integer empNo);
}
