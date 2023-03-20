import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean flag1 = true;
		boolean flag2 = true;
		for (int i = 1; i <= 8; i++) {
			int N = sc.nextInt();
			if (N != i) {
				flag1 = false;
			}
			if (N != (9 - i)) {
				flag2 = false;
			}
		}

		if(flag1) {
			System.out.println("ascending");
		} else if(flag2) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
		
	}
}