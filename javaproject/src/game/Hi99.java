package game;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

//Hi99 hi = new Hi99();
//hi.hi_start();
//serial_Num = 2;
//  score;// 총점

public class Hi99 extends Thread {
	Random random = new Random();
	Scanner sc = new Scanner(System.in);
	String pattern = "^[0-9]*$";// 숫자만
	String val = "123456789"; // 대상문자열

	public static void main(String[] args) {
		// 테스트 위해서 사용
		Hi99 hi99 = new Hi99();
		hi99.hi_start();
	}

	int x;// 앞자리
	int y;// 뒷자리
	String z;// 사용자입력값
	int answer;// 앞*뒤=결과값
	static int score;// 총점
	int plus = 10;// 추가점수
	int count_down = 0;// 카운트 다운
	int start_count = 10;// 잔여시간
	int serial_Num = 2;// 게임 시리얼넘버

	@Override
	public void run() {// 스레드
		try {
			while (start_count > count_down) {
				start_count--;
				Thread.sleep(1000);// 1초
				// start_count 끝나면 실행
			}
			Thread.interrupted();
		} catch (InterruptedException e) {

		} finally {
			System.out.println("시간이 종료 되었습니다.");
			System.out.println("총 스코어 " + score + "입니다. 축하합니다");
		}

	}

	public void hi_start() {
		Hi99 thread = new Hi99();

		System.out.println("구구단 게임을 시작합니다.");
		System.out.println(start_count + "초 동안 문제를 빠르게 풀어주세요");
		System.out.println("시작!");

		thread.start();// 스레드 실행 (run)
		while (true) {
			x = random.nextInt(9) + 1;
			y = random.nextInt(9) + 1;
			answer = x * y;// 곱셈 결과 값

			System.out.print(x + " x " + y + " => ");
			while (true) {
				z = sc.nextLine();// 사용자 입력
				Boolean regex = Pattern.matches(pattern, z);
				if (!regex) {
					System.out.println("정수만 입력해주세요");
					continue;

				} else if (answer == Integer.valueOf(z)) {
					score += 10;
					System.out.println("정답입니다! " + plus + "점 추가 " + "총점 =>" + score);
					break;
				} else {
					System.out.println("오답입니다! 정답-> " + answer + " 총점 =>" + score + " 다음문제");
					break;
				}
			}
		}
	}
}
