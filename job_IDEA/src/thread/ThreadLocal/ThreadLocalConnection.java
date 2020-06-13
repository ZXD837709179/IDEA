package thread.ThreadLocal;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
/**
 * 使用ThreaLocal变量来管理数据库链接
 * 当前线程的操作都是用同一个Connection，保证了事务
 * @author Xudong Zhang
 */
public class ThreadLocalConnection{
	//数据库连接池
	private static BasicDataSource source;
	private static ThreadLocal<Connection> threadLocal;
	
	static {
			try {
				Properties pro = new Properties();
				InputStream rs = ThreadLocalConnection.class.getClassLoader().getResourceAsStream("thread/ThreadLocal/pro.properties");
				pro.load(rs);
				source = new BasicDataSource();
				source.setDriverClassName(pro.getProperty("driverClassName"));
				source.setUrl(pro.getProperty("url"));
				source.setUsername(pro.getProperty("username"));
				source.setPassword(pro.getProperty("password"));
				threadLocal= new ThreadLocal<Connection>();
				rs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static Connection getConnection() throws SQLException {
		if(threadLocal.get()!=null) {
			return threadLocal.get();
		}else {
			Connection  connection= source.getConnection();
			threadLocal.set(connection);
			return connection;
		}
	}
	
	//关闭数据库连接
    public static void closeConnection() {
        //从线程中拿到Connection对象
        Connection connection = threadLocal.get();

        try {
            if (connection != null) {
                //恢复连接为自动提交
                connection.setAutoCommit(true);

                //这里不是真的把连接关了,只是将该连接归还给连接池
                connection.close();

                //既然连接已经归还给连接池了,ThreadLocal保存的Connction对象也已经没用了
                threadLocal.remove();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	public static void main(String[] args) throws SQLException {
		Connection connection = ThreadLocalConnection.getConnection();
		
		String sql = "select * from userinfo";
		Statement state = connection.createStatement();
		ResultSet result = state.executeQuery(sql);
		while(result.next()) {
			System.out.println(result.getString(2));
			System.out.println(result.getInt("id"));
			
			
		}
	}


}
