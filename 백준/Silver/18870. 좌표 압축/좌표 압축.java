import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] arr2 = new int[N];
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			arr2[i] = arr[i];
		}

		Arrays.sort(arr); // 오름차순 정렬

		int rank = 0;
		for (int i = 0; i < N; i++) {
			if (!map.containsKey(arr[i]))
				map.put(arr[i], rank++);
		}

		for (int i = 0; i < N; i++) {
			sb.append(map.get(arr2[i]) + " ");
		}
		System.out.println(sb);
	}
}
