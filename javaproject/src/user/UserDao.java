package user;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public interface UserDao {

	List<User> select(Connection conn)throws SQLException;
	User researchByGame(Connection conn, String gameName)throws SQLException;
	
	//DML
	int insert(Connection conn, User game)throws SQLException;
	int update(Connection conn, User game)throws SQLException;
	int delete(Connection conn, String gameName)throws SQLException;
}
