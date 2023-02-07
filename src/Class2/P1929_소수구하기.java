package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class P1929_소수구하기 {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		
		int M = Integer.parseInt(s[0]);
		int N = Integer.parseInt(s[1]);

//		List<Integer> result = new ArrayList<>();

		for (int i = M; i <= N; i++) {
			// 소수는 약수로 1과 자기자신만 가짐
			int j;
			for (j = 2; j < i; j++) { // 1 ~ (i-1) 사이에 있는 자연수로 j 나눴을 때, 나머지 0인 경우가 있으면 소수 아님!
				if (i % j == 0) {
					break;
				}
			}

			// i가 소수가 아니라면 j와 i 다름
			// i가 소수라면 j == i
			if (i == j) { 
				System.out.println(i);  //----> 매번 출력하니까 시간초과됨..!! 이거 때문은 아닌 듯.
//				result.add(i);
			}   

			
		}

//		for (int i = 0; i < result.size(); i++) {
//			System.out.println(result.get(i));
//		}
		
//		Iterator<Integer> e = result.iterator();
//		while (e.hasNext()) {
//			System.out.println(e.next());
//		}
	} // main
}
