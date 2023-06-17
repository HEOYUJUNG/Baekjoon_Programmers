import java.io.*;
import java.util.*;

public class Main {
	static Node[] tree;
	static ArrayList<Integer> ancestor1, ancestor2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 노드 개수
			// 트리 초기화
			tree = new Node[N + 1];
			for (int i = 1; i <= N; i++) {
				tree[i] = new Node();
			}
			// 간선 정보 입력
			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken()); // 부모
				int B = Integer.parseInt(st.nextToken()); // 자식
				tree[A].children.add(B); // A의 자식으로 B 추가
				tree[B].parent = A; // B의 부모로 A 지정
			}

			// 가장 가까운 공통 조상(LCA) 구할 두 노드
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());

			// 각각의 공통 조상들 구하기
			ancestor1 = new ArrayList<>();
			ancestor2 = new ArrayList<>();
			findAncestor(node1, ancestor1);
			findAncestor(node2, ancestor2);

			// 공통 조상들 중 마지막에 있는 것이 LCA
			int LCA = 0;
			for (int i = 0; i < Math.min(ancestor1.size(), ancestor2.size()); i++) {
				if (!ancestor1.get(i).equals(ancestor2.get(i))) // Integer끼리는 equals 비교!!
					break;
				LCA = ancestor1.get(i);
			}
			sb.append(LCA + "\n");
		} // testcase
		System.out.println(sb);
	}

	static class Node {
		List<Integer> children;
		int parent;

		public Node() {
			this.children = new ArrayList<>();
			this.parent = 0;
		}
	}

	static void findAncestor(int idx, ArrayList<Integer> ancestor) {
		int p = tree[idx].parent;
		if (p != 0) {
			findAncestor(p, ancestor);
		}
		ancestor.add(idx);
	}
}