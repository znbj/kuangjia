package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class UserDao {
    SqlSessionFactory sqlSessionFactory;


    public  UserDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory=sqlSessionFactory;
    }

    @Test
    public void findAll() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList = sqlSession.selectList("test.findAll");
        for (User user : userList) {
            System.out.println(user.getUsername());
        }
        sqlSession.close();
    }

    /**
     * 根据id查询
     */
    @Test
    public void findById() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        /*List<User> userList = sqlSession.selectList("test.findById", 1);
        for (User user : userList) {
            System.out.println(user.getUsername());
        }*/

        User o = sqlSession.selectOne("test.findById", 2);
        System.out.println(o.getUsername());
        sqlSession.close();

    }

    @Test
    public void saveUser() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setSex("女");
        user.setAge(18);
        user.setAddress("河南郑州");
        user.setBirthday(new Date());
        user.setUsername("古力娜扎");
        sqlSession.insert("test.saveUser",user);

        System.out.println(user.getId());//??????????????
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setId(1);
        user.setSex("女");
        user.setAge(18);
        user.setAddress("河南郑州");
        user.setBirthday(new Date());
        user.setUsername("古力娜扎");
        sqlSession.update("test.deleteUser",user);


        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser() {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.delete("test.deleteUser",2);


        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectLike() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> list = sqlSession.selectList("test.selectLike", "力");
        for (User user : list) {
            System.out.println(user.getUsername());

        }
        sqlSession.close();
    }


    @Test
    public void selectCount() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        Integer count = sqlSession.selectOne("test.selectCount");
        System.out.println(count);

        sqlSession.close();
    }

}
