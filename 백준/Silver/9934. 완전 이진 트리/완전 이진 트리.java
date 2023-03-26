import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int K;
	static int[] building;
	static int[] tree;
	static boolean[] visited;
	static int idx = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt(); // 완전 이진 트리의 깊이 (노드는 2^K-1개)
		building = new int[(int) Math.pow(2, K) - 1]; // 상근이가 방문한 빌딩의 번호 저장할 배열
		tree = new int[(int) Math.pow(2, K)]; // 완전 이진 트리. 도시 지도.
		visited = new boolean[(int) Math.pow(2, K)]; // 방문 표시할 배열

		// 상근이가 방문한 빌딩의 번호 입력받기
		for (int i = 0; i < Math.pow(2, K) - 1; i++) {
			building[i] = sc.nextInt();
		}

		traversal(1);

		// 레벨이 i인 빌딩의 번호를 출력
		for (int i = 1; i <= K; i++) {
			for (int j = (int) Math.pow(2, i - 1); j < (int) Math.pow(2, i); j++) {
				System.out.print(tree[j] + " ");
			}
			System.out.println();
		}
	}

	// 중위순회
	private static void traversal(int i) {
		if (i < (int) Math.pow(2, K)) {
			// L
			// 왼쪽 자식 탐색
			traversal(i * 2);

			// V
			// 자기 자신 방문 처리 -> 여기서 방문처리는 tree의 해당 인덱스에 값을 받아오는 것!
			tree[i] = building[idx++];

			// R
			// 오른쪽 자식 탐색
			traversal(i * 2 + 1);
		}
	}
}
