import java.util.Scanner;

public class Main {
	static String S;
	static String T;
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		S = sc.next();
		T = sc.next();

		int SB = 0;
		int TB = 0;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == 'B') {
				SB++;
			}
		}
		for (int i = 0; i < T.length(); i++) {
			if (T.charAt(i) == 'B') {
				TB++;
			}
		}
		int d = T.length() - S.length();

		result = 0; // 일단 바꿀 수 없다고 가정하고 시작
		find(T);
		System.out.println(result);
	}

//	// 문자열 바꾸는 첫번쨰 연산
//	public static String cal1(String s) {
//		s += 'A'; // 문자열의 뒤에 A를 추가한다.
//		return s;
//	}
//
//	// 문자열 바꾸는 두번째 연산
//	public static String cal2(String s) {
//		s += 'B'; // 문자열의 뒤에 B를 추가하고
//		// 문자열을 뒤집는다.
//		StringBuffer sb = new StringBuffer(s);
//		return sb.reverse().toString();
//	}

	// T에서 빼는 방법으로 해보기
	// 문자열 뒤에서 A 제거
	public static String cal1(String s) {
		return s.substring(0, s.length() - 1);
	}

	// 문자열 뒤집고 -> 문자열 문자열 뒤에서 B 제거
	public static String cal2(String s) {
		StringBuffer sb = new StringBuffer(s);
		return sb.reverse().toString().substring(0, s.length() - 1);
	}

	public static void find(String s) { // 문자열 전달, B 추가하는 두번째 연산 몇 번 더 수행할 수 있는지 전달
		if (result == 1) {
			return;
		}

		// 기저 조건 (언제 종료?)
		if (s.length() == S.length()) {
			result = 1; // 일단 S와 T가 같을 거라고 가정
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != S.charAt(i)) {
					result = 0; // S와 T가 다르다면 false로 바꿔주기
					return; // 종료.
				}
			}
			// S, T 같으면
			return; // 그대로 종료
		}

		// 유도 조건
		// 두가지 연산 다 해보기
//		if (x > 0) {
//			find(cal1(s), x - 1, y);
//		}
//		if (y > 0) {
//			find(cal2(s), x, y - 1);
//		}

		if (s.charAt(s.length()-1) == 'A') {
			find(cal1(s));
		}
		if (s.charAt(0) == 'B') {
			find(cal2(s));
		}
	}
}