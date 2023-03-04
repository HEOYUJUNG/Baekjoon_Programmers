import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 행렬 크기 N*M (50 이하 자연수)
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] A = new char[N][M];
		char[][] B = new char[N][M];

		// 행렬 A 입력받기
		for (int r = 0; r < N; r++) {
			String line = sc.next();
			A[r] = line.toCharArray();
		}

		// 행렬 B 입력받기
		for (int r = 0; r < N; r++) {
			String line = sc.next();
			B[r] = line.toCharArray();
		}

		int cnt = 0;
		// 왼쪽->오른쪽, 위->아래 방향으로 탐색.
		here: for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (A[r][c] != B[r][c]) { // r,c칸에서의 원소 값이 다르면
					if (r == (N - 2) || r == (N - 1) || c == (M - 2) || c == (M - 1)) {
						// 더이상 3*3 만큼 바꿀 수 없는 범위에서 다른 값이 발견되었다면 A를 B로 바꿀 수 없는 경우임
						// -1 출력해야함
						cnt = -1;
						break here;
					}
					// 3*3 범위에 있는 모든 원소 뒤집기
					for (int i = r; i < r + 3; i++) {
						for (int j = c; j < c + 3; j++) {
							if (A[i][j] == '1')
								A[i][j] = '0';
							else
								A[i][j] = '1';							
						}
					}
					// 3*3만큼 뒤집는 연산 한 번 했으니까 카운팅
					cnt++;
				}
			}
		}

		// 바꾼 횟수 출력
		System.out.println(cnt);
	}
}