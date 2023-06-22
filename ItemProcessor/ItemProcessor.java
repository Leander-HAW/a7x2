package ItemProcessor;

import java.util.*;

import thingy.*;
import Sevensome.*;

public class ItemProcessor implements ItemProcessor_I {
	private Sevensome<Color> sevensome;
	
	public ItemProcessor() {
		sevensome = new Sevensome<Color>();
	}
	
	@Override
	public Collection<Item> process(Item item) {
		Color currentItemColor = item.getColor();
		List<Set<Item>> listofSets = sevensome.get(currentItemColor);
		Set<Item> returnSet = null;
		boolean itemAdded = false;
		if (listofSets == null) {
			listofSets = new ArrayList<Set<Item>>();
			returnSet = new HashSet<Item>();
			returnSet.add(item);
			listofSets.add(returnSet);
			sevensome.put(currentItemColor, listofSets);
		} else {
			Iterator<Set<Item>> iterator = listofSets.iterator();
			returnSet = iterator.next();
			while (!itemAdded) {
				if (!returnSet.contains(item)) {
					returnSet.add(item);
					itemAdded = true;
				} else if (iterator.hasNext()) {
					returnSet = iterator.next();
				} else {
					returnSet = new HashSet<Item>();
					returnSet.add(item);
					listofSets.add(returnSet);
					sevensome.put(currentItemColor, listofSets);
					itemAdded = true;
				}
			}
		}
		Iterator<Color> iteratorKey = sevensome.keySet().iterator();
		while (iteratorKey.hasNext()) {
			Color key = iteratorKey.next();
			listofSets = sevensome.get(key);
			for (int i = 0; i < listofSets.size(); i++) {
				returnSet = listofSets.get(i);
				if (returnSet.size() == requestedNumberOfThingsOfSameSize) {
					return listofSets.remove(i);
				}
			}
		}
		return null;
	}
	
	@Override
	public void reset() {
		this.sevensome.clear();
	}

	@Override
	public boolean isEmpty() {
		return this.sevensome.isEmpty();
	}
}
