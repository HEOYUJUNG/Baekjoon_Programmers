import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int r = 31;
		int M = 1234567891;
		int L = sc.nextInt(); // 문자열의 길이
		char[] cArr = sc.next().toCharArray();

		long sum = 0;
		for (int i = 0; i < L; i++) {
			// 아스키코드 'a' = 97이니까 96 빼주면 a=1, b=2... 이렇게 됨!
			sum += (cArr[i] - 96) * Math.pow(r, i);
		}

		System.out.println(sum % M);
	}
}