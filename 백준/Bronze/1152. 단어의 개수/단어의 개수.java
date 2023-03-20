import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		char[] arr = sc.nextLine().toCharArray();
//		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ' ') {
				cnt++;
			}
		}

		if (arr[0] == ' ') { // 공백으로 시작하는 경우
			cnt--;
		}

		if (arr[arr.length - 1] == ' ') { // 공백으로 끝나는 경우
			cnt--;
		}

		System.out.println(cnt + 1);
	} // main
}