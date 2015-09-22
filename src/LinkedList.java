import java.util.HashMap;
import java.util.Random;

public class LinkedList<T> {
	Node head;
	Node tail;

	private class Node {
		private Node next;
		private Node previous;
		private T data;

		private Node(T data) {
			this.next = null;
			this.previous = null;
			this.data = data;
		}
	}

	public LinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void append(T data) {
		if (head == null)
			head = new Node(data);
		else if (tail == null) {
			tail = new Node(data);
			head.next = tail;
			tail.previous = head;
		} else {
			Node temp = tail;
			temp.next = new Node(data);
			tail = temp.next;
			tail.previous = temp;
		}
		
		System.out.println("Appended: " + data);
		printAll();
	}

	public void remove(T data) {
		Node current = head;
		Node previous = null;

		while (current != null) {
			if (current.data.equals(data)) {
				if (head.next.equals(null)) {
					head = null;
				} 
				else if (current.equals(head)) {
					head = head.next;
					head.previous = null;
				}
				else if (current.equals(tail)) {
					previous = tail;
					tail.next = null;
				} 
				else {
					previous.next = current.next;
					previous.next.previous = previous;
				}

				System.out.println("Removed: " + current.data);
				printAll();
				return;
			}

			previous = current;
			current = current.next;
		}

		System.out.println(previous.data + " not in the list");
		printAll();
	}

	public void removeDuplicates() {
		HashMap<Integer, T> map = new HashMap<Integer, T>();
		Random random = new Random();
		Node current = head;
		Node previous = null;

		while (current != null) {
			if (map.containsValue(current.data)) {
				if (current.equals(tail)) {
					previous = tail;
					tail.next = null;
				} 
				else {
					previous.next = current.next;
					previous.next.previous = previous;
				}
				
				System.out.println("Removed: " + current.data);
				current = current.next;
				printAll();
			} 
			else {
				map.put(random.nextInt(Integer.MAX_VALUE), current.data);
				previous = current;
				current = current.next;
			}
		}
	}

	public void removeMiddle() {
		Node fast = head.next.next;
		Node slow = head;
		
		int fastCount = 2;
		int slowCount = 0;
		
		while(fast.next.next != null) {
			System.out.println("FAST: " +fast.data + " | COUNT: " + fastCount);
			System.out.println("SLOW: " + slow.data + "| COUNT: " + slowCount);
			fast = fast.next.next;
			slow = slow.next;
			fastCount += 2;
			slowCount += 1;
		}
		
		if(fast.next != null) {
			System.out.println("FAST: " +fast.data + " | COUNT: " + fastCount);
			System.out.println("SLOW: " + slow.data + "| COUNT: " + slowCount);
			fast = fast.next;
			slow = slow.next;
			fastCount += 1;
			slowCount += 1;
		}
		
		System.out.println("FAST: " +fast.data + " | COUNT: " + fastCount);
		System.out.println("SLOW: " + slow.data + "| COUNT: " + slowCount);
		
		remove(slow.data);
	}
	
	public T getKthToLast(int k) {
		Node current = tail;
		int counter = 0;
		
		while(counter < k) {
			current = current.previous;
			counter++;
		}
		
		return current.data;		
	}
	
	public void printAll() {
		Node current = head;
		int i = 0;
		
		System.out.println();
		while (current != null) {
			System.out.print(current.data + " <--> ");
			current = current.next;
			i++;
			
			if(i >= 10 && i % 10 == 0)
				System.out.println();
		}

		System.out.println("\n");
	}
}