package com.cheer.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {
    //保证系统中有且只有一个factory实列
    private static  SqlSessionFactory sqlSessionFactory;

    //静态块 在静态变量初始化完之后执行，只被执行一次
    static {
        InputStream in = null;
        try {
            // 导入mybatis的配置文件 mybatis-config.xml
            in = Resources.getResourceAsStream("mybatis-config.xml");
            // 创建一个SqlSessionFactory对象
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 打开SqlSession
     * @return
     */
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

    /**
     * 关闭SqlSession
     * @param sqlSession
     */
    public static void closeSqlSession(SqlSession sqlSession){
        sqlSession.commit();
        sqlSession.close();
    }
}
