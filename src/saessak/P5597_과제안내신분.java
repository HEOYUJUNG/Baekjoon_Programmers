package saessak;

import java.util.Scanner;

public class P5597_과제안내신분 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[30];
		for (int i = 0; i < 28; i++) {
			arr[sc.nextInt()-1]++;
		}
		for (int i = 0; i < 30; i++) {
			if(arr[i]==0) {
				System.out.println(i+1);
			}
		}
	}
}
