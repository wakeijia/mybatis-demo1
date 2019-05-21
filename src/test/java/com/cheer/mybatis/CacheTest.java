package com.cheer.mybatis;

import com.cheer.mybatis.dao.EmpMapper;
import com.cheer.mybatis.model.Emp;
import com.cheer.mybatis.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

//二级缓存测试
public class CacheTest {
    public static void main(String[] args) {
        //创建了线程并且实现了run方法
       Thread thread = new Thread(()->{
           try {
               System.out.println("睡眠中");
               Thread.sleep(10*1000);
               System.out.println("睡眠结束");
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           SqlSession sqlSession = MybatisUtils.getSqlSession();
           EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
           Emp emp = empMapper.getEmp(7369);
           System.out.println(emp);
           System.out.println(emp.hashCode());
           MybatisUtils.closeSqlSession(sqlSession);
       });

        //创建了线程并且实现了run方法
        Thread thread1 = new Thread(()->{
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
            Emp emp = empMapper.getEmp(7369);
            System.out.println(emp);
            System.out.println(emp.hashCode());
            MybatisUtils.closeSqlSession(sqlSession);
        });

        //启动线程
        thread.start();
        thread1.start();
    }
}