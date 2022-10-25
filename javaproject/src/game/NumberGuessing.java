package game;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {
	
	public final int serialNum = 1;
	
	private static int score = 0; // 점수(누적)
	private static int life = 5; // 시도횟수 한도
	
	private enum STATE{START, RESET, PLAY, GAMEOVER, EXIT};
	private static STATE state= STATE.START;

	// static Scanner sc = new Scanner(System.in);
	private static Random ran = new Random();
	private static int randomNumber = ran.nextInt(100) + 1; // 정답(랜덤)

	private static void printGame() {
		System.out.println("***NUMBER GUESSING - 랜덤 숫자 맞추기 게임***");
		System.out.println("1부터 100까지 랜덤으로 생성되는 숫자를 맞춰보세요. ");
		System.out.println("기회는 " + life + "번 입니다. ");
		state = STATE.RESET;
	}

	private static void resetGame() {
		
		System.out.println("============================================");
		System.out.println("숫자 입력 >> ");

		life = 5;
		randomNumber = ran.nextInt(100) + 1;
		
		// System.out.println(randomNumber); // 확인용
		
		state = STATE.PLAY;
	}

	private static void playGame() {
	
		while(life>0) {
			
			Scanner sc = new Scanner(System.in);
			
			int playerNumber = sc.nextInt();

			if(playerNumber>randomNumber) {
				
				System.out.println("숫자는 " + playerNumber + "보다 작습니다. ");
				life--;
				System.out.println("남은 기회는 " + life + "번 입니다. \n");
				
			} else if(playerNumber<randomNumber) {
				
				System.out.println("숫자는 " + playerNumber + "보다 큽니다. ");
				life--;
				System.out.println("남은 기회는 " + life + "번 입니다. \n");

			} else if(playerNumber==randomNumber) {
				
				System.out.println("정답입니다!");
				score+=10;
				System.out.println("현재 점수는 " + score + "점 입니다.");
				state=STATE.GAMEOVER;
				break;
			} 
			
			if(life==0) {
				System.out.println("기회를 모두 소진하였습니다. ");
				System.out.println("정답은 " + randomNumber + "이었습니다. ");
				state = STATE.GAMEOVER;
			}
			
		}
	}

	private static void retryGame() {
		
		System.out.println("한 번 더 플레이 하시겠습니까? (네/아니오)");
		
		Scanner sc1 = new Scanner(System.in);
		String s = sc1.nextLine();
		
		if(s.equals("네")){
			state = STATE.RESET;
		} else if(s.equals("아니오")) {
			exitGame();
			state = STATE.EXIT;
		} 
		
	}

	private static void exitGame() {
		System.out.println("\nGAME OVER");
		System.out.println("수고하셨습니다. 최종 점수는 " + score + "점 입니다.");
	}
	
	//
	public static void main(String[] args) {

		state = STATE.START;
		while(state!=STATE.EXIT) {
		
			switch (state) {
			case START: 
				printGame();
				break;
			case RESET:
				resetGame();
				break;
			case PLAY:
				playGame();
				break;
			case GAMEOVER:
				retryGame();
				break;
			case EXIT:
				exitGame();
				break;
			}
			
		}
		
	}
	//

}
