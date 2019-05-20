package com.cheer.mybatis.dao;

import com.cheer.mybatis.model.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class EmpMapperTest{
    private static final Logger LOGGER = LogManager.getLogger(EmpMapperTest.class);

    @Test
    public void getEmp(){
        InputStream in = null;
        try {
            // 导入mybatis的配置文件 mybatis-config.xml
            in = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 创建一个SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 打开一个会话
        SqlSession session = factory.openSession();
        // 获取EmpMapper对象
        EmpMapper empMapper = session.getMapper(EmpMapper.class);
        // 查询emp
        Emp emp = empMapper.getEmp(7369);
        LOGGER.info(emp);

        try {
            if (in!=null){
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
