import java.util.Scanner;

public class Main {
	static int[] tree;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		tree = new int[10000];

		int i = 0;
		// 입력이 있으면 계속 입력 받기 (VLR)
		while (sc.hasNext()) {
			tree[i++] = sc.nextInt();
		}

		// 현재 i는 트리에 있는 노드 개수
		postTraverse(0, i);
		System.out.println(sb);
	}

	private static void postTraverse(int start, int end) {
		// 기저 조건
		if (start >= end) {
			return;
		}

		// 유도 조건
		// L과 R의 구분 지점 찾기
		int i = 0;
		for (i = start + 1; i < end; i++) {
			if (tree[i] > tree[start]) {
				break;
			}
		}
		// L
		postTraverse(start + 1, i);
		// R
		postTraverse(i, end);
		// V (출력)
		sb.append(tree[start] + "\n");
	}
}
