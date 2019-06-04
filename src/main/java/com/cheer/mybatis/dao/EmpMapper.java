package com.cheer.mybatis.dao;

import com.cheer.mybatis.model.Emp;

import java.util.List;
import java.util.Map;

public interface EmpMapper {
    Emp getEmp(Integer empNo);

    int insert(Emp emp);

    int update(Emp emp);

    int delete(Integer empNo);

    List<Emp> getPageList();

    Map<String, Object> getEmpMap(Integer empNo);

    Emp getEmpResultMap(Integer empNo);

    List<Emp> getList();
}
