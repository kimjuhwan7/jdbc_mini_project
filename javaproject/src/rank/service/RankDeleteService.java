package rank.service;

import java.sql.Connection;
import java.sql.SQLException;

import generic.GenericUtil;
import rank.RankDao;
import rank.RankDaoOracle;

public class RankDeleteService {
	RankDao dao = new RankDaoOracle();
	
	public int delete(int index)
	{
		int result = 0;
		Connection conn = null;
		try {
			conn = GenericUtil.getConnection();
			
			result = dao.delete(conn, index);
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
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
}
