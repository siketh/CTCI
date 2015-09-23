import java.util.ArrayDeque;
import java.util.Queue;

public class Sort {
	public static void mergeSort(int[] numbers) {
		mergeSort(numbers, 0, numbers.length - 1);
	}

	private static void mergeSort(int[] numbers, int low, int high) {
		int middle = (low + high) / 2;

		if (low < high) {
			mergeSort(numbers, low, middle);
			mergeSort(numbers, middle + 1, high);
			merge(numbers, low, middle, high);
		}
	}

	private static void merge(int[] numbers, int low, int middle, int high) {
		int i;

		Queue<Integer> bufferLeft = new ArrayDeque<Integer>();
		Queue<Integer> bufferRight = new ArrayDeque<Integer>();

		for (i = low; i <= middle; i++)
			bufferLeft.add(numbers[i]);
		for (i = middle + 1; i <= high; i++)
			bufferRight.add(numbers[i]);

		i = low;
		while (!(bufferLeft.isEmpty() || bufferRight.isEmpty())) {
			if (bufferLeft.peek() <= bufferRight.peek())
				numbers[i++] = bufferLeft.remove();
			else
				numbers[i++] = bufferRight.remove();
		}

		while (!bufferLeft.isEmpty())
			numbers[i++] = bufferLeft.remove();
		while (!bufferRight.isEmpty())
			numbers[i++] = bufferRight.remove();
	}

}
