import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();
        int t = sc.nextInt();

        int S = t % 60;
        int M = t / 60;
        int H = M / 60;
        M -= H * 60;

        s += S;
        if (s >= 60) {
            m += 1;
            s %= 60;
        }
        m += M;
        if (m >= 60) {
            h += 1;
            m %= 60;
        }
        h += H;
        h %= 24;
        System.out.println(h + " " + m + " " + s);
    }
}