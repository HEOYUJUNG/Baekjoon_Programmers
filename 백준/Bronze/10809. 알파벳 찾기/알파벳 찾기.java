import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] alphabet = new int[26];
		for (int i = 0; i < 26; i++) {
			alphabet[i] = -1;
		}

		char[] word = sc.next().toCharArray();
		for (int i = 0; i < word.length; i++) {
			if (alphabet[word[i] - 'a'] == -1) {
				alphabet[word[i] - 'a'] = i;
			}
		}

		for (int i = 0; i < 26; i++) {
			System.out.print(alphabet[i] + " ");
		}
	}
}