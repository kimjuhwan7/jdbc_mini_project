package rank.service;

import java.sql.Connection;
import java.sql.SQLException;

import generic.GenericUtil;
import rank.Rank;
import rank.RankDao;
import rank.RankDaoOracle;

public class RankInsertService {
	
	RankDao dao = new RankDaoOracle();
		
	public int Insert(Rank rnk)
	{
		int result = 0;
		Connection conn = null;
		try {
			
			conn = GenericUtil.getConnection();
			
			result = dao.insert(conn, rnk);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(conn != null)
			{
				try {
					conn.close();
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
}
