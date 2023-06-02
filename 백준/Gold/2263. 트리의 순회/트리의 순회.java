import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();
//	static List<Integer> in = new ArrayList<>();
//	static List<Integer> post = new ArrayList<>();
	static int[] in;
	static int[] inIdx;
	static int[] post;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 정점 개수

		in = new int[N + 1];
		inIdx = new int[N + 1];
		post = new int[N + 1];

		// 중위순회 입력받기
		for (int i = 1; i <= N; i++) {
//			in.add(sc.nextInt());
			in[i] = sc.nextInt();
			inIdx[in[i]] = i;
		}

		// 후위순회 입력받기
		for (int i = 1; i <= N; i++) {
//			post.add(sc.nextInt());
			post[i] = sc.nextInt();
		}

		traverse(1, N + 1, 1, N + 1);

		System.out.println(sb);
	}

	// from인덱스 ~ to인덱스-1 까지 포함!
	private static void traverse(int inFromIdx, int inToIdx, int postFromIdx, int postToIdx) {
		// 기저 조건
		if (inFromIdx >= inToIdx) {
			return;
		}

		// 유도 조건
		// V
		sb.append(post[postToIdx - 1] + " ");
//		sb.append(post.get(postToIdx - 1) + " ");

		// L
//		int idx = in.indexOf(post.get(postToIdx - 1));
		int idx = inIdx[post[postToIdx - 1]];
		int L_length = idx - inFromIdx;
		traverse(inFromIdx, idx, postFromIdx, postFromIdx + L_length);

		// R
		traverse(idx + 1, inToIdx, postFromIdx + L_length, postToIdx - 1);
	}
}
