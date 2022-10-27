package game;

import java.util.HashMap;

import AgameMain.Command;
import AgameMain.Main;
import exploiter.controller.Controller;
import java.util.*;

public class GameController implements Controller {

	private static GameController instance = null;

	public static GameController GetInstance() {
		if (instance == null)
			instance = new GameController();

		return instance;
	}

	NumberGuessing gaGuessing = null;
	Hi99 hi99 = null;
	TicTacToe tacToe = null;

	public GameController() {

		gaGuessing = new NumberGuessing();

		hi99 = new Hi99();

		tacToe = new TicTacToe();

	}

	@Override
	public void process() {
		System.out.println("게임을 선택해 주세요 1. 숫자 맞추기 2. 구구단 빨리 맞추기 3. 틱택톡");
		System.out.println("게임 선택화면을 나가시려면 4번을 눌러주세요");
		int result = Integer.parseInt(Main.sc.nextLine());

		switch (result) {
		case 1:
			gaGuessing.gameStart();	
			break;
		case 2:
			hi99.game_Start();
			break;
		case 3:
			tacToe.gameStart();
			break;
		case 4:
			
//			Command.userCommand();
			
			break;
		}

	}
}