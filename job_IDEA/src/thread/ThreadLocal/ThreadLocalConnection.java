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
 * ʹ��ThreaLocal�������������ݿ�����
 * ��ǰ�̵߳Ĳ���������ͬһ��Connection����֤������
 * @author Xudong Zhang
 */
public class ThreadLocalConnection{
	//���ݿ����ӳ�
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
	
	//�ر����ݿ�����
    public static void closeConnection() {
        //���߳����õ�Connection����
        Connection connection = threadLocal.get();

        try {
            if (connection != null) {
                //�ָ�����Ϊ�Զ��ύ
                connection.setAutoCommit(true);

                //���ﲻ����İ����ӹ���,ֻ�ǽ������ӹ黹�����ӳ�
                connection.close();

                //��Ȼ�����Ѿ��黹�����ӳ���,ThreadLocal�����Connction����Ҳ�Ѿ�û����
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
