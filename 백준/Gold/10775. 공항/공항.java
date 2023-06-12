import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int[] gates;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int G = Integer.parseInt(br.readLine()); // 게이트 수
		int P = Integer.parseInt(br.readLine()); // 비행기 수
		gates = new int[G + 1];
		for (int i = 1; i <= G; i++) {
			gates[i] = i; // 해당 번호의 비행기가 들어왔을 때, 들어갈 수 있는 게이트 중 가장 큰 값 (0이면 불가능)
		}
		int cnt = 0;
		for (int i = 0; i < P; i++) {
			int airplane = Integer.parseInt(br.readLine());
			int target = findSet(airplane);
			if (target == 0)
				break;
			union(target - 1, target);
			cnt++;
		}
		bw.write(String.valueOf(cnt));
		bw.flush();
		br.close();
		bw.close();
	}

	// x를 포함하는 집합의 대표자 반환
	static int findSet(int x) {
		if (gates[x] == x)
			return x;
		return gates[x] = findSet(gates[x]);
	}

	// x집합에 y집합 포함시키기
	static void union(int x, int y) {
		gates[findSet(y)] = findSet(x);
	}
}