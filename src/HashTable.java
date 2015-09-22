import java.util.ArrayList;
import java.util.Random;

public class HashTable<T> {
	ArrayList<T> table;
	
	public HashTable() {
		this.table = new ArrayList<T>();
	}
	
	public void put(T value) {
		HashEntry newEntry = new HashEntry(value);
		table.add(newEntry.getKey(), newEntry.getValue());
	}
	
	private class HashEntry {
		private int key;
		private T value;
		private Random random = new Random();
		
		private HashEntry(T value) {
			this.key = hash();
			this.value = value;
		}
		
		private int hash() {
			return random.nextInt(table.size()) % table.size();
		}
		
		private int getKey() {
			return this.key;
		}
		
		private T getValue() {
			return this.value;
		}
	}
}
