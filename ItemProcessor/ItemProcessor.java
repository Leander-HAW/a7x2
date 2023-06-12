package ItemProcessor;

import java.util.*;

import thingy.*;

public class ItemProcessor implements ItemProcessor_I {
	private Map<Size, List<Set<Item>>> sevensome;

	public ItemProcessor() {
		this.sevensome = new HashMap<Size, List<Set<Item>>>();
	}

	@Override
	public Collection<Item> process(Item item) {

		Size currentItemSize = item.getSize();
		List<Set<Item>> listofSets = sevensome.get(currentItemSize);
		Set<Item> returnSet = null;
		boolean itemAdded = false;
		if (listofSets == null) {
			listofSets = new ArrayList<Set<Item>>();
			returnSet = new HashSet<Item>();
			returnSet.add(item);
			listofSets.add(returnSet);
			sevensome.put(currentItemSize, listofSets);
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
					sevensome.put(currentItemSize, listofSets);
					itemAdded = true;
				}
			}
		}
		Iterator<Size> iteratorKey = sevensome.keySet().iterator();
		while (iteratorKey.hasNext()) {
			Size key = iteratorKey.next();
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
