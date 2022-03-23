package io.github.yywl5.Dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 星包客
 */
public class DaoUtils {
	private static DataSource source = new ComboPooledDataSource();
	//设置的连接的四大参数;

	private DaoUtils() {
	}


	public static DataSource getSource() {
		return source;
	}

	public static Connection getConnection() {
		try {
			return source.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
