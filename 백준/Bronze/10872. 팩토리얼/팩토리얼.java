import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = N;
		for (int i = N - 1; i >= 1; i--) {
			result *= i;
		}
		if(N==0) {
			System.out.println(1);
		}else {
			System.out.println(result);			
		}
	}
}