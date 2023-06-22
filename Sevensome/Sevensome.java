package Sevensome;

import java.util.*;

import thingy.*;

public class Sevensome<T> {
	private Map<T, List<Set<Item>>> sevensome;
	
	public Sevensome() {
		this.sevensome = new HashMap<T, List<Set<Item>>>();
	}
	
	public List<Set<Item>> get(T type) {
		return this.sevensome.get(type);
	}
	
	public List<Set<Item>> put(T type, List<Set<Item>> list) {
		assert this.sevensome.size() < 7 : "Already 7";
		return this.sevensome.put(type, list);
	}
	
	public Set<T> keySet() {
		return this.sevensome.keySet();
	}
	
	public void clear( ) {
		this.sevensome.clear();
	}
	
	public boolean isEmpty() {
		return this.sevensome.isEmpty();
	}
}