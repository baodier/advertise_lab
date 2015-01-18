package adserver.jdbc;

/**
 * Created by liuyq on 2014/12/11.
 */

import com.sun.rowset.JdbcRowSetImpl;

import javax.sql.rowset.JdbcRowSet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConnector {

    public Connection conn;
    public JdbcRowSet jdbcRs;
    private Properties props;

    /**
     * 构造函数
     * 需要调用intial()方法才可以初始化数据库连接
     */
    public JdbcConnector() {
        conn = null;
        jdbcRs = null;
        props = null;
    }

    /**
     * 初始化数据库连接
     * 在函数内部不做异常捕获，抛出异常让外部处理该函数的异常
     * @throws ClassNotFoundException
     * @throws java.io.IOException
     * @throws java.sql.SQLException
     */
    public void initial() throws ClassNotFoundException, IOException, SQLException {

        // 加载配置文件
        String url = "jdbc:mysql://166.111.14.2:3316/advertise_liuyongqi";//props.getProperty("jdbcUrl");
        String user = "root";//props.getProperty("username");
        String password = "cwc";//props.getProperty("password");

        // 加载JDBC驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 建立数据库连接
        this.conn = DriverManager.getConnection(url, user, password);
        this.jdbcRs = new JdbcRowSetImpl(this.conn);
    }

    /**
     * 当前连接的数据库操作回滚
     */
    public void rollback(){
        try {
            // 连接为初始化不行执行操作
            if (null != conn)
                conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 断开数据库联接
     * @throws SQLException
     */
    public void close() {
        try {
            // 断开操作类
            if (null != jdbcRs)
                jdbcRs.close();
            // 断开数据库连接
            if (null != conn)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
