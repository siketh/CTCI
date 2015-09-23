import java.util.ArrayDeque;
import java.util.Queue;

public class Sort {

	public static void mergeSort(int[] numbers) {
		mergeSort(numbers, 0, numbers.length - 1);
	}

	public static void mergeSort(int[] numbers, int low, int high) {
		// get the midpoint index
		int middle = (low + high) / 2;

		// if low hasn't crossed high, divide the array in half and sort
		// sub-arrays then merge the sorted sub-arrays back together
		if (low < high) {
			mergeSort(numbers, low, middle);
			mergeSort(numbers, middle + 1, high);
			merge(numbers, low, middle, high);
		}
	}

	public static void merge(int[] numbers, int low, int middle, int high) {
		// reusable iterator for navigating the array
		int i;

		Queue<Integer> leftBuffer = new ArrayDeque<Integer>();
		Queue<Integer> rightBuffer = new ArrayDeque<Integer>();

		// store the left sub-array in a queue
		// store the right sub-array in a queue
		// we want to access the elements in order so a queue is most applicable
		for (i = low; i <= middle; i++)
			leftBuffer.add(numbers[i]);
		for (i = middle + 1; i <= high; i++)
			rightBuffer.add(numbers[i]);

		// lowest index we want to access is whatever the start of the current
		// sub-array is
		i = low;

		// while both buffers are not empty, peek at the next element in queue
		// for each buffer whichever one is lower should be dequeued as the next
		// item in the sorted sub-array
		while (!(leftBuffer.isEmpty() || rightBuffer.isEmpty())) {
			if (leftBuffer.peek() <= rightBuffer.peek())
				numbers[i++] = leftBuffer.remove();
			else
				numbers[i++] = rightBuffer.remove();
		}

		// if any elements remain in the buffers dequeue them into the next item
		// of the sub-array
		while (!leftBuffer.isEmpty())
			numbers[i++] = leftBuffer.remove();
		while (!rightBuffer.isEmpty())
			numbers[i++] = rightBuffer.remove();
	}

}