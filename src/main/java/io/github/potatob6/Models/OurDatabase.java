package io.github.potatob6.Models;

import io.github.potatob6.Annos.AutoIncrement;
import io.github.potatob6.Annos.PrimaryKey;
import io.github.potatob6.Annos.SQLSeq;
import io.github.potatob6.Annos.TableName;
import io.github.yywl5.Models.ManagerBean;
//import sun.tools.jconsole.Tab;

import java.awt.print.Book;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.*;
import java.sql.Date;
import java.util.*;

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

    public Connection getConnection() throws SQLException {
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
     * 添加图书
     * @param bookBean  图书Bean
     * @return
     */
    public boolean addBook(BookBean bookBean) {
        Connection connection = null;
        try {
            connection = this.getConnection();
            String sql = "insert into Book(%s,%s,%s,%s,%s,%s) values(%s,%s,%s,%s,%s,%s);";
            String[] params = new String[12];
            Statement statement = connection.createStatement();
            Class cl = bookBean.getClass();
            setupStatement(cl, params, bookBean,true);
            Formatter formatter = new Formatter();
            formatter.format(sql, params);
            int result = statement.executeUpdate(formatter.out().toString());
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
            String sql = "insert into BookClass(%s) values('%s');";
            String[] params = new String[2];
//            PreparedStatement preparedStatement = connection.prepareStatement("insert into BookClass(?) values(?);");
            Statement statement = connection.createStatement();
            Class cl = bookClassBean.getClass();
            setupStatement(cl, params, bookClassBean,true);
            Formatter formatter = new Formatter();
            formatter.format(sql, params);
            System.out.println(formatter.out().toString());
            int result = statement.executeUpdate(formatter.out().toString());
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
     * 通过反射装配好除了auto_increment之外的数据
     * @param cl
     * @param params
     * @param bean
     * @throws SQLException
     * @throws IllegalAccessException
     */
    private void setupStatement(Class cl, String[] params, Object bean, boolean withoutAutoincrement) throws SQLException, IllegalAccessException {
        Field[] fields = cl.getDeclaredFields();
        int field_needs = fields.length;
        if(withoutAutoincrement){
            for(int i = 0;i<fields.length;i++){
                Annotation autoIncrementAnno = fields[i].getAnnotation(AutoIncrement.class);
                if(autoIncrementAnno!=null){
                    field_needs--;
                }
            }
        }
        System.out.println("not incre:"+field_needs);
        int j = 0;
        for(int i = 0;i<fields.length;i++){
            System.out.println("field_needs:"+field_needs+", j:"+j);
            Annotation annotation = fields[i].getAnnotation(SQLSeq.class);
            Annotation autoanno = fields[i].getAnnotation(AutoIncrement.class);
            if(withoutAutoincrement) {
                if (autoanno != null) {
                    continue;
                }
            }
            Class fieldType = fields[i].getType();
            int order = ((SQLSeq) annotation).order();
            Object value = fields[i].get(bean);
            String propertyName = fields[i].getName();
            System.out.println("propertyName:"+propertyName+", value:"+value);
            if(annotation!=null){
                params[j] = propertyName;
                if(value==null){
                    params[field_needs+j] = "NULL";
                    j++;
                    continue;
                }
//                preparedStatement.setString(j+1, propertyName);
                if(fieldType==String.class) {
                    params[field_needs+j] = "'"+(String)value+"'";
//                    preparedStatement.setString(field_needs+j+1, (String)(value));
                }else if(fieldType==double.class){
                    params[field_needs+j] = "'"+String.valueOf((double)value)+"'";
//                    preparedStatement.setDouble(field_needs+j+1, (double)(value));
                }else if(fieldType==int.class){
                    params[field_needs+j] = "'"+String.valueOf((int)value)+"'";
//                    preparedStatement.setInt(field_needs+j+1, (int)(value));
                }else if(fieldType==java.sql.Date.class){
                    params[field_needs+j] = "'"+((java.sql.Date)value).toString()+"'";
//                    preparedStatement.setDate(field_needs+j+1, (java.sql.Date)(value));
                }else if(fieldType==BigDecimal.class){
                    params[field_needs+j] = "'"+((BigDecimal)value).toString()+"'";
//                    preparedStatement.setBigDecimal(field_needs+j+1, (BigDecimal) (value));
                }else if(fieldType==boolean.class){
                    params[field_needs+j] = "'"+String.valueOf((boolean) value)+"'";
//                    preparedStatement.setBoolean(field_needs+j+1, (boolean) (value));
                }
            }
            j++;
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
     * @param ManagerBean  Bean，需要提供userID属性
     * @return          返回 {@link ManagerBean}
     */
    public ManagerBean querySpecificManagerByUserID(ManagerBean ManagerBean){
        String ManagerName = ManagerBean.getUserID();
        try {
            Connection connection = this.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from Administrator where userID=?");
            preparedStatement.setString(1, ManagerName);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                ManagerBean managerBean1 = (ManagerBean) fullSetupSingleByQuery(resultSet, ManagerBean.class);
                return managerBean1;
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
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
            PreparedStatement preparedStatement = connection.prepareStatement("select * from Users where userID=?");
            preparedStatement.setString(1, userName);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                UserBean userBean1 = (UserBean) fullSetupSingleByQuery(resultSet, UserBean.class);
                return userBean1;
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    public ArrayList<Object> fullSetupMultiByQuery(ResultSet resultSet, Class cl) throws SQLException {
        ArrayList<Object> arrayList = new ArrayList<>();
        while(resultSet.next()){
            Object object = fullSetupSingleByQuery(resultSet, cl);
            arrayList.add(object);
        }
        return arrayList;
    }

    /**
     * 通过反射装配全一个Bean,即{@link ResultSet}返回的列数要与Bean中SQLSeq定义的数量一样
     * @param resultSet  {@link ResultSet}结果集
     * @param cl         {@link Class} Bean的类型
     * @return           {@link Object} 装配好的Bean，可以直接强制转换为需要的Bean类型
     */
    public Object fullSetupSingleByQuery(ResultSet resultSet, Class cl) {
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

    /**
     * 查询所有图书信息
     * @return
     */
    public ResultSet queryAllBook(){
        Connection connection = null;
        try {
            connection = this.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from Book;");
            ResultSet result = preparedStatement.executeQuery();
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    /**
     * 查询一个用户的借阅情况，
     * @param userBean  需要提供对应用户的userBean，其中userID必须要填，
     * @return          返回一个{@link BorrowWithBookBean}的集合，具体属性可以看BorrowWithBookBean的属性
     */
    public ArrayList<BorrowWithBookBean> queryUserAllBorrowed(UserBean userBean) {
        try {
            Connection connection = this.getConnection();
            Statement statement = conn.createStatement();
            String sql = "select borrowID, Book.bookID, userID, borrowDate, timeLimit, returnedDate, overtimeCharge, bookName from Borrow, Book where Borrow.bookID=Book.bookID and userID='"+userBean.userID+"';";
            ResultSet resultSet = statement.executeQuery(sql);
            ArrayList<Object> borrowWithBookBeans_obj = fullSetupMultiByQuery(resultSet, BorrowWithBookBean.class);
//            ArrayList<BorrowWithBookBean> borrowWithBookBeans = (ArrayList<BorrowWithBookBean>) statement.executeQuery(sql);
            ArrayList<BorrowWithBookBean> borrowWithBookBeans = new ArrayList<>();
            for(int i = 0;i<borrowWithBookBeans_obj.size();i++){
                borrowWithBookBeans.add((BorrowWithBookBean)borrowWithBookBeans_obj.get(i));
            }
            return borrowWithBookBeans;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    /**
     * 向数据库插入一行，自动屏蔽auto_increment字段，插入的表和字段属性都是根据Bean自动生成
     * @param object                    对象要为Bean类型，例如UserBean, BookBean，不然会错误
     * @param beanClass                 Bean的Class类型
     * @param withoutAutoIncrement      是否需要屏蔽自增属性
     * @return                          返回执行状态
     * 用法：
     *      OurDatabase our = OurDatabase.getDataBase();
     *      BookBean bookBean = new BookBean();
     *      bookBean.setBookName("图书");
     *      bookBean.setOriginPrice(new BigDecimal("70.40"));
     *      boolean result = our.insert(bookBean, BookBean.class, true);
     *      System.out.println("插入状态:"+result);
     */
    public boolean insert(Object object, Class beanClass, boolean withoutAutoIncrement){
        Annotation tableNameAnno = beanClass.getAnnotation(TableName.class);
        if(tableNameAnno==null){
            System.err.println("错误：Bean类型非数据库中的表");
            return false;
        }
        String tableName = ((TableName)tableNameAnno).name();
        Field[] fields = beanClass.getDeclaredFields();
        int field_needs = fields.length;
        if(withoutAutoIncrement){
            for(int i = 0;i<fields.length;i++){
                if(fields[i].getAnnotation(AutoIncrement.class)!=null){
                    field_needs--;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder("insert into ");
        stringBuilder.append(tableName);
        stringBuilder.append("(");
        for(int i = 0;i<field_needs;i++)
        {
            stringBuilder.append("%s");
            if(i!=field_needs-1)
                stringBuilder.append(",");
        }
        stringBuilder.append(") values(");
        for(int i = 0;i<field_needs;i++)
        {
            stringBuilder.append("%s");
            if(i!=field_needs-1)
                stringBuilder.append(",");
        }
        stringBuilder.append(");");
        String[] params = new String[field_needs*2];
        try {
            String sql = stringBuilder.toString();
            Connection connection = this.getConnection();
            Statement statement = connection.createStatement();
            setupStatement(beanClass, params, object, withoutAutoIncrement);
            Formatter formatter = new Formatter();
            formatter.format(sql, params);
            System.out.println(formatter.out().toString());
            int result = statement.executeUpdate(formatter.out().toString());
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 查询数据库中的Bean,其中传入的Bean的所有主键必须要填
     * @param object  Bean对象
     * @param cl      Bean对象所属类
     * @return        完整的Bean对象
     * 用法：
     *             OurDatabase our = OurDatabase.getDataBase();
     *             BorrowBean borrowBean = new BorrowBean();
     *             borrowBean.setBorrowID(1);
     *             borrowBean.setBookID(2);
     *             borrowBean.setUserID("1");
     *             borrowBean.setBorrowDate(Date.valueOf("2022-03-16"));
     *             borrowBean.setTimeLimit(60);
     *             BorrowBean result = (BorrowBean)(our.queryBean(borrowBean, BookBean.class));
     *             if(result==null)
     *             {
     *                 System.out.println("无还书日期");
     *             }
     *             System.out.println("查询到的还书日期为："+result.getReturnedDate());
     */
    public Object queryBean(Object object, Class cl){
        Annotation classAnnotation = cl.getAnnotation(TableName.class);
        if(classAnnotation==null){
            return null;
        }
        ArrayList<Field> arrayList = new ArrayList<Field>();
        Field[] fields = cl.getDeclaredFields();
        for(int i = 0;i<fields.length;i++){
            if(fields[i].getAnnotation(PrimaryKey.class)!=null){
                arrayList.add(fields[i]);
            }
        }
        try{
            StringBuilder stringBuilder = new StringBuilder("select * from ");
            stringBuilder.append(((TableName)classAnnotation).name());
            stringBuilder.append(" where ");
            for(int i = 0;i<arrayList.size();i++){
                Field field = arrayList.get(i);
                Object value = field.get(object);
                stringBuilder.append(field.getName());
                if(value==null){
                    stringBuilder.append(" is null ");
                }else{
                    stringBuilder.append("=");
                    stringBuilder.append("'"+value.toString()+"'");
                }

                if(i!=arrayList.size()-1){
                    stringBuilder.append(" and ");
                }
            }
            stringBuilder.append(";");
            Object o = null;
            Connection connection = this.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(stringBuilder.toString());
            if(resultSet.next()) {
                o = fullSetupSingleByQuery(resultSet, cl);
            }
            return o;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 借书操作
     * @param userBean    {@link UserBean} 用户Bean
     * @param bookBean    {@link BookBean} 图书Bean
     * @return            返回借书是否成功
     */
    public boolean borrowABook(UserBean userBean, BookBean bookBean){
        synchronized (OurDatabase.class){
            BookBean queryBook = (BookBean) this.queryBean(bookBean, BookBean.class);
            if(queryBook.getStorageCount()==0){
                //没书了
                return false;
            }
            //TODO
        }
        return false;
    }

    /**
     * 更新Bean，bean中的主键要有，可以通过CopyBean拷贝一份，更新会更新所有属性
     * @param bean            更新的Bean
     * @param cl              Bean的Class
     * @param withPrimaryKey  是否连同主键一起更新
     * @return                返回更新是否成功
     * 用法：
     *         OurDatabase our = OurDatabase.getDataBase();
     *         BookClassBean bcb = new BookClassBean();
     *         bcb.setClassID(11);
     *         bcb.setClassName("图书类别名");
     *
     *         our.updateBean(bcb, BookClassBean.class, false);
     */
    public boolean updateBean(Object bean, Class cl, boolean withPrimaryKey){
        Annotation tableAnnotation = cl.getAnnotation(TableName.class);
        if(tableAnnotation==null){
            return false;
        }
        String tableName = ((TableName)tableAnnotation).name();
        try {

            Connection connection = this.getConnection();
            Field[] fields = cl.getDeclaredFields();
            Map<Field, Object> primaryFields = new HashMap<Field, Object>();
            Map<Field, Object> changeFields = new HashMap<Field, Object>();
            //获取全部主键
            for(int i = 0;i<fields.length;i++){
                Annotation isSQLProperty = fields[i].getAnnotation(SQLSeq.class);
                if(isSQLProperty==null){
                    continue;
                }
                Annotation isPrimaryAnnotation = fields[i].getAnnotation(PrimaryKey.class);

                if(isPrimaryAnnotation!=null) {
                    primaryFields.put(fields[i], fields[i].get(bean));
                    if(withPrimaryKey){
                        changeFields.put(fields[i], fields[i].get(bean));
                    }
                }else{
                    changeFields.put(fields[i], fields[i].get(bean));
                }
            }
            StringBuilder stringBuilder = new StringBuilder("update "+tableName+" set ");
            Set<Field> changeFieldSet = changeFields.keySet();
            int counter = 0;
            //设置set后面的内容
            for(Field f: changeFieldSet){
                Object value = changeFields.get(f);
                if(value==null){
                    stringBuilder.append(f.getName()+"=null");
                } else {
                    stringBuilder.append(f.getName() + "='" + value.toString() + "'");
                }
                if(counter!=changeFieldSet.size()-1){
                    stringBuilder.append(",");
                }
                counter++;
            }
            stringBuilder.append(" where ");
            counter = 0;
            for(Field f: primaryFields.keySet()){
                stringBuilder.append(f.getName()+"='"+primaryFields.get(f).toString()+"'");
                if(counter!= primaryFields.size()-1){
                    stringBuilder.append(" and ");
                }
                counter++;
            }
            stringBuilder.append(";");
            System.out.println(stringBuilder.toString());
            Statement statement = connection.createStatement();;
            statement.executeUpdate(stringBuilder.toString());
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }
    /*
     *  借阅图书
     * @param borrowWithBookBean
     * @return
     */
    public int borrowBook(BorrowWithBookBean borrowWithBookBean) {
        Connection connection = null;
        try {
            connection = this.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Borrow values(?,?,?,?,?,?,?);");
            int count = preparedStatement.executeUpdate();
            System.out.println("影响行数");
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
    }
    /**
     * 拷贝Bean
     * @param bean         源bean
     * @param beanClass    bean的Class类型
     * @return             新的Bean
     */
    public Object copyBean(Object bean, Class beanClass){
        try {
            Object newObject = beanClass.getDeclaredConstructor().newInstance();
            Field[] field = beanClass.getFields();
            for(int i = 0;i<field.length;i++){
                Object value = field[i].get(bean);
                field[i].set(newObject, value);
            }
            return newObject;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询所有书籍带上书类别名称
     * @return {@link ArrayList<BorrowWithBookBean>} 书籍集合
     */
    public ArrayList<Object> queryBookWithClass() {
        try {
            Connection connection = this.getConnection();
            String sql = "select bookID, Book.classID, bookName, publisher, originPrice, storageDate, storageCount, className " +
                    "from Book, BookClass where Book.classID=BookClass.classID;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ArrayList<Object> bookWithClassBeans = fullSetupMultiByQuery(resultSet, BookWithClassBean.class);
            return bookWithClassBeans;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * 获取当前时间
     * @return {@link java.sql.Date} SQL日期对象
     */
    public java.sql.Date getNowDate(){
        Calendar nowDay = Calendar.getInstance();
        Formatter formatter = new Formatter();
        formatter.format("%04d-%02d-%02d", nowDay.get(Calendar.YEAR), nowDay.get(Calendar.MONTH)+1, nowDay.get(Calendar.DAY_OF_MONTH));
        return Date.valueOf(formatter.out().toString());
    }

    /**
     * 查询所有用户信息
     * @return
     */
    public ArrayList<Object> queryAllUsers(){
        Connection connection = null;
        try {
            connection = this.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from Users;");
            ResultSet result = preparedStatement.executeQuery();
            ArrayList<Object> allUsers = fullSetupMultiByQuery(result, UserBean.class);
            return allUsers;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    /**
     * 查询所有借阅信息
     * @return
     */
    public ArrayList<Object> queryAllBorrows(){
        Connection connection = null;
        try {
            connection = this.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from Borrow;");
            ResultSet result = preparedStatement.executeQuery();
            ArrayList<Object> allBorrows = fullSetupMultiByQuery(result, BorrowBean.class);
            return allBorrows;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
