package Class2;

import java.util.Scanner;

// 이것도 에라토스테네스의 체 일듯?? 아닌듯ㅋㅋ
public class P1978_소수찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt =0;
		// 1000 이하 자연수 N개 주어짐
		
		for (int i = 0;i<N;i++) {
			// scanner로 입력 받아서 
			int input = sc.nextInt();
			int notPrime = 0;
			
			// 1이면 소수 아니니까 바로 넘기기
			if (input ==1) {
				continue;
			}
			
			// 소수인지 판별
			for(int j = 2;j<input;j++) {
				// 1과 자기자신 말고 약수로 가지면 카운트 하지 않음. break.
				if (input%j == 0) {
					notPrime++;
					break;
				}				
			}
			
			// 소수면 cnt +1
			if (notPrime == 0) cnt++;			
			
		}
		
		System.out.println(cnt);
		
	} //main
}
