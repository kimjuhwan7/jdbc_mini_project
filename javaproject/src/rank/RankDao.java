package rank;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface RankDao {
	
	List<Rank> select(Connection conn) throws SQLException;
	Rank researchByRank(Connection conn, String nickname);
	Rank researchByRank(Connection conn, int serialnum);
	
	int insert(Connection conn, Rank rnk);
	int update(Connection conn, Rank rnk);
	int delete(Connection conn, Rank rnk);
}
