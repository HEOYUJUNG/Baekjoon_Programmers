import java.io.*;
import java.util.*;

public class Main {
	static class Trie {
		char num;
		Map<Character, Trie> children = new HashMap<>();

		public Trie(char num) {
			this.num = num;
		}

		public Trie() {

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			Queue<String> pq = new PriorityQueue<>(new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					return o2.length() - o1.length();
				}
			});
			for (int i = 0; i < n; i++) {
				String phoneNum = br.readLine();
				pq.add(phoneNum);
			}
			Trie head = new Trie(); // 루트 노드
			for (int i = 0; i < n; i++) {
				String phoneNum = pq.poll();
				Trie idxTrie = head;
				boolean isYES = false;
				for (int j = 0; j < phoneNum.length(); j++) {
					char num = phoneNum.charAt(j);
					if (!idxTrie.children.containsKey(num)) {
						Trie newTrie = new Trie(num);
						idxTrie.children.put(num, newTrie);
						isYES = true;
					}
					idxTrie = idxTrie.children.get(num);
				}
				if (!isYES) {
					System.out.println("NO");
					break;
				}
				if (i == n - 1) {
					System.out.println("YES");
				}
			}
		}
	}
}