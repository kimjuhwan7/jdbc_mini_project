package game;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface GameDao {

	List<Game> select(Connection conn)throws SQLException;
	Game researchByGame(Connection conn, String gameName)throws SQLException;
	
	//DML
	int insert(Connection conn, Game game)throws SQLException;
	int update(Connection conn, Game game)throws SQLException;
	int delete(Connection conn, String gameName)throws SQLException;
}
