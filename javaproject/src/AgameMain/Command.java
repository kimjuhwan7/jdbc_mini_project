package AgameMain;
import java.util.HashMap;
import java.util.Map;
import exploiter.controller.Controller;
import exploiter.controller.ExitController;
import exploiter.controller.InsertController;
import exploiter.controller.LogInController;

//Main.Command
//메인.커멘드
public class Command {
	public Map<Integer, Controller> command;

	public Command() {
		command = new HashMap<>();

		command.put(1, new LogInController());
		command.put(2, new InsertController());
		command.put(3, new ExitController());

	}

}
