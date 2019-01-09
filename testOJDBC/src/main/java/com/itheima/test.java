package com.itheima;


import oracle.jdbc.driver.OracleTypes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class test {
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@192.168.174.129:1521:orcl";
    String username = "scott";
    String password = "tiger";
    Connection conn;
    PreparedStatement pst;
    CallableStatement cst;
    ResultSet rs;




    @Before
    public void init() throws Exception{
        Class.forName(driver);
        conn =  DriverManager.getConnection(url,username,password);
    }

    @Test
    public void testOJDBC() throws Exception {


        pst = conn.prepareStatement("select * from emp");
        rs = pst.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt("empno")+"--"+rs.getString("ename"));
        }
    }
    /**
     * 测试存储过程
     * create or replace procedure getYearSal(eno in number ,yearsal out number)
     *{call <procedure-name>[(<arg1>,<arg2>, ...)]}
     */
    @Test
    public void testProducer()  throws Exception{
        //1. sql
        String sql = "{call getYearSal(?,?)}";
        //2. 创建Statement对象
        cst = conn.prepareCall(sql);
        // 3.1 设置输入占位符
        cst.setInt(1, 7788);
        // 3.2 设置输出占位符
        cst.registerOutParameter(2, OracleTypes.NUMBER);
        //4. 执行sql语句
        cst.executeUpdate();
        //5. 处理结果集
        int yearsal = cst.getInt(2);
        System.out.println("年薪："+yearsal);

    }

    /**
     * 测试存储过程
     * create or replace procedure getEmpsByDeptno(dno in number ,emps out sys_refcursor)
     *{call <procedure-name>[(<arg1>,<arg2>, ...)]}
     */
    @Test
    public void testProcedureOutCursor()  throws Exception{
        String sql="{call getEmpsByDeptno(?,?)}";
        cst=conn.prepareCall(sql);
        cst.setInt(1, 20);
        cst.registerOutParameter(2,OracleTypes.CURSOR);
        cst.executeUpdate();
        Object object = cst.getObject(2);
        rs = (ResultSet) object;
        while (rs.next()) {
            System.out.println(rs.getInt("empno---") + rs.getString("--ename"));
        }

    }
    /**
     * 测试访问存储函数
     * create or replace function getYearSalFun(eno in number) return number
     * {?= call <procedure-name>[(<arg1>,<arg2>, ...)]}
     */
    @Test
    public void testFunction()  throws Exception{
        String sql="{?= call getYearSalFun(?)}";
        cst=conn.prepareCall(sql);
        cst.registerOutParameter(1,OracleTypes.NUMBER);
        cst.setInt(2, 7788);
        cst.executeUpdate();
        int yearSal = cst.getInt(1);
        System.out.println(yearSal);

    }

    @After
    public void after() throws Exception{
        if(rs != null){
            rs.close();
        }
        if(pst != null){
            pst.close();
        }
        if(cst != null){
            cst.close();
        }
        if(conn != null){
            conn.close();
        }
    }
}
