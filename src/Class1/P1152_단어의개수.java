package Class1;

import java.util.Arrays;
import java.util.Scanner;

public class P1152_단어의개수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] A = sc.nextLine().split(" ");
		System.out.println(Arrays.toString(A));
		
		if (A == null) {
			System.out.println(0);
		} else {
			
			if (!(A[0].equals("")) && !(A[A.length-1].equals(""))) {
				System.out.println(A.length);
			} else if (A[0].equals("") & A[A.length-1].equals("")) {
				System.out.println(A.length - 2);
			} else {
				System.out.println(A.length - 1);
			}
		}
		
	} // main
}
