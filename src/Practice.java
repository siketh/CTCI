import java.util.Hashtable;
import java.util.Random;

public class Practice {

	public void linkedListTest() {
		LinkedList list = new LinkedList();
		Random random = new Random();

		for (int i = 0; i < 10; i++) {
			list.append(random.nextInt(10));
		}

		while (!list.isEmpty()) {
			list.printConnections();
			list.remove(random.nextInt(10));
		}
	}

	public static void hashTableTest() {
		Hashtable<String, Integer> table = new Hashtable<String, Integer>();

		table.put("Dog", 0);
		table.put("Cat", 1);
		table.put("Horse", 2);
		table.put("Lion", 3);
		table.put("Elephant", 4);

		System.out.println(table.containsKey("Dog"));

		table.remove("Dog");

		System.out.println(table.containsKey("Dog"));
	}

	public static void permutationTesT() {
		Permutation permutation = new Permutation("trevor");

		permutation.print();
		System.out.println(permutation.isPermutation("Trevor"));
		System.out.println(permutation.isPermutation("Rovert"));
		System.out.println(permutation.isPermutation("rovert"));
		System.out.println(permutation.isPermutation("vertor"));
		System.out.println(permutation.isPermutation("trevor"));
	}

	public static char[] urlify(char[] string, int length) {
		char[] url = new char[string.length];
		int copiedIndex = 0;

		for (int i = 0; i < length; i++) {
			if (string[i] == ' ') {
				url[copiedIndex] = '%';
				url[copiedIndex + 1] = '2';
				url[copiedIndex + 2] = '0';

				copiedIndex += 3;
			}

			else {
				url[copiedIndex] = string[i];
				copiedIndex++;
			}
		}

		return url;
	}

	public static void main(String[] args) {
		String string = "Trevor Wyatt Roman      ";
		String url = new String(urlify(string.toCharArray(), 18));
		System.out.println("URLIFY: 'Trevor Wyatt Roman' = " + url.toString());
	}
}
