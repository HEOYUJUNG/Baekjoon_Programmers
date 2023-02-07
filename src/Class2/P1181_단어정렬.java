package Class2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P1181_단어정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 단어들 arr 배열에 저장해두기 (중복된 단어는 받지 않음)
		int N = sc.nextInt();
		List<String> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			arr.add(sc.next());
			for (int j = 0; j < arr.size() - 1; j++) {
				if (arr.get(j).equals(arr.get(arr.size() - 1))) {
					arr.remove(arr.size() - 1);
					break;
				}
			}
		}

		String[] words = new String[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			words[i] = arr.get(i);
		}

		/* 길이가 짧은 것부터 정렬 */
		// Arrays.sort 오버라이드(재정의) 하는 것도 
		Arrays.sort(words, (String s1, String s2) -> s1.length() - s2.length());
//		System.out.println(Arrays.toString(words));

		// 단어의 길이 저장할 리스트 생성
		// (0번째 인덱스 -> 길이 1인 단어 개수 / 1번째 인덱스 -> 길이 2인 단어 개수)
//		int[] leng = new int[words.length];
//		for (int i = 0; i < words.length; i++) {
//			if (words[i].length() == (i+1)) {
//				leng[i]++;
//			}
//		}
//		System.out.println();

//		String[][] length = new String[50][N];
//		for (int i = 0;i<N;i++) {
//			if (arr[i].length() == (i+1)) {
//				length[i][length[i]]
//			}
//		}

		/* 길이가 같으면 사전 순으로 정렬 */
		for (int i = 0; i < words.length; i++) {
			int j;
			for (j = i + 1; j < words.length; j++) {
				if (words[i].length() != words[j].length()) {
					break;
				}
			}
			Arrays.sort(words, i, j);
//			System.out.println(Arrays.toString(words));
			i = j - 1;
		}

		for (int i = 0; i < words.length; i++) {
			System.out.println(words[i]);
		}
	}
}
