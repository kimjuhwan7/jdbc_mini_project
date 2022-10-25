package rank.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rank.Rank;
import rank.RankDao;
import rank.RankDaoOracle;


public class RankResearchService {

	RankDao dao = new RankDaoOracle();
	
	public List<Rank> research(String nickName)
	{
		List<Rank> rank = null;
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
	public List<Rank> research(int serialNum)
	{
		List<Rank> rank = null;
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

	public List<Rank> researchAll()
	{
		List<Rank> rank = new ArrayList<>();
		Connection conn = null;
		
		try 
		{
			conn = generic.GenericUtil.getConnection();
			for(int i = 0; i < 4; i++)
				rank.addAll(dao.researchByRank(conn, i));
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
