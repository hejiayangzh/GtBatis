package com.gthree.test;

import com.gthree.gtbatis.session.SqlSession;
import com.gthree.gtbatis.session.SqlSessionFactory;
import com.gthree.gtbatis.session.SqlSessionFactoryBuilder;
import com.gthree.test.mapper.UserMapper;
import com.gthree.test.model.User;

import java.util.List;

/**
 * @Description
 * @Author Gthree
 * @Date 2019-12-24 10:42
 *
 * MyBatis的主要的核心部件：
 *
 * Configuration：MyBatis所有的配置信息都维持在Configuration对象之中，核心类；
 *
 * SqlSession：作为MyBatis工作的主要顶层API，表示和数据库交互的会话，完成必要数据库增删改查功能；
 *
 * Executor：MyBatis执行器，是MyBatis 调度的核心，负责SQL语句的生成和查询缓存的维护；
 *
 * StatementHandler：封装了JDBC Statement操作，负责对JDBC statement 的操作，如设置参数、将Statement结果集转换成List集合。
 *
 * ParameterHandler：负责对用户传递的参数转换成JDBC Statement 所需要的参数；
 *
 * ResultSetHandler：负责将JDBC返回的ResultSet结果集对象转换成List类型的集合；
 *
 * MappedStatement：MappedStatement维护了一条<select|update|delete|insert>节点的封装；
 *
 * MapperProxy和MapperProxyFactory：Mapper代理，使用原生的Proxy执行mapper里的方法。
 *
 */
public class TestGtBatis {

    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build("gtbatis.properties");
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getAll();
        System.out.println("users = " + userList);
        //userMapper.updateByPrimaryKey(1);
        userMapper.deleteByPrimaryKey(10);
    }
}
