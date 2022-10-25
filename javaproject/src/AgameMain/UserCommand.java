package AgameMain;

import java.util.HashMap;
import java.util.Map;
import exploiter.controller.Controller;
import exploiter.controller.DeleteController;
import exploiter.controller.ExitController;
import exploiter.controller.InsertController;
import exploiter.controller.LogInController;
import exploiter.controller.UpdateController;
import rank.controller.RankResearchController;

//Main.Command
//메인.커멘드
public class UserCommand {
	public Map<Integer, Controller> usercommand;

	public UserCommand() {
		usercommand = new HashMap<>();


		//command.put(1, (Controller) new GameController()); // 게임시작
		command.put(2, (Controller) new RankResearchController()); // 랭크확인
		command.put(3, (Controller) new Log_out()); // 로그아웃-> 메인 메뉴로 이동
		command.put(4, (Controller) new UpdateController()); // 회원수정
		command.put(5, (Controller) new DeleteController()); // 회원탈퇴

		usercommand.put(1, new GameController()); // 게임시작
		usercommand.put(2, (Controller) new RankResearchController()); // 랭크확인
		// command.put(3, new ); // 로그아웃-> 메인 메뉴로 이동 
		usercommand.put(4, (Controller) new UpdateController()); // 회원수정
		usercommand.put(5, (Controller) new DeleteController()); // 회원탈퇴 

	}

}
