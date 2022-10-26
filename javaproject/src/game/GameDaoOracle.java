package game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GameDaoOracle implements GameDao{

	public List<Game> select(Connection conn)throws SQLException {
		return null;
	}
	
	//DML
	public Game researchByGame(Connection conn, String gameName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public int update(Connection conn, Game game) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(Connection conn, String gameName) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(Connection conn, Game game)throws SQLException
	{
		int result = 0;
		String sql = "insert into game values(?,?,?,?)";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try
		{
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, game.getSerialnum());
		pstmt.setString(2, game.getGamename());
		pstmt.setString(3, game.getDiscription());
		pstmt.setString(4, game.getGenre());
		
		result = pstmt.executeUpdate();
		
		conn.commit();
		}
		finally
		{
			if(rs != null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
		}
		return result;
	}

}
