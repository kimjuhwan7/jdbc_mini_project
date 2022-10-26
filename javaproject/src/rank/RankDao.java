package rank;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface RankDao {
	
	List<Rank> select(Connection conn) throws SQLException;
	List<Rank> researchByRank(Connection conn, String nickname) throws SQLException;
	List<Rank> researchByRank(Connection conn, int serialnum) throws SQLException;
	
	int insert(Connection conn, Rank rnk) throws SQLException;
	int update(Connection conn, int index, int score, String date) throws SQLException;
	int delete(Connection conn, int index) throws SQLException;
}
