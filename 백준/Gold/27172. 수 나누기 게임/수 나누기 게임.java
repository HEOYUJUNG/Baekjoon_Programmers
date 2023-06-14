import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()); // 플레이어 수
		int[] cards = new int[N + 1];
		int[] index = new int[1000001];
		int[] score = new int[N + 1];
		// 플레이어가 가지고 있는 카드 번호 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
			index[cards[i]] = i;
		}
		// 앞에서부터 해당 카드 번호로 나누어떨어지는 카드 번호가 있는지 인덱스로 탐색
		for (int i = 1; i <= N; i++) {
			for (int idx = cards[i] * 2; idx <= 1000000; idx += cards[i]) {
				if (index[idx] >= 1) {
					score[index[idx]]--;
					score[i]++;
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			bw.write(score[i] + " ");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}