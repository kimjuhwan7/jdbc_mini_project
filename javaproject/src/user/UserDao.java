package user;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public interface UserDao {

	List<User> select(Connection conn)throws SQLException;
	User researchByName(Connection conn, String name)throws SQLException;
	
	//DML
	int insert(Connection conn, User user)throws SQLException;
	int update(Connection conn, User user)throws SQLException;
	int delete(Connection conn, String name)throws SQLException;
}
