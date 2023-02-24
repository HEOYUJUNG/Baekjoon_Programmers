import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 회원의 수
		int N = sc.nextInt();

		// 회원들 담을 큐
		// 우선순위 큐에 담기 -> 우선순위의 기준을 무엇으로 할건지 정해주기
		PriorityQueue<Person> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1.age == o2.age) {
				// 나이 같으면 가입한 순
				return o1.regNum - o2.regNum;
			} else {
				// 나이 기준 정렬
				return o1.age - o2.age;
			}
		});

		// 회원들 큐로 입력받기
		for (int n = 0; n < N; n++) {
			pq.offer(new Person(sc.nextInt(), sc.next(), n));
		}

		// 위에서 설정한 우선순위대로 이미 정렬되어 있음
		// 그냥 꺼내서 출력!
		for (int n = 0; n < N; n++) {
			Person p = pq.poll();
			System.out.printf("%d %s\n", p.age, p.name);
		}

	}

	// Person 클래스 만들기
	public static class Person {
		int age;
		String name;
		int regNum; // 가입 순서

		// 생성자
		public Person(int age, String name, int regNum) {
			super();
			this.age = age;
			this.name = name;
			this.regNum = regNum;
		}
	}
}