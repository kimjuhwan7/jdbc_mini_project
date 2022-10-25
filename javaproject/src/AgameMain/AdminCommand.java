package AgameMain;

import java.util.HashMap;
import java.util.Map;
import exploiter.controller.Controller;
import exploiter.controller.ExitController;
import exploiter.controller.InsertController;
import exploiter.controller.LogInController;
import exploiter.controller.UpdateController;
import rank.controller.RankDeleteController;
import rank.controller.RankInsertController;
import rank.controller.RankResearchController;

//Main.Command
//메인.커멘드
public class AdminCommand {
	public Map<Integer, Controller> command;

	public AdminCommand() {
		command = new HashMap<>();

		command.put(1, (Controller) new UpdateController()); // 전체 회원관리
		command.put(2, (Controller) new RankResearchController()); // 랭크검색
		command.put(3, (Controller) new RankDeleteController()); // 랭크삭제
		command.put(4, (Controller) new RankInsertController()); // 랭크수정
		command.put(5, (Controller) new Log_out()); // 로그아웃

	}

}
