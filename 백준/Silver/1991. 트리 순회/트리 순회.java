import java.util.Scanner;

public class Main {
	static char[] arr;
	static StringBuilder sb1 = new StringBuilder();
	static StringBuilder sb2 = new StringBuilder();
	static StringBuilder sb3 = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 노드 개수
		arr = new char[67108865]; // 노드 개수 최대 2^26 = 67108864
		int[] pos = new int[N]; // 각 노드마다 트리에서의 번호 기록
		arr[1] = 'A'; // 항상 A가 루트 노드가 된다.
		pos[0] = 1; // A의 번호는 1

		// 노드 개수만큼 입력받기
		for (int i = 1; i <= N; i++) {
			char cur = sc.next().charAt(0);
			int j = pos[cur - 'A'];
			char Lchild = sc.next().charAt(0);
			char Rchild = sc.next().charAt(0);
			if (Lchild != '.') {
				arr[j * 2] = Lchild;
				pos[Lchild - 'A'] = j * 2;
			}
			if (Rchild != '.') {
				arr[j * 2 + 1] = Rchild;
				pos[Rchild - 'A'] = j * 2 + 1;
			}
		}

		// 전위 순회
		preTraverse(1);
		// 중위 순회
		inTraverse(1);
		// 후위 순회
		postTraverse(1);
		
		System.out.println(sb1);
		System.out.println(sb2);
		System.out.println(sb3);
	}

	// 전위 순회
	private static void preTraverse(int x) {
		if (arr[x] != '\0') {
			// V : 자기 자신 방문처리
			sb1.append(arr[x]);
			// L : 왼쪽 자식 방문
			preTraverse(x * 2);
			// R : 오른쪽 자식 방문
			preTraverse(x * 2 + 1);
		}
	}

	// 중위 순회
	private static void inTraverse(int x) {
		if (arr[x] != '\0') {
			// L : 왼쪽 자식 방문
			inTraverse(x * 2);
			// V : 자기 자신 방문처리
			sb2.append(arr[x]);
			// R : 오른쪽 자식 방문
			inTraverse(x * 2 + 1);
		}
	}

	// 후위 순회
	private static void postTraverse(int x) {
		if (arr[x] != '\0') {
			// L : 왼쪽 자식 방문
			postTraverse(x * 2);
			// R : 오른쪽 자식 방문
			postTraverse(x * 2 + 1);
			// V : 자기 자신 방문처리
			sb3.append(arr[x]);
		}
	}
}