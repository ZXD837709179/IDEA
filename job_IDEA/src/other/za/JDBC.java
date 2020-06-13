package list;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
public class JDBC {
	public static void main(String[] args) {
	Connection connection=null;
    PreparedStatement ps=null;
        //1.register
        try {
			Class.forName("com.mysql.jdbc.Driver");
			//2.getConnection
	        String url="jdbc:mysql://localhost:3306/miaosha?characterEncoding=latin1&useConfigs=maxPerformance";
	        Properties info=new Properties();
	        info.put("user", "root");
	        info.put("password", "admin");
	        connection=DriverManager.getConnection(url, info);
		
	        //3.create Statement
		    String sql="insert into order_info(id,user_id, goods_id, goods_name, goods_count, goods_price, order_channel, status)values"
	        		+ "(?,?,?,?,?,?,?,?)";
	        ps=connection.prepareStatement(sql);
	        ps.setInt(1, 1);
	        ps.setInt(2, 131);//user_id
	        ps.setInt(3, 222);//goods_id
	        ps.setString(4, "xifashui");//goods_name
	        ps.setInt(5, 998);//goods_count
	        ps.setDouble(6, 99.8);//goods_price
	        ps.setInt(7, 1);//order_channel
	        ps.setInt(8, 1);//status
	
	        //4.excuteUpdate
	        int resultSet=ps.executeUpdate();
	        if(resultSet>0){
	            //如果插入成功，则打印success
	            System.out.println("Sucess");
	        }else{
	            //如果插入失败，则打印Failure
	            System.out.println("Failure");
	        }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (connection !=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}
}
