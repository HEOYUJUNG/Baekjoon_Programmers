import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 로프 개수
		int[] maxW = new int[N]; // 최대 중량 저장할 배열
		for (int i = 0; i < N; i++) {
			maxW[i] = sc.nextInt(); // 로프가 버틸 수 있는 최대 중량
		}

		Arrays.sort(maxW);
		double W = maxW[0] * N; // 가장 약한 로프 * 로프 개수 만큼은 들 수 있음
		int cut = 0; // 중량 버티지 못하고 끊어진 로프 수. 약한 로프부터 오름차순으로 정렬했으니까 앞에서부터 끊어질 것임.
		while (true) {
			W++; // 물체 중량 1씩 올리면서 가능한지 판단
			for (int i = cut; i < N; i++) {
				if (W / (N - cut) > maxW[i]) {
					cut = i + 1;
				} else {
					break;
				}
			}
			// 안되면 break.로프 다 끊어지면 안 되는 거임.
			if (cut == N) {
				W--; // +1 해서 판단했을 때 안된 거니까 -1 감소하고 break
				break;
			}
		}
		// 로프들을 이용하여 들어올릴 수 있는 물체의 최대 중량
		System.out.println((int) W);
	}
}