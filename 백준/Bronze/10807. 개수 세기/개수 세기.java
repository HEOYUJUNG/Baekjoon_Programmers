import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[201];
		for (int i = 0; i < N; i++) {
			arr[sc.nextInt() + 100]++;
		}
		int v = sc.nextInt();
		System.out.println(arr[v + 100]);
	}
}