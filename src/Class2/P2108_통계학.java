package Class2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P2108_통계학 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // N은 홀수

		// N개의 수 입력 받아서 배열에 저장
		int[] arr = new int[N];
		// 산술평균 구하기 위해 합 계산도 동시에 수행
		double sum = 0;
		// 빈도수 구하기 => 카운팅 배열 만드는 형태는 배열 크기를 8001로 만들어야 함..
		int[] count = new int[8001]; // -4000 ~ 4000
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
			count[arr[i] + 4000]++;
		}

		// 산술평균 : N개의 수들의 합을 N으로 나눈 값
		// 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
		int arithmeticMean = (int) Math.round(sum / N);
		System.out.println(arithmeticMean);

		// 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
		int median = 0;
		int cnt = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0) {
				cnt += count[i];
			}
			if (cnt >= (N / 2 + 1)) {
				median = i - 4000;
				break;
			}
		}
		
		System.out.println(median);

		// 최빈값 : N개의 수들 중 가장 많이 나타나는 값
		// 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
		// 범위 : N개의 수들 중 최댓값과 최솟값의 차이
		List<Integer> mode = new ArrayList<>();
		int maxCount = 0;

//		System.out.println(Arrays.toString(count));
		int min = 5000, max = 5000;
		for (int i = 0; i < count.length; i++) {
			if (count[i] > maxCount) {
				maxCount = count[i]; // 일단 최빈값이려면 몇 번 있어야 하는지 카운트
			}
			
			if (count[i] != 0 && min == 5000) {
				min = i - 4000;
				max = i - 4000;
			} else if (count[i] != 0) {
				max = i - 4000;
			}
		}
		
//		System.out.println("min : "+min);
//		System.out.println("max : "+max);
		int range = max - min;

		// 최빈값들 구해서 mode 리스트에 저장
		for (int i = 0; i < count.length; i++) {
			if (count[i] == maxCount) {
				mode.add(i - 4000);
			}
		}

		if (mode.size() == 1) {
			System.out.println(mode.get(0));
		} else if (mode.size() > 1) { // 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
			System.out.println(mode.get(1));
		}
		System.out.println(range);
	}
}
