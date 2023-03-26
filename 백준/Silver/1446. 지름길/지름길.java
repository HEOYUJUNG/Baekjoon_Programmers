import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int N, D;
	static ArrayList<Node> graph;

	private static class Node {
		int start;
		int end; // 다음 노드의 인덱스. 즉, 지름길의 도착 지점
		int cost; // 비용. 즉, 지름길의 거리

		Node(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 지름길 개수, 12이하 양의 정수
		D = sc.nextInt(); // 고속도로 길이, 10000이하 자연수
		graph = new ArrayList<>();

		// N개의 지름길 정보 입력받기
		for (int i = 0; i < N; i++) {
			int start = sc.nextInt(); // 지름길 시작 위치
			int end = sc.nextInt(); // 지름길 도착 위치
			int d = sc.nextInt(); // 지름길 길이
			if (start <= D && end <= D && (d < (end - start))) {
				graph.add(new Node(start, end, d));
			}
		}

		Collections.sort(graph, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.start - o2.start;
			}
		});

//		for (int i = 0; i < graph.size(); i++) {
//			System.out.println(graph.get(i).start);
//		}
//
//		System.out.println();

		// 다익스트라 알고리즘 초기화
		int[] dist = new int[D + 1]; // 최소 비용 저장할 배열
		for (int i = 0; i < D + 1; i++) {
			dist[i] = i; // 일단 각각의 거리만큼으로 초기화 해두기
		}

		for (int i = 0; i < graph.size(); i++) {
			if (dist[graph.get(i).start] + graph.get(i).cost < dist[graph.get(i).end]) {
				int diff = dist[graph.get(i).end] - (dist[graph.get(i).start] + graph.get(i).cost);
				for (int j = graph.get(i).end; j < D + 1; j++) {
//					System.out.println(j);
//					System.out.println(Arrays.toString(dist));
					if (j < D - 1 && dist[j] != dist[j + 1] - 1) { // 달라지는 구간이 있는 건 다른 지름길의 도착지점이었다는 것!
						if (diff < dist[j] - dist[j + 1] + 1) { // 다른 지름길이 더 빨랐으면 더 탐색할 필요 X
							break;
						} else {
							diff = (diff - (dist[j] - dist[j + 1] + 1));
						}
					}
					dist[j] -= diff;
				}

//				System.out.println(dist[D]);
			}
		}

		System.out.println(dist[D]);

	}
}