package Class2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution1259 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String input = sc.next();
		List<String> inputList = new ArrayList<>();

		while (!(input.equals("0"))) {
			inputList.add(input);
			input = sc.next();
		} // while

		for (String s : inputList) {
			int No = 0;
			String[] arr = s.split(""); // 각각의 숫자를 하나씩 쪼개서 저장
			for (int i = 0; i < arr.length / 2; i++) { // 숫자의 자릿수가 홀수라면, 어차피 가운데 수는 같음.
				if (!(arr[i].equals(arr[arr.length - 1 - i]))) { // 뒤에서부터 읽은 수와 같지 않다면
					System.out.println("no");
					No++; // 팰린드롬이 아니라는 표시
					break;
				}
			}
			if (No == 0)
				System.out.println("yes"); // 팰린드롬인 수면 yes 출력
		} // for
	} // main
}
