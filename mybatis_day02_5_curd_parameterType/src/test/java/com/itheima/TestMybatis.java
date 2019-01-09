package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMybatis {


    SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void testFindAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //通过getmapper获取某接口动态代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            System.out.println(user.getUsername());
        }
        sqlSession.close();
    }

    @Test
    public void testFindQueryVo() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //通过getmapper获取某接口动态代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        QueryVo queryVo=new QueryVo();
        User user = new User();
        queryVo.setStartIndex(1);
        queryVo.setPageSize(2);
        user.setUsername("力");
        queryVo.setUser(user);

        List<User> byQueryVo = userDao.findByQueryVo(queryVo);
        for (User user1  : byQueryVo) {
            System.out.println(user1.getUsername());
        }


        sqlSession.close();

    }

    @Test
    public void testFindid() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //通过getmapper获取某接口动态代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User byId = userDao.findById(3);
        System.out.println(byId.getUsername());
        sqlSession.close();
    }



    @Test
    public void testFindUsers() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //通过getmapper获取某接口动态代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.findUsers(1, 2, "力");


        for (User user  : userList) {
            System.out.println(user.getUsername());
        }


        sqlSession.close();

    }

    @Test
    public void testFindMap() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //通过getmapper获取某接口动态代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startIndex", 1);
        map.put("pageSize", 1);
        map.put("name", "力");


        List<User> byMap = userDao.findByMap(map);


        for (User user  : byMap) {
            System.out.println(user.getUsername());
        }


        sqlSession.close();

    }
}
