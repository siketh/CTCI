import java.util.Hashtable;
import java.util.Random;

public class Test {
	public static Random random = new Random();
	
	public static void linkedListTest() {
		LinkedList<Integer> list = new LinkedList<Integer>();

		for (int i = 0; i < 11; i++) {
			list.append((Integer)random.nextInt(10));
		}
		
		list.removeMiddle();
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

	public static void urlifyTest() {
		String string = "Trevor Wyatt Roman      ";
		String url = new String(urlify(string.toCharArray(), 18));
		System.out.println("URLIFY: 'Trevor Wyatt Roman' = " + url.toString());
	}
	
	public static void matrixTest() {
		Matrix m = new Matrix(20, 20);
		m.printMatrix();
		
		m.randomize(100);
		m.printMatrix();
		
		Matrix r = m.rotateMatrix();
		r.printMatrix();
		
		Matrix r2 = r.rotateMatrix();
		r2.printMatrix();
		
		Matrix r3 = r2.rotateMatrix();
		r3.printMatrix();
		
		Matrix r4 = r3.rotateMatrix();
		r4.printMatrix();
	}
	
	public static void sortTest() {
		int[] numbers = new int[10];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (Integer)random.nextInt(numbers.length);
		}
		
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + ", ");
		}
		
		System.out.println();
		
		Sort.quickSort(numbers);
		
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + ", ");
		}
	}
	
	public static void main(String[] args) {
		sortTest();
	}
}
