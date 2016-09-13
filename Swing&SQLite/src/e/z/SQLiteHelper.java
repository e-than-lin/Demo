package e.z;
import java.sql.*;  
import java.util.Properties;
public class SQLiteHelper {
	public static Connection conn = null;  
	public static Statement stmt = null;  
	public static ResultSet rset = null; 
	public static void pre(){
		try {
			 PropertyHelper.getProperties();
			 Class.forName("org.sqlite.JDBC");  
			 Properties properties=PropertyHelper.properties;
			 Properties pro = new Properties();
			 pro.put("date_string_format", "yyyy-MM-dd HH:mm:ss");
			 conn = DriverManager.getConnection( "jdbc:sqlite:/"+properties.getProperty("path")+"/"+properties.getProperty("dbName")+".db",pro);
			 conn.setAutoCommit(false);
			 stmt = conn.createStatement();  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void initDb(){ 
        try {
			conn.setAutoCommit(false);
		    stmt.executeUpdate("create table sys_log(id number primary key,adddate Timestamp,content varchar(225))");  
		    stmt.executeUpdate("insert into sys_log(id,adddate,content) values(1,datetime('now','localtime'),'创建数据库')");
		    conn.commit();  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public static boolean isInitiated(){
	    boolean init=false;
	    try {
			rset = stmt.executeQuery("SELECT id,adddate,content FROM sys_log where id<2");
			while (rset.next()){  
	            System.out.println(rset.getTimestamp("adddate")+" "+rset.getString("content"));  
	            init=true;
	        }  
		} catch (SQLException e) {
			e.printStackTrace();
			closeDb();
		}
		return init;  
	}
	public static void closeDb(){
		 try {  
             if (rset!=null) rset.close();  
             stmt.close();  
             conn.close();  
         } catch (SQLException e) 
		 { 
        	 System.out.println("SQLException in finally :" + e.getMessage()); 
         }
	}
	public static void main(String[] args) {  
		pre();
		if (!isInitiated()) {
			initDb();
		}
		closeDb();
	}  
}
