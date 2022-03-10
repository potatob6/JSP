import java.util.logging.Logger;

public class OurDatabase {
    private static OurDatabase db = null;
    /**
     * 获取数据库
     */
    public static OurDatabase getDataBase() {
        if (db == null) {
            synchronized (OurDatabase.class) {
                if (db == null) {
                    try {
                        db = new OurDatabase();
                    }catch (ClassNotFoundException e){
                        System.out.println("数据库连接错误");
                    }
                }
            }
        }
        return db;
    }

    private OurDatabase() throws ClassNotFoundException {
        Class driver = Class.forName("com.mysql.jdbc.Driver");

    }
}
