import java.util.HashMap;
import java.util.Map;
import exploiter.controller.Controller;
import exploiter.controller.ExitController;

public class Command {
	public Map<Integer, Controller> command;

	public Command() {
		command = new HashMap<>();

		// commend.put(1, new 로그인());
		// commend.put(2, new 회원가입());
		command.put(3, new ExitController());

	}

}
