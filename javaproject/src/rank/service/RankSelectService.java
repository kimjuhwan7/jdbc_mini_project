package rank.service;

import java.sql.Connection;
import java.sql.SQLException;

import generic.GenericUtil;
import rank.Rank;
import rank.RankDao;
import rank.RankDaoOracle;

public class RankSelectService {

	RankDao dao = new RankDaoOracle();
		
	public int Select(Rank rnk)
	{
		int result = 0;
		Connection conn = null;
		try {
			
			conn = GenericUtil.getConnection();
			
			if(conn == null)
				result = dao.select(conn);
			
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
