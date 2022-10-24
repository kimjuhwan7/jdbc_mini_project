package rank;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface RankDao {
	
	List<Rank> select(Connection conn) throws SQLException;
	Rank researchByRank(Connection conn, String nickname) throws SQLException;
	Rank researchByRank(Connection conn, int serialnum) throws SQLException;
	
	int insert(Connection conn, Rank rnk) throws SQLException;
	int update(Connection conn, Rank rnk) throws SQLException;
	int delete(Connection conn, int index) throws SQLException;
}
