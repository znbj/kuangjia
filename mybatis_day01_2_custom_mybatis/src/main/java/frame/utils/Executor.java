package frame.utils;

import frame.domain.configuration;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 执行sql语句的工具
 */
public class Executor {

    private configuration cfg;
    private Connection conn=null;
    private PreparedStatement pst=null;
    private ResultSet rs=null;

    public Executor(configuration cfg) {
        this.cfg = cfg;
    }

    /**
     *执行查询语句  封装结果集 返回结果集
     * @return
     * @param resultType 返回值类型
     *
     * @param sql 执行的sql语句
     */
    public List executeQuery(String resultType, String sql) {

        //1.加载驱动
        try {
            Class.forName(cfg.getDriverClass());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2.获取连接
        try {
            conn = DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
            //3获取预处理对象
            pst = conn.prepareStatement(sql);
            //4执行sql语句
            rs = pst.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //5.封装结果集
        List<Object> list = new ArrayList<Object>();
        try {
            //5.1 先获取结果集元数据
            ResultSetMetaData metaData = rs.getMetaData();
            //5.2获取列的总数 创建列名的集合
            int columnCount = metaData.getColumnCount();
            List<String> columnNames = new ArrayList<String>();
            for (int i = 1; i <columnCount ; i++) {
                String columnName = metaData.getColumnName(i);
                columnNames.add(columnName);
            }

            //如果有 通过反射创建对象 封装对象
            Class clazz = Class.forName(resultType);
            while (rs.next()) {

                Object obj = clazz.newInstance();

                Method[] methods = clazz.getMethods();
                for (Method method : methods) {
                    for (String name : columnNames) {
                        if (method.getName().equalsIgnoreCase("set" + name)) {
                             method.invoke(obj, rs.getObject(name));
                        }

                    }

                }


                list.add(obj);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return list;
    }

    public void release() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (pst != null) {
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
