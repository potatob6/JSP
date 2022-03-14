package io.github.potatob6.Models;

import io.github.potatob6.Annos.SQLSeq;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.*;

public class OurDatabase {
    private static OurDatabase db = null;
    private static Class driver = null;
    private Connection conn = null;
    /**
     * 获取数据库
     */
    public static OurDatabase getDataBase() {
        if (db == null) {
            synchronized (OurDatabase.class) {
                if (db == null) {
                    try {
                        db = new OurDatabase();
                    }catch (ClassNotFoundException|SQLException e){
                        db = null;
                        driver = null;
                        System.out.println("数据库连接错误");
                    }
                }
            }
        }
        return db;
    }

    private OurDatabase() throws ClassNotFoundException, SQLException {
        driver = Class.forName("com.mysql.jdbc.Driver");
    }

    private Connection getConnection() throws SQLException {
        if(this.conn != null){
            return this.conn;
        }else{
            this.conn = DriverManager.getConnection("jdbc:mysql://1.116.21.195:3306/library", "jsp", "1008611");
            return this.conn;
        }
    }

    /**
     * 添加用户
     * @param userBean 用户Bean
     * @return 是否成功
     */
    public boolean addUser(UserBean userBean){
        try {
            Connection connection = this.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Users values(?,?,?,?,?,?);" );
            Class cl = userBean.getClass();
            setupPreparedStatement(cl, preparedStatement, userBean);
            int result = preparedStatement.executeUpdate();
            System.out.println("影响行数:"+result);
            return true;
        } catch (SQLException throwables) {
            this.conn = null;
            throwables.printStackTrace();
            return false;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 通过反射装配好PreparedStatement
     * @param cl                 类对象
     * @param preparedStatement  预处理statement
     */
    private void setupPreparedStatement(Class cl, PreparedStatement preparedStatement, Object bean) throws SQLException, IllegalAccessException {
        Field[] fields = cl.getDeclaredFields();
        for(int i = 0;i<fields.length;i++){
            Annotation annotation = fields[i].getAnnotation(SQLSeq.class);
            Class fieldType = fields[i].getType();
            int order = ((SQLSeq) annotation).order();
            Object value = fields[i].get(bean);
            System.out.println("order:"+order+",fieldName:"+fields[i].getName()+",value:"+value+",fieldType:"+fieldType);
            if(annotation!=null){
                if(fieldType==String.class) {
                    preparedStatement.setString(order, (String)(value));
                }else if(fieldType==Double.class){
                    preparedStatement.setDouble(order, (Double)(value));
                }else if(fieldType==Integer.class){
                    preparedStatement.setInt(order, (Integer)(value));
                }else if(fieldType==java.sql.Date.class){
                    preparedStatement.setDate(order, (java.sql.Date)(value));
                }else if(fieldType==BigDecimal.class){
                    preparedStatement.setBigDecimal(order, (BigDecimal) (value));
                }else if(fieldType==boolean.class){
                    preparedStatement.setBoolean(order, (boolean) (value));
                }
            }
        }
    }
}