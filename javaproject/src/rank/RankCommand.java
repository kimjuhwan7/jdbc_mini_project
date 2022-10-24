package rank;

import java.util.LinkedList;
import java.util.List;

import generic.GenericCommand;

public class RankCommand {

	List<GenericCommand> command;
	
	private static RankCommand instance = new RankCommand();
	
	RankCommand GetInstance()
	{
		if(instance == null)
			instance = new RankCommand();
		
		return instance;
	}
	
	private RankCommand()
	{
		command = new LinkedList<>();
		if(!command.add(new RankInsert()))
		{
			System.out.println("명령 추가 실패");
		}
		if(!command.add(new RankDelete()))
		{
			System.out.println("명령 추가 실패");			
		}
	}
}
