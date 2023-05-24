import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		char[] word = sc.next().toCharArray();
		for (int i = 0; i < word.length; i++) {
			if (word[i] >= 'a' && word[i] <= 'z') {
				word[i] -= 32;
			} else {
				word[i] += 32;
			}
			sb.append(word[i]);
		}
		System.out.println(sb);

	}
}