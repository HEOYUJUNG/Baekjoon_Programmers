import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int M;
	private static List<Pos> Home;
	private static List<Pos> Chicken;
	private static Pos[] sel;
	private static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 도시 크기
		M = sc.nextInt(); // 폐업시키지 않을 치킨집 최대 개수 = 남는 치킨집 개수

		Home = new ArrayList<>();
		Chicken = new ArrayList<>();
		sel = new Pos[M]; // 전체 치킨집들 중 폐업시키지 않고 남길 치킨집들 M개 선택할 배열
		min = Integer.MAX_VALUE; // 치킨 거리의 최솟값 (최대로 초기화)

		// 도시 정보 입력받기
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int tmp = sc.nextInt();
				if (tmp == 1) { // 집인 경우
					Home.add(new Pos(r, c));
				} else if (tmp == 2) { // 치킨집인 경우
					Chicken.add(new Pos(r, c));
				}
			}
		}

		// 치킨집 중에 M개를 뽑는 모든 경우의 수에 대해서 도시의 치킨 거리 구해보고, 최솟값 갱신하기
		comb(0, 0);

		System.out.println(min);
	}

	private static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	// 조합
	private static void comb(int idx, int sidx) {
		// 기저 조건
		// M개만큼 다 뽑았다!
		if (sidx == M) {
			int d = calChickenD();
			min = (d < min) ? d : min; // 최소값 갱신
			return;
		}

		// 유도 조건
		for (int i = idx; i <= Chicken.size() - M + sidx; i++) {
			sel[sidx] = Chicken.get(i);
			comb(i + 1, sidx + 1); // i번째 고른 경우
			comb(i + 1, sidx); // i번째 안 고른 경우
		}
	}

	// 치킨집들과 집들 위치가 주어졌을 때 도시의 치킨 거리 구하기
	private static int calChickenD() {
		int D = 0; // 도시의 치킨거리
		for (Pos home : Home) {
			int minD = Integer.MAX_VALUE; // 각 집의 치킨거리
			for (Pos chicken : sel) {
				// 모든 치킨집과의 거리 구하고 나서 최솟값보다 작으면 갱신하기
				int tmpD = calD(chicken, home);
				minD = (tmpD < minD) ? tmpD : minD;
			}
			D += minD;
		}
		return D;
	}

	// 두 위치 사이의 거리 구하기
	private static int calD(Pos p1, Pos p2) {
		return (Math.abs(p1.r - p2.r) + Math.abs(p1.c - p2.c));
	}
}