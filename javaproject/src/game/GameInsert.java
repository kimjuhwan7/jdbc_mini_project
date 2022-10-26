package game;

import java.sql.Connection;
import java.sql.SQLException;

import generic.GenericUtil;

public class GameInsert {
	
	private GameInsert instance = null;
	GameDaoOracle dao = new GameDaoOracle();
	
	GameInsert GetInstance()
	{
		if(instance == null)
			instance = new GameInsert();
		
		return instance;
	}
	
	//GameInsert service = new GameInsert();
	
	public void InsertGame(int serialnum, String gamename, String discription, String genre)
	{
		Connection conn = null;
		
		try {
			conn = GenericUtil.getConnection();
			
			dao.insert(conn, new Game(serialnum,gamename,discription,genre));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(conn != null)
				{
					try 
					{
					conn.close();
					}
					catch (SQLException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		}
		
	}
	
}
