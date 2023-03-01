import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 에너지 드링크 수
		double[] drink = new double[N]; // 에너지 드링크의 양 저장할 배열
		for (int i = 0; i < N; i++) {
			drink[i] = sc.nextInt();
		}
		Arrays.sort(drink);
		double max = drink[N - 1]; // 일단 양이 가장 많은 에너지 드링크 담아두기
		for (int i = 0; i < N - 1; i++) {
			// 양이 큰 것과 작은 것을 비교했을 때, 양이 작은 것을 반 버리는 것이 잃는 양이 적다.
			// 따라서 max는 항상 양이 더 많을 것이기 때문에, drink[i]를 반 버리고 합쳐준다.
			max = max + drink[i] / 2;
		}

		// 결과가 정수면 소수점 떼고 1의 자리 위로만 출력
		if (max == (int) max) {
			System.out.println((int) max);
		} else { // 결과가 실수면 그냥 출력
			System.out.println(max);
		}
	} // main
}