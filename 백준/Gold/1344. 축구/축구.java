import java.util.Scanner;

public class Main {
	static double[] arr; // 0 ~ 18까지 팩토리얼 값 저장할 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double A = sc.nextDouble() / 100; // A팀이 득점할 확률
		double B = sc.nextDouble() / 100; // B팀이 득점할 확률

		// 5분에 최대 1점이면 90분에 최대 18점
		// 18점을 넘지 않으면서 소수 득점이 아닌 경우
		int[] score = { 0, 1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18 }; // 총 12가지
		double p = 0; // 확률
		arr = new double[19]; // 0 ~ 18까지 팩토리얼 값 저장할 배열
		arr[0] = 1;
		for (int i = 1; i <= 18; i++) {
			arr[i] = arr[i - 1] * i;
		}

		// A팀도 소수 득점이 아니고 B팀도 소수 득점이 아닌 확률 구하기
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				// 중복 허용해서 점수 2개 선택 (A팀 0점 B팀 1점 - A팀 1점 B팀 0점 은 다른 경우!!)
				p += comb(18, score[i]) * Math.pow(A, score[i]) * Math.pow(1 - A, 18 - score[i]) * comb(18, score[j])
						* Math.pow(B, score[j]) * Math.pow(1 - B, 18 - score[j]);
			}
		}

		// 위에서 구한 확률의 여집합 구하기. 즉 1에서 빼기.
		System.out.println(1 - p);
	} // main

	// 조합 계산
	public static double comb(int n, int r) {
		return arr[n] / (arr[n - r] * arr[r]);
	}
}