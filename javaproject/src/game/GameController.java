package game;

import java.util.List;

import AgameMain.Main;
import exploiter.controller.Controller;

public class GameController implements Controller {
//김주환 작성중
	GameService service = new GameService(new GameDaoOracle());

	@Override
	public void process() {
		System.out.println("게임을 선택해 주세요 1, 2, 3");
		int result = Main.sc.nextInt();

		switch (result) {
		case 1:
			NumberGuessing gaGuessing = new NumberGuessing();
//			gaGuessing.
			break;
		case 2:
			Hi99 gamea = new Hi99();
			gamea.hi_start();
			break;
		case 3:
			TicTacToe tacToe = new TicTacToe();
//			tacToe.
			break;
		}

		List<Game> list = service.select();

		if (list != null && !list.isEmpty()) {
			for (Game e : list) {
				System.out.println(e);
			}
		} else {
			System.out.println(list);

			System.out.println("검색 결과 없음");
		}

	}

	public static void main(String[] args) {
		GameController controller = new GameController();
		controller.process();
	}

}