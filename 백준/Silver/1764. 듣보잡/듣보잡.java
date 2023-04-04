import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = sc.nextInt();
//		int M = sc.nextInt();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = 0;
		HashSet<String> hs = new HashSet<>();
		List<String> result = new ArrayList<>();

		for (int i = 0; i < N; i++) {
//			map1.put(i, sc.next());
			hs.add(br.readLine());
		}
		for (int i = 0; i < M; i++) {
			String input = br.readLine();
//			String input = sc.next();
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