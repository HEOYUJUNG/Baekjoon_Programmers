import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 스크린 크기
		int size = Integer.parseInt(st.nextToken()); // 바구니 크기
		int apple = Integer.parseInt(br.readLine()); // 사과 개수
		int position = 1;
		int d = 0;
		for (int i = 0; i < apple; i++) {
			int target = Integer.parseInt(br.readLine());
			if ((target >= position) && (position + size - 1 >= target))
				continue;
			if (target < position) {
				d += (position - target);
				position = target;
			} else {
				d += (target - position - size + 1);
				position = target - size + 1;
			}
		}
		System.out.println(d);
	}
}