package game;

import java.util.Random;
import java.util.Scanner;

import AgameMain.Main;
import rank.controller.RankInsertController;
import rank.controller.RankResearchController;

// 플레이어 = 'X'  | 컴퓨터 = 'O' 
public class TicTacToe {

	private static int score = 0;
	private static Scanner scanner = new Scanner(System.in);
	static int serial_num = 3;

	public int getSerialnum()
	{
		return serial_num;
	}
	
	// 게임이 끝나는 조건 우승 | 무승부
	private static boolean isGameFinished(char[][] board) {

		// 플레이어 승리시 10점 획득
		if (hasContestantWon(board, 'X')) {
			printBoard(board);
			score += 10;
			System.out.println("플레이어 승리!");
			System.out.print(" 10점 획득 ! ");
			System.out.println("지금까지 획득한 점수는 총" + score + "점 입니다.");
			return true;

		} else if (hasContestantWon(board, 'O')) { // 컴퓨터 승리시 점수획득 불가
			printBoard(board);
			System.out.println("컴퓨터 승리!");
			System.out.print(" 점수를 획득하지 못했습니다. ");
			System.out.println("지금까지 획득한 점수는 총" + score + "점 입니다.");
			return true;
		}

		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == ' ') {
					return false;
				}
			}
		}

		printBoard(board);
		System.out.println("무승부!");
		return true;
	}

	// 이기는 조건
	private static boolean hasContestantWon(char[][] board, char symbol) {
		if ((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol)
				|| (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol)
				|| (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol)
				|| (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol)
				|| (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol)
				|| (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol)
				|| (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
				|| (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
			return true;
		}
		return false;
	}

	// 컴퓨터플레이 랜덤값 생성
	private static void computerTurn(char[][] board) {
		Random rand = new Random();
		int computerMove;
		while (true) {
			computerMove = rand.nextInt(9) + 1;
			if (isValidMove(board, Integer.toString(computerMove))) {
				break;
			}
		}
		System.out.println("컴퓨터는 " + computerMove + "를 골랐습니다. \n");
		placeMove(board, Integer.toString(computerMove), 'O');
	}

	// 플레이어의 입력을 요구하는 기능
	private static void playerTurn(char[][] board, Scanner scanner) {
		String userInput;
		while (true) {
			System.out.println("\n배치 할 숫자 입력 후 엔터를 쳐주세요. >>>");
			userInput = scanner.nextLine();
			if (isValidMove(board, userInput)) {
				break;
			} else { // 예외처리
				System.out.println(userInput + "잘못된 입력입니다. 숫자 1-9 의 범위만 입력할 수 있습니다!!");
			}
		}
		placeMove(board, userInput, 'X');
	}

	// 움직임 확인 기능
	private static boolean isValidMove(char[][] board, String position) {
		switch (position) {
		case "1":
			return (board[0][0] == ' ');
		case "2":
			return (board[0][1] == ' ');
		case "3":
			return (board[0][2] == ' ');
		case "4":
			return (board[1][0] == ' ');
		case "5":
			return (board[1][1] == ' ');
		case "6":
			return (board[1][2] == ' ');
		case "7":
			return (board[2][0] == ' ');
		case "8":
			return (board[2][1] == ' ');
		case "9":
			return (board[2][2] == ' ');
		default:
			return false;
		}
	}

	// 움직임을배치하는 기능 = placeMove()
	private static void placeMove(char[][] board, String position, char symbol) {
		switch (position) {
		case "1":
			board[0][0] = symbol;
			break;
		case "2":
			board[0][1] = symbol;
			break;
		case "3":
			board[0][2] = symbol;
			break;
		case "4":
			board[1][0] = symbol;
			break;
		case "5":
			board[1][1] = symbol;
			break;
		case "6":
			board[1][2] = symbol;
			break;
		case "7":
			board[2][0] = symbol;
			break;
		case "8":
			board[2][1] = symbol;
			break;
		case "9":
			board[2][2] = symbol;
			break;
		default:
			System.out.println(":(");
		}
	}

	private static void printBoard(char[][] board) {
		System.out.println("--------");
		System.out.print((board[0][0]));
		System.out.print(" | ");
		System.out.print((board[0][1]));
		System.out.print("| ");
		System.out.println((board[0][2]));
		System.out.println("--------");
		System.out.print((board[1][0]));
		System.out.print(" | ");
		System.out.print((board[1][1]));
		System.out.print("| ");
		System.out.println((board[1][2]));
		System.out.println("--------");
		System.out.print((board[2][0]));
		System.out.print(" | ");
		System.out.print((board[2][1]));
		System.out.print("| ");
		System.out.println((board[2][2]));
		System.out.println("--------");
	}
	
	private void reGame() {
		
		while(true) {
			System.out.println("한번 더 플레이 하시겠습니까? (네 | 아니오) ");
			String sc = scanner.nextLine();
			
			if(sc.equals("네")) {
				gameStart();
				break;
			}else if(sc.equals("아니오")) {
				exitGame();
				break;
			}else{
				System.out.println("잘못된 입력입니다.");
				
				continue;
			}
			
		}


		
	}

	public void gameStart() {
		System.out.println("3 x 3 TicTacToe \n Computer VS Player \n Game Start!!");
		char[][] board = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
		printBoard(board);
		while (true) {
			playerTurn(board, scanner);
			if (isGameFinished(board)) {
				break;
			}
			printBoard(board);
			computerTurn(board);
			if (isGameFinished(board)) {
				break;
			}
			printBoard(board);
		}
			reGame();
	}
	
	private static void exitGame() {
		RankInsertController insertctl = new RankInsertController();
		insertctl.function(serial_num, score, Main.now);
		RankResearchController showRanking = new RankResearchController();
		showRanking.function(serial_num);
		System.out.println("\nGAME OVER");
		System.out.println("메뉴로 돌아갑니다.");
		System.out.println();
//		scanner.close();
	}
}