import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int L = 2 * N - 1;
        for(int i = 1; i <= N; i++) {
            sb.append(" ".repeat(N - i));
            sb.append("*".repeat(2 * i - 1));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}