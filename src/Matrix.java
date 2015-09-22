import java.util.Random;

public class Matrix {
	private int[][] matrix;
	private int length;
	private int width;
	private int size;

	// i corresponds to columm index
	// j corresponds to row index

	public Matrix(int length, int width) {
		this.length = length;
		this.width = width;
		this.size = length * width;
		this.matrix = new int[width][length];

		initialize();
	}

	private void initialize() {
		for (int i = 0; i < width; i++)
			for (int j = 0; j < length; j++) {
				this.matrix[i][j] = i;
			}
	}

	public void randomize(int max) {
		Random random = new Random();

		for (int i = 0; i < width; i++)
			for (int j = 0; j < length; j++) {
				this.matrix[i][j] = random.nextInt(max);
			}
	}
	
	public Matrix rotateMatrix() {
		Matrix rotated = new Matrix(length, width);

		for (int j = 0; j < length; j++) {
			for (int i = 0; i < width; i++) {
				rotated.matrix[(width - 1) - j][i] = matrix[i][j];
			}
		}

		return rotated;
	}

	public void printMatrix() {
		System.out.println();

		for (int j = 0; j < length; j++) {
			for (int i = 0; i < width; i++) {
				System.out.printf("%2d ", this.matrix[i][j]);
			}
			System.out.println();
		}
	}
}
