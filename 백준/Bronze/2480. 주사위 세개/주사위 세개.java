import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] count = new int[7];

		for (int i = 0; i < 3; i++) {
			count[sc.nextInt()]++;
		}
		int max = 0;
		int reward = 0;
		for (int i = 1; i <= 6; i++) {
			if (count[i] >= 3) {
				reward = 10000 + i * 1000;
				break;
			} else if (count[i] >= 2) {
				reward = 1000 + i * 100;
				break;
			} else if (count[i] >= 1) {
				max = i;
			}
		}
		if (reward == 0) {
			reward = max * 100;
		}

		System.out.println(reward);
	}
}