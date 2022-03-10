import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class OurDatabase {
    private static OurDatabase db = null;
    private static Class driver = null;
    private static Connection conn = null;
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
                        System.out.println("数据库连接错误");
                    }
                }
            }
        }
        return db;
    }

    private OurDatabase() throws ClassNotFoundException, SQLException {
        driver = Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://1.116.21.195:3306/library", "jsp", "1008611");
    }

    /**
     * 获取新的Statement
     * @return 新的Statement
     */
    public Statement getNewStatement(){
        Statement s = null;
        try {
            s = conn.createStatement();
        } catch (SQLException throwables) {
            System.out.println("SQL错误");
            throwables.printStackTrace();
            db = null;
            driver = null;
            conn = null;

        }
        return s;
    }
}
