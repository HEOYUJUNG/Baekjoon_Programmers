package D2;

import java.util.Arrays;
import java.util.Scanner;

public class P4153_직각삼각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int[] arr = new int[3];
			arr[0] = sc.nextInt();
			arr[1] = sc.nextInt();
			arr[2] = sc.nextInt();

			// 0 0 0 입력되면 종료
			for(int i = 0;i<3;i++) {
				if(arr[i] != 0) break;
				if(i==2) return;
			}

			// 가장 큰 길이가 대변의 길이가 되어야 하니까, 오름차순 정렬
			Arrays.sort(arr);
			if(arr[2]*arr[2] == arr[0]*arr[0] + arr[1]*arr[1]) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
			
		}
	}
}
