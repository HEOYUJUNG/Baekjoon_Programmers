import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			HashMap<String, Integer> map = new HashMap<>();
			ArrayList<Integer> list = new ArrayList<>();
			int N = sc.nextInt(); // 의상 개수
			for (int i = 0; i < N; i++) {
				String name = sc.next(); // 의상 이름
				String type = sc.next(); // 의상 종류
				if (map.containsKey(type)) {
					map.put(type, map.get(type) + 1);
				} else {
					map.put(type, 1);
				}
			}

			int res = 1;

			Iterator<String> keys = map.keySet().iterator();
			while (keys.hasNext()) {
				String key = keys.next();
				res *= (map.get(key) + 1);
			}
			System.out.println(res - 1);
		}
	}
}