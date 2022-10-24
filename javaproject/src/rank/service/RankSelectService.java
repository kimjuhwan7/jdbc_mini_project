package rank.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import generic.GenericUtil;
import rank.Rank;
import rank.RankDao;
import rank.RankDaoOracle;

public class RankSelectService {

	RankDao dao = new RankDaoOracle();
	
	List<Rank> rnk = ArrayList<Rank>();
		
	public int Select(Rank rnk)
	{
		int result = 0;
		Connection conn = null;
		try {
			
			conn = GenericUtil.getConnection();
			
			rnk = dao.select(conn);
			
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
