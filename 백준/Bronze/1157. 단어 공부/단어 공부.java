import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int[] alphabet = new int[26];
		char[] arr = sc.next().toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 'A' && arr[i] <= 'Z') {
				alphabet[arr[i] - 'A']++;
				max = (max < alphabet[arr[i] - 'A']) ? alphabet[arr[i] - 'A'] : max;
			} else {
				alphabet[arr[i] - 'a']++;
				max = (max < alphabet[arr[i] - 'a']) ? alphabet[arr[i] - 'a'] : max;
			}
		}

		int result = -1;
		for (int i = 0; i < 26; i++) {
			if (alphabet[i] == max) {
				result = (result == -1) ? i : -2;
			}
		}

		if (result == -2) {
			System.out.println('?');
		} else {
			System.out.println((char) (65 + result));
		}
	}
}