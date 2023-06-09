import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()); // 수열 크기
		int[] arr = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 길이가 1인 경우부터 시작해서 팰린드롬인지 여부를 dp로 먼저 저장해두기
		boolean[][] palindrome = new boolean[N + 1][N + 1];
		// 길이 1인 경우
		for (int i = 1; i <= N; i++) {
			palindrome[i][i] = true;
		}
		// 길이 2인 경우
		for (int i = 1; i <= N - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				palindrome[i][i + 1] = true;
			}
		}
		// 길이가 3이상인 경우
		for (int d = 3; d <= N; d++) {
			for (int i = 1; i <= N - d + 1; i++) {
				if (arr[i] == arr[i + d - 1] && palindrome[i + 1][i + d - 2]) {
					// 1) 양쪽 끝이 같고
					// 2) 그 사이도 팰린드롬이면
					// 팰린드롬이다!
					palindrome[i][i + d - 1] = true;
				}
			}
		}

		int M = Integer.parseInt(br.readLine()); // 질문 개수
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken()); // 시작
			int E = Integer.parseInt(st.nextToken()); // 끝
			if (palindrome[S][E]) {
				bw.write("1");
				bw.write("\n");
			} else {
				bw.write("0");
				bw.write("\n");
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}
}