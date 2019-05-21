package com.cheer.mybatis.dao;

import com.cheer.mybatis.model.Emp;
import com.cheer.mybatis.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class EmpMapperTest {
    private static final Logger LOGGER = LogManager.getLogger(EmpMapperTest.class);

    @Test
    public void getEmp() {
        SqlSession session = MybatisUtils.getSqlSession();
        // 获取EmpMapper对象 代理对象
        EmpMapper empMapper = session.getMapper(EmpMapper.class);
        // 查询emp
        Emp emp = empMapper.getEmp(7369);

        //断言emp是否为空
        Assert.assertNotNull(emp);

        LOGGER.info(emp);

        MybatisUtils.closeSqlSession(session);
    }

    @Test
    public void insert() {
        SqlSession session = MybatisUtils.getSqlSession();
        // 获取EmpMapper对象
        EmpMapper empMapper = session.getMapper(EmpMapper.class);
        // 添加emp
        Emp emp = new Emp();
        emp.setEmpNo(1000);
        emp.setEname("jack");
        emp.setDeptNo(10);
        int result = empMapper.insert(emp);

        //断言result结果为1，
        Assert.assertEquals(1,result);

        MybatisUtils.closeSqlSession(session);
    }

    @Test
    public void update() {
        SqlSession session = MybatisUtils.getSqlSession();

        // 获取EmpMapper对象
        EmpMapper empMapper = session.getMapper(EmpMapper.class);
        // 更新emp
        Emp emp = new Emp();
        emp = empMapper.getEmp(1000);
        emp.setHireDate("1985-12-13");
        emp.setSal(4000.0);
        emp.setCom(101.0);
        empMapper.update(emp);

        MybatisUtils.closeSqlSession(session);
    }



    @Test
    public void delete() {
        SqlSession session = MybatisUtils.getSqlSession();

        // 获取EmpMapper对象
        EmpMapper empMapper = session.getMapper(EmpMapper.class);
        // 删除
        empMapper.delete(1000);

        MybatisUtils.closeSqlSession(session);
    }

    //一级缓存测试
    @Test
    public void cache(){

        SqlSession session = MybatisUtils.getSqlSession();
        //获取EmpMapper 对象
        EmpMapper empMapper = session.getMapper(EmpMapper.class);
        //查询emp
        Emp emp = empMapper.getEmp(7369);
        //此时不会去数据库查询，而是在一级缓存中查询
        Emp emp1 = empMapper.getEmp(7369);

        LOGGER.info(emp.hashCode());
        LOGGER.info(emp1.hashCode());

        MybatisUtils.closeSqlSession(session);
    }
}
