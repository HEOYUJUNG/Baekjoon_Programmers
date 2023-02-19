// 정답님아님

package Class2;

import java.util.Arrays;
import java.util.Scanner;

public class P4949_균형잡힌세상 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			// 한 줄이 한 문장X
			// . 으로 끝나야 한 문장
			String line = sc.nextLine();
			char[] lineChar = new char[100];
			char[] lineChar2 = new char[100];
//			char[] total = new char[100];
			lineChar = line.toCharArray();
			// 온점 하나(.) 입력되면 종료
			if (line.equals(".")) {
				return;
			} else if(lineChar[lineChar.length-1]!='.') {
				String line2 = sc.nextLine();
				lineChar2 = line2.toCharArray();
				System.arraycopy(lineChar2, 0, lineChar, line.length(), line2.length());
//				total = new char[line.length()+line2.length()];
//				System.arraycopy(lineChar, 0, total, 0, line.length());
//				System.arraycopy(lineChar2, 0, total, line.length(), line2.length());
				
			}
			
			System.out.println(Arrays.toString(lineChar));

			// 소괄호 : round bracket => R
			// 대괄호 : square bracket => S
			// 각각 기호의 개수 저장
			int LR = 0;
			int RR = 0;
			int LS = 0;
			int RS = 0;
			int inLR = 0;
			int inRR = 0;
			int inLS = 0;
			int inRS = 0;
			for (int i = 0; i < lineChar.length; i++) {
				if (lineChar[i] == '(') {
					LR++;
					if(LS!=RS) {
						inLR++;						
					}
					inLS=0;
					inRS=0;
					System.out.printf("inLR %d  inRR %d  inLS %d  inRS %d\n",inLR,inRR,inLS,inRS);
				} else if (lineChar[i] == ')') {
					RR++;
					inRR++;
					if(LR < RR ||inLS!=inRS) {
						// 오른쪽 괄호가 왼쪽 괄호보다 많아진 순간 균형 깨짐
						System.out.println("여기다1");
						break;
					}
					inLS=0;
					inRS=0;
				} else if (lineChar[i] == '[') {
					LS++;
					if(LR!=RR) {
						inLS++;						
					}
					inLR=0;
					inRR=0;
					System.out.printf("inLR %d  inRR %d  inLS %d  inRS %d\n",inLR,inRR,inLS,inRS);
				} else if (lineChar[i] == ']') {
					RS++;
					inRS++;
					if(LS < RS||inLR!=inRR) {
						// 오른쪽 괄호가 왼쪽 괄호보다 많아진 순간 균형 깨짐
						System.out.println("여기다2");
						System.out.printf("inLR %d  inRR %d  inLS %d  inRS %d\n",inLR,inRR,inLS,inRS);
						break;
					}
					inLR=0;
					inRR=0;
				}
			}
			
			// 오른쪽 괄호와 왼쪽 괄호 개수 다르면 균형 깨진 것
			if(LR!=RR || LS!=RS) {
				System.out.println("no");				
			} else {
				System.out.println("yes");
			}
		}
	} // main
}
