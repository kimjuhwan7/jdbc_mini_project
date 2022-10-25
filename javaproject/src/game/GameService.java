package game;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GameService {
	GameDao dao;

	public GameService(GameDao dao) {
		this.dao = dao;
	}

	public List<Game> select() {
		List<Game> list = null;
		Connection conn = null;

		try {
			conn = generic.GenericUtil.getConnection();

			String gameName;
			list = dao.researchByGame(conn, gameName);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}
}
