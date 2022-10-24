package game;

import java.util.*;

public class TigTacToe {
	
	static String[] board;
	static String comPlayer;
	static String player;
	static String turn;

	static String checkWinner(){
		for (int a = 0; a < 8; a++) {
			String line = null;
			// 이기는 조건
			switch (a) {
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}
			// 사용자1의 승리인 경우
			if (line.equals("XXX")) {
				return "X";
			}
			
			// 사용자2의 승리인 경우 
			else if (line.equals("OOO")) {
				return "O";
			}
		}
		
		// 더이상 둘 곳이 없는 경우
		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(board).contains(
					String.valueOf(a + 1))) {
				break;
			}
			else if (a == 8) {
				return "무승부";
			}
		}

		
		System.out.println(
			turn + "의 차례입니다. 배치 할 슬롯 번호를 입력하세요. "
			);
		return null;
	} // checkWinner() 끝
	
	
	// printBoard
/*  |---|---|---|
	| 1 | 2 | 3 |
	|-----------|
	| 4 | 5 | 6 |
	|-----------|
	| 7 | 8 | 9 |
	|---|---|---|
*/
	
	// 보드판
	static void printBoard()
	{
		System.out.println("|---|---|---|");
		System.out.println("| " + board[0] + " | "
						+ board[1] + " | " + board[2]
						+ " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[3] + " | "
						+ board[4] + " | " + board[5]
						+ " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[6] + " | "
						+ board[7] + " | " + board[8]
						+ " |");
		System.out.println("|---|---|---|");
	}	// printBoard() 끝

	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		board = new String[9];
		turn = "X"; // 보드판에 놓을 말의 표시
		String winner = null;

		// index의 경우 0부터 시작하기 때문에 +1 해줘야 함.
		for (int a = 0; a < 9; a++) {
			board[a] = String.valueOf(a + 1);
		}

		System.out.println("3x3 Tig Tac Toc 게임을 시작합니다.");
		printBoard();

		System.out.println(
			"플레이어가 먼저 할 거예요. X를 배치할 슬롯 번호를 입력하세요.");

		while (winner == null) {
			int numInput;	// 1-9까지 사용자 입력을 받는다.
			
			// 예외처리 
			// numInput의 지정범위(1-9)를 벗어나면 오류발생 표시
			try {
				numInput = in.nextInt();
				if (!(numInput > 0 && numInput <= 9)) {
					System.out.println(
						"유효하지 않은 숫자 입니다. 숫자 1-9 의 범위만 입력이 가능합니다. 다시 입력해주세요.");
					continue;
				}
			}
			// 정수를 입력해야하는데 문자를 입력한경우 
			catch (InputMismatchException e) { 
				System.out.println(
					"유효하지 않은 숫자 입니다. 숫자 1-9 의 범위만 입력이 가능합니다. 다시 입력해주세요.");
				continue;
			}

			// 게임의 조건 
			if (board[numInput - 1].equals(
					String.valueOf(numInput))) {
				board[numInput - 1] = turn;

				if (turn.equals("X")) {
					turn = "O";
				}
				else {
					turn = "X";
				}

				printBoard();
				winner = checkWinner();
			}
			else {
				System.out.println(
					"이미 놓여진 자리입니다. 다른 숫자를 입력 해 주세요.");
			}
		} // while문 종료시점
		
		// 무승부인 경우
		if (winner.equalsIgnoreCase("무승부")) {
			System.out.println(
				"무승부입니다! 플레이 해주셔서 감사합니다.");
		}
		
		// 승리자가 나온 경우
		else {
			System.out.println(
				"축하합니다! " + winner
				+ "의 승리! 플레이해주셔서 감사합니다");
		}
	}
}

