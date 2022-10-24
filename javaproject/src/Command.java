import java.util.HashMap;
import java.util.Map;
import exploiter.controller.Controller;
import exploiter.controller.ExitController;

//Main.Command
//메인.커멘드
public class Command {
	public Map<Integer, Controller> command;

	public Command() {
		command = new HashMap<>();

		// commend.put(1, new 로그인());
		// commend.put(2, new 회원가입());
		command.put(3, new ExitController());

	}

}
