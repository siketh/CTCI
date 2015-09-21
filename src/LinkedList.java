public class LinkedList {
	Node head;
	Node tail;

	public class Node {
		int data;
		Node next;
		Node previous;

		public Node(int data) {
			this.data = data;
			this.next = null;
			this.previous = null;
		}
	}

	public LinkedList() {
		this.head = null;
		this.tail = null;
	}

	public Node append(int data) {
		System.out.println("Adding: " + data);

		if (this.head == null) {
			head = new Node(data);
			printList();
			return head;
		} else if (head.next == null) {
			head.next = new Node(data);
			tail = head.next;
			tail.previous = head;
			printList();
			return tail;
		} else {
			Node oldTail = tail;
			tail.next = new Node(data);
			tail = tail.next;
			tail.previous = oldTail;

			printList();
			return tail;
		}
	}

	public Node remove(int data) {
		Node previous = null;
		Node current = head;

		while (current.data != data) {
			if (current.next == null) {
				System.out.println(data + " not found");
				return null;
			}

			previous = current;
			current = current.next;
		}

		System.out.println("Removing: " + data);

		if (current.equals(head) && head.next == null)
			head = null;
		else if (current.equals(head)) {
			head = head.next;
			head.previous = null;
		} else {
			previous.next = current.next;

			if (current.next != null)
				current.next.previous = previous;
		}

		printList();

		return current;
	}

	public Node search(int data) {
		Node current = head;

		while (current.data != data) {
			current = current.next;

			if (current.next == null) {
				System.out.println("Data not found");
				return null;
			}
		}

		return current;
	}

	public boolean isEmpty() {
		if (head == null)
			return true;
		else
			return false;
	}

	public void printList() {
		Node current = head;

		System.out.println();

		if (head == null)
			System.out.println("List is empty");
		else {
			while (current.next != null) {
				System.out.print(current.data + ", ");
				current = current.next;
			}

			System.out.println(current.data + ", ");
		}

		System.out.println();
	}

	public void printConnections() {
		Node current = head;

		System.out.println();

		if (head == null)
			System.out.println("List is empty");
		else {
			while (current != null) {
				if (current.previous == null)
					System.out.print("{n} <-- ");
				else
					System.out.print("{" + current.previous.data + "} <-- ");

				System.out.print("{" + current.data + "}");

				if (current.next == null)
					System.out.println(" --> {n}");
				else
					System.out.println(" --> {" + current.next.data + "}");

				current = current.next;
			}
		}

		System.out.println();
	}
}
