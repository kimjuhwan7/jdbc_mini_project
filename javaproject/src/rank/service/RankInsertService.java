package rank.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import rank.Rank;
import rank.RankDao;

public class RankInsertService {
	
	RankDao dao = new RankDao() {
		
		@Override
		public int update(Connection conn, Rank rnk) 
		{
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public List<Rank> select(Connection conn) throws SQLException 
		{
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Rank researchByRank(Connection conn, int serialnum) 
		{
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Rank researchByRank(Connection conn, String nickname) 
		{
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public int insert(Connection conn, Rank rnk) 
		{
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public int delete(Connection conn, Rank rnk) 
		{
			// TODO Auto-generated method stub
			return 0;
		}
	};
	
}
