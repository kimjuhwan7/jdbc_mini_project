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

	RankDao dao = null;
	
	public RankSelectService(RankDao dao)
	{
		this.dao = dao;
	}

	public List<Rank> select()
	{
		List<Rank> rank = null;
		Connection conn = null;
		try {
			
			conn = GenericUtil.getConnection();
			
			rank = dao.select(conn);
			
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
		
		return rank;
	}
}
