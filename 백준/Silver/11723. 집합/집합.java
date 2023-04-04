import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
//		Set<Integer> set = new HashSet<>();
		int M = sc.nextInt(); // 연산 개수
		boolean[] num = new boolean[21];

		for (int i = 0; i < M; i++) {
			String cmd = sc.next();
			switch (cmd) {
			case "add":
				num[sc.nextInt()] = true;
				break;
			case "remove":
				num[sc.nextInt()] = false;
				break;
			case "check":
				if (num[sc.nextInt()]) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");					
				}
				break;
			case "toggle":
				int x = sc.nextInt();
				num[x] = !num[x];
				break;
			case "all":
				Arrays.fill(num, true);
				break;
			default: // empty일 때
				Arrays.fill(num, false);
				break;
			}
		}
		System.out.println(sb);
	}
}