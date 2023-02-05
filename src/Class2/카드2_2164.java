package Class2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 카드2_2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 카드 개수
		
		// 우선 N장의 카드를 cards 리스트에 쌓는다. 
		// 인덱스 0이 위, 마지막 인덱스가 아래
		List<Integer> cards = new ArrayList<>(N);
		for(int i = 1;i<=N;i++) {
			cards.add(i);
		}
		
//		System.out.println(cards.toString());
		
		// 카드가 한 장 남을 떄까지 반복
		while(cards.size()!=1) {
			// 1. 제일 위(앞)에 있는 카드 버리기
			cards.remove(0);
			// 2. 제일 위(앞)에 있는 카드 밑(뒤)으로 옮기기
			cards.add(cards.get(0));
			cards.remove(0);
//			System.out.println(cards.toString());
		}
		
		// 마지막 남은 카드 출력
		System.out.println(cards.get(0));
		
	}
}
