import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] points;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 점 개수 (3 ~ 500,000)
		int m = Integer.parseInt(st.nextToken()); // 진행된 차례 수 (3 ~ 1,000,000)

		points = new int[n];

		// 새로운 멤버 i를 포함하는 새로운 집합 생성
		for (int i = 0; i < n; i++) {
			points[i] = i;
		}

		// 게임 진행 상황 입력 받기
		int cnt = 1;
		for (int i = 0; i < m; i++) {
			// 연결할 두 점의 번호
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			if (findSet(A) == findSet(B)) { // 같은 집합에 있는 두 점이면 사이클 발생
				break;
			}
			union(A, B);
			cnt++;
		}
		if (cnt <= m) { // m번째 차례 전에 종료된 경우
			System.out.println(cnt);
		} else { // m번째 차례 전에 종료되지 않은 경우
			System.out.println(0);
		}
	}

	// x를 포함하는 집합의 대표자 반환 (경로 압축 : 모든 노드들이 직접 root를 가리키도록 바꿔줌)
	static int findSet(int x) {
		if (points[x] != x) {
			points[x] = findSet(points[x]);
		}
		return points[x];
	}

	// 합집합 (x 집합에 y 집합 포함시키기)
	static void union(int x, int y) {
		points[findSet(y)] = findSet(x);
	}
}