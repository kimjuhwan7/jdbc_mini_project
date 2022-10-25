package rank.service;

import java.sql.Connection;
import java.sql.SQLException;

import rank.Rank;
import rank.RankDao;
import rank.RankDaoOracle;


public class RankResearchService {

	RankDao dao = new RankDaoOracle();
	
	public Rank research(String nickName)
	{
		Rank rank = null;
		Connection conn = null;
		
		try 
		{
			conn = generic.GenericUtil.getConnection();
			rank = dao.researchByRank(conn, nickName);
		} 
		catch (SQLException e) 
		{
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
		finally
		{
			if(conn != null)
				try 
			{
					conn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		
		return rank;
	}
	public Rank research(int serialNum)
	{
		Rank rank = null;
		Connection conn = null;
		
		try 
		{
			conn = generic.GenericUtil.getConnection();
			rank = dao.researchByRank(conn, serialNum);
		} 
		catch (SQLException e) 
		{
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
		finally
		{
			if(conn != null)
				try 
			{
					conn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		
		return rank;
	}
}
