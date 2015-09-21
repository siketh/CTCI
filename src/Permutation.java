import java.util.Hashtable;
import java.util.Random;
import java.util.Set;

public class Permutation {
	private Hashtable<String, Integer> permutations;
	private Random random;
	private String string;

	public Permutation(String string) {
		this.permutations = new Hashtable<String, Integer>();
		this.random = new Random();
		this.string = string;

		permutation(this.string);
	}

	private void permutation(String string) {
		permutation(string, "");
	}

	private void permutation(String string, String prefix) {
		System.out.println("STRING: " + string + ", PREFIX: " + prefix);

		if (string.length() == 0) {
			System.out.println("PERMUTATION: " + prefix);
			permutations.putIfAbsent(prefix, random.nextInt());
		}

		else {
			for (int i = 0; i < string.length(); i++) {
				String remainder = string.substring(0, i)
						+ string.substring(i + 1);

				permutation(remainder, prefix + string.charAt(i));
			}
		}
	}
	
	public boolean isPermutation(String string) {
		if(permutations.containsKey(string))
			return true;
		else
			return false;
	}

	public Set<String> permutations() {
		return permutations.keySet();
	}
	
	public void print() {
		System.out.println(permutations());
	}
}
