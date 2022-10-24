package user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

	@Override
	public List<User> select(Connection conn) throws SQLException {
		
		List<User> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();

			String sql = "select * from user";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				list.add(rowToUser(rs));
			}

		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
		
		
		return list;
	}

	@Override
	public User researchByName(Connection conn, String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Connection conn, User user) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, User user) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection conn, String name) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	
	private User rowToUser(ResultSet rs) throws SQLException {

		return new User(rs.getInt("usernum"), rs.getString("id"), rs.getString("password"), rs.getString("nickname"), rs.getInt("isAdmin"));

	}
	
	
}
