package rank;

import java.util.LinkedList;
import java.util.List;

import generic.GenericCommand;
import rank.controller.RankDeleteController;
import rank.controller.RankInsertController;

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
		if(!command.add(new RankInsertController()))
		{
			System.out.println("명령 추가 실패");
		}
		if(!command.add(new RankDeleteController()))
		{
			System.out.println("명령 추가 실패");			
		}
	}
}
