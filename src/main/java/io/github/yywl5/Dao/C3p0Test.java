package io.github.yywl5.Dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * C3p0连接数据源
 * @author star
 *
 */
public class C3p0Test {
    public static void main(String[] args) throws Exception {
        //test1();
        test2();
    }

    private static void test1() throws SQLException, PropertyVetoException {
        // TODO Auto-generated method stub
        //创建连接池
        ComboPooledDataSource pool = new ComboPooledDataSource();

        //设置的连接的四大参数
        //
        pool.setDriverClass("com.mysql.cj.jdbc.Driver");
        pool.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/library");
        pool.setUser("jsp");
        pool.setPassword("1008611");
        //
        //获取连接
        Connection conn = pool.getConnection();
        String sql = "select * from Users ";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while(rs.next()) {
            System.out.println(rs.getString(1)+"   "+rs.getString(2));
        }
        rs.close();
        conn.close();
    }
    //使用配置文件
    /*
     * c3p0配置文件
     * 1.配置文件名称:c3p0-config.xml
     * 2.配置文件的位置一定要在类路径下
     */
    private static void test2() throws Exception {
        // TODO Auto-generated method stub
        //c3p0 创建连接池对象
        ComboPooledDataSource pool = new ComboPooledDataSource();
        //获取连接
        Connection conn = pool.getConnection();
        String sql = "select * from Users";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while(rs.next()){
            System.out.println(rs.getString(1)+"    "+rs.getString(2));
        }
        rs.close();
        conn.close();

    }

}
