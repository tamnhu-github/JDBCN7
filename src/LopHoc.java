import java.sql.*;
import java.util.*;
public class LopHoc {
	private int id;
	private String name;
	public LopHoc(int id, String name) {
		this.id = id;
		this.name = name;
	}
	private static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:TestDB1.db");
		return conn;
	}
	//lay data bo vao list
	public static List<LopHoc> getList() throws SQLException, ClassNotFoundException {
		Connection conn = getConnection();
		Statement state = conn.createStatement();
		String sql = "SELECT * FROM HOCSINH";
		ResultSet result = state.executeQuery(sql);
		List<LopHoc> list = new ArrayList<>();
		while(result.next()) {
			int id = result.getInt("id");
			String name = result.getString("name");
			list.add(new LopHoc(id,name));
		}
		conn.close();
		return list;
	}
	public static int create(String name1) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		Statement state = conn.createStatement();
		String sql = "INSERT INTO HOCSINH (name) VALUES ('" + name1 + "')";
		int result = state.executeUpdate(sql);
		//bien result tra ve so dong updated 
		conn.close();
		return result;
	}
	public static int update(int id, String name ) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		Statement state = conn.createStatement();
		String sql = "UPDATE HOCSINH SET name = '"+name+"' WHERE id = "+id+"";
		int result = state.executeUpdate(sql);
		conn.close();
		return result;
		
	}
	public static int delete(String delname) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		Statement state = conn.createStatement();
		String sql = "DELETE FROM HOCSINH WHERE name = '" + delname + "'";
		int result = state.executeUpdate(sql);
		conn.close();
		return result;
		
	}
	@Override
	public String toString() {
		return "LopHoc [id=" + id + ", name=" + name + "]";
	}

	
}
