package io.github.potatob6.Models;

import io.github.potatob6.Annos.SQLSeq;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

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
        driver = Class.forName("com.mysql.cj.jdbc.Driver");
    }

    private Connection getConnection() throws SQLException {
        if(this.conn != null){
            return this.conn;
        }else{
            this.conn = DriverManager.getConnection("jdbc:mysql://175.178.183.203:3306/library", "jsp", "1008611");
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
     * 添加图书
     * @param bookBean  图书Bean
     * @return
     */
    public boolean addBook(BookBean bookBean) {
        Connection connection = null;
        try {
            connection = this.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Book values(?,?,?,?,?,?,?);");
            Class cl = bookBean.getClass();
            setupPreparedStatement(cl, preparedStatement, bookBean);
            int result = preparedStatement.executeUpdate();
            System.out.println("影响行数:"+result);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 添加图书类别
     * @param bookClassBean  图书类别Bean
     * @return
     */
    public boolean addBookClass(BookClassBean bookClassBean) {
        try{
            Connection connection = this.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into BookClass values(?,?);");
            Class cl = bookClassBean.getClass();
            setupPreparedStatement(cl, preparedStatement, bookClassBean);
            int result = preparedStatement.executeUpdate();
            System.out.println("影响行数:"+result);
            return true;
        } catch (SQLException throwables) {
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
            if(annotation!=null){
                if(fieldType==String.class) {
                    preparedStatement.setString(order, (String)(value));
                }else if(fieldType==double.class){
                    preparedStatement.setDouble(order, (double)(value));
                }else if(fieldType==int.class){
                    preparedStatement.setInt(order, (int)(value));
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

    /**
     * 查询特定的用户通过用户ID
     * @param userBean  用户Bean，需要提供userID属性
     * @return          返回 {@link UserBean}
     */
    public UserBean querySpecificUserByUserID(UserBean userBean){
        String userName = userBean.getUserID();
        try {
            Connection connection = this.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from Users where userID=\"?\"");
            preparedStatement.setString(1, userName);

            ResultSet resultSet = preparedStatement.executeQuery();
            UserBean userBean1 = null;
            while(resultSet.next()){

            }
            return userBean1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    private ArrayList<Object> fullSetupMultiByQuery(ResultSet resultSet, Class cl) throws SQLException {
        ArrayList<Object> arrayList = new ArrayList<>();
        while(resultSet.next()){

        }
    }

    /**
     * 通过反射装配全一个Bean,即{@link ResultSet}返回的列数要与Bean中SQLSeq定义的数量一样
     * @param resultSet  {@link ResultSet}结果集
     * @param cl         {@link Class} Bean的类型
     * @return           {@link Object} 装配好的Bean，可以直接强制转换为需要的Bean类型
     */
    private Object fullSetupSingleByQuery(ResultSet resultSet, Class cl) {
        try {
            Object bean = cl.getDeclaredConstructor().newInstance();
            Field[] fields = cl.getFields();
            for(int i = 0;i<fields.length;i++){
                SQLSeq annotation = fields[i].getAnnotation(SQLSeq.class);
                Class fieldType = fields[i].getType();
                if(annotation!=null){
                    int order = annotation.order();
                    if(fieldType==String.class) {
                        fields[i].set(bean, resultSet.getString(order));
                    }else if(fieldType==double.class){
                        fields[i].setDouble(bean, resultSet.getDouble(order));
                    }else if(fieldType==int.class){
                        fields[i].setInt(bean, resultSet.getInt(order));
                    }else if(fieldType==java.sql.Date.class){
                        fields[i].set(bean, resultSet.getDate(order));
                    }else if(fieldType==BigDecimal.class){
                        fields[i].set(bean, resultSet.getBigDecimal(order));
                    }else if(fieldType==boolean.class){
                        fields[i].setBoolean(bean, resultSet.getBoolean(order));
                    }
                }
            }
            return bean;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
