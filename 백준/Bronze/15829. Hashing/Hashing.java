import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		final int r = 31;
		final int M = 1234567891;
		int L = sc.nextInt(); // 문자열의 길이
		char[] cArr = sc.next().toCharArray();

		long sum = 0;
		for (int i = 0; i < L; i++) {

			// Math.pow 시도
//			double temp = (cArr[i] - 96) * Math.pow(r, i); // Math.pow 결과 값이 double이네..
			// BigInteger 시도
//			sum = sum.add(BigInteger.valueOf((int) temp));

			// 아스키코드 'a' = 97이니까 96 빼주면 a=1, b=2... 이렇게 됨!
			int ar = (cArr[i] - 96);
			for (int j = 0; j < i; j++) {
				// 중간중간 나눠줘야 함!!! -> 마지막에 이거 고치니까 100점..
				ar = ar * r % M;
			}
			sum = (sum + ar) % M;
		}

		System.out.println(sum);
	}
}