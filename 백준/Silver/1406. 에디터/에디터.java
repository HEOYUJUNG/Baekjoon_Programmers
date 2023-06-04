import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static class Node {
		char data;
		Node prev, next;

		public Node() {

		}

		public Node(char data) {
			this.data = data;
		}
	}

	static class DoublyLinkedList {
		Node head;
		Node tail;
		Node cur;
		Node[] nodePool;
		int nodeCnt;

		public DoublyLinkedList() {
			nodePool = new Node[600000];
			head = new Node(); // 더미 노드
			tail = head;
			cur = tail;
		}

		Node getNewNode(char data) {
			nodePool[nodeCnt] = new Node(data);
			return nodePool[nodeCnt++];
		}

		// 왼쪽으로 한 칸 이동 (맨 앞이면 무시)
		void moveLeft() {
			if (cur == head) {
				return;
			}
			cur = cur.prev;
		}

		// 오른쪽으로 한 칸 이동 (맨 뒤면 무시)
		void moveRight() {
			if (cur == tail) {
				return;
			}
			cur = cur.next;
		}

		// 왼쪽 문자 삭제 (맨 앞이면 무시)
		void delete() {
			if (cur == head) {
				return;
			}
			if (cur == tail) {
				cur.prev.next = null;
				cur = cur.prev;
				tail = cur;
				return;
			}
			cur.prev.next = cur.next;
			cur.next.prev = cur.prev;
			cur = cur.prev;
		}

		// 왼쪽에 문자 추가
		void insert(char c) {
			Node newNode = getNewNode(c);
			if (cur == tail) {
				cur.next = newNode;
				newNode.prev = cur;
				cur = cur.next;
				tail = cur;
				return;
			}

			// 추가한 노드 이어주기
			newNode.next = cur.next;
			newNode.prev = cur;
			cur.next.prev = newNode;
			cur.next = newNode;
			// 커서를 추가된 노드 뒤로 이동
			cur = cur.next;
		}

		void print() throws IOException {
			cur = head.next;
			while (cur != null) {
				bw.write(cur.data);
				cur = cur.next;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DoublyLinkedList list = new DoublyLinkedList();
		char[] init = br.readLine().toCharArray();
		for (char c : init) {
			list.insert(c);
		}

		int M = Integer.parseInt(br.readLine()); // 명령어 개수
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			char cmd = st.nextToken().charAt(0);
			switch (cmd) {
			case 'L':
				list.moveLeft();
				break;
			case 'D':
				list.moveRight();
				break;
			case 'B':
				list.delete();
				break;
			default:
				char c = st.nextToken().charAt(0);
				list.insert(c);
				break;
			}
		}
		list.print();
		bw.flush();
	}
}