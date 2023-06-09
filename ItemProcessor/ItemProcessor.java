package ItemProcessor;



import java.util.*;

import thingy.Item;

public class ItemProcessor implements ItemProcessor_I {
	private Map<Item, List<Item>> fiveDifferent;
	private Set<Set<Item>> sevensome;

	public ItemProcessor() {
		this.fiveDifferent = new HashMap<Item, List<Item>>();
		this.sevensome = new HashSet<Set<Item>>();
	}
	
	
	@Override
	public Collection<Item> process(Item item) {
		
		Set<Item> sevensome = new HashSet<Item>();
		return null;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
