package Class3;

import java.io.*;
import java.util.*;

public class P1764_듣보잡 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();
		int M = sc.nextInt();

		int cnt = 0;
		HashSet<String> hs = new HashSet<>();
		List<String> result = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			hs.add(sc.next());
		}
		for (int i = 0; i < M; i++) {
			String input = sc.next();
			if (hs.contains(input)) {
				cnt++;
				result.add(input);
			}
		}

		Collections.sort(result);
		sb.append(cnt + "\n");
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i) + "\n");
		}
		System.out.println(sb);
	}
}
