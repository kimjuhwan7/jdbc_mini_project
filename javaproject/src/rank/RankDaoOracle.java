package rank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class RankDaoOracle implements RankDao{

	@Override
	public List<Rank> select(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		List<Rank> list = new ArrayList<>();
		String sql = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
			stmt = conn.createStatement();
		
			sql = "select * from Rank";
			
			rs = stmt.executeQuery(sql);
		
			while(rs.next())
			{
				list.add(new Rank( rs.getInt("serialnum"), rs.getInt("exploiternum"), rs.getInt("score"), rs.getString("cleartime")));
			}
		}
		finally 
		{
			if(rs != null)
			rs.close();
			
			if(stmt != null)
			stmt.close();
		}
		
		return list;
	}

	@Override
	public List<Rank> researchByRank(Connection conn, String nickName) throws SQLException{
		// TODO Auto-generated method stub
		List<Rank> list = new ArrayList<>();
		String sql = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			sql = "select e.nickname, r.* from Rank r,exploiter e where r.usernum = e.usernum and e.nickname like ?";
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickName);
			
			rs = pstmt.executeQuery(sql);
		
			while(rs.next())
			{
				list.add(new Rank( rs.getInt("serialnum"), rs.getInt("exploiternum"), rs.getInt("score"), rs.getString("cleartime")));
				list.get(list.size()-1).setNickname(rs.getString("nickname"));
			}
		}
		finally 
		{
			if(rs != null)
				rs.close();
			
			if(pstmt != null)
				pstmt.close();
		}
		
		return list;
	}

	@Override
	public List<Rank> researchByRank(Connection conn, int serialnum) throws SQLException{
		// TODO Auto-generated method stub
		List<Rank> list = new ArrayList<>();
		String sql = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			sql = "select (select ganename from game where rank.serialnum = game.serialnum), Rank.* from Rank,  where ?";
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, serialnum);
			
			rs = pstmt.executeQuery(sql);
		
			while(rs.next())
			{
				list.add(new Rank( rs.getInt("serialnum"), rs.getInt("exploiternum"), rs.getInt("score"), rs.getString("cleartime")));
				list.get(list.size()-1).setNickname(rs.getString("gamename"));
			}
		}
		finally 
		{
			if(rs != null)
			rs.close();
			
			if(pstmt != null)
				pstmt.close();
		}
		
		return list;
	}

	@Override
	public int insert(Connection conn, Rank rnk) throws SQLException{
		// TODO Auto-generated method stub
		int result = 0;
		String sql = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			sql = "insert into Rank value(RANK_INDEX.NEXTVAL,?,?,?,?)";
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, rnk.getSerialNum());
			pstmt.setInt(2, rnk.getExploiterNum());
			pstmt.setInt(3, rnk.getScore());
			pstmt.setString(4, rnk.getCleartime());
		
			result = pstmt.executeUpdate();
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

	@Override
	public int update(Connection conn, Rank rnk) throws SQLException{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection conn, int index) throws SQLException{
		// TODO Auto-generated method stub
		int result = 0;
		String sql = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			sql = "delete from Rank where rankindex = ?";
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, index);
		
			result = pstmt.executeUpdate();
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
