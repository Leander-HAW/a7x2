package ItemProcessor;

import java.util.*;

import thingy.*;

public class ItemProcessor implements ItemProcessor_I {
	private Map<Size, Set<Item>> sevensome;

	public ItemProcessor() {
		this.sevensome = new HashMap<Size, Set<Item>>();
	}
	
	
	@Override
	public  Collection<Item> process(Item item) {
	
		Size currentItemSize = item.getSize();
		Set<Item> returnSet = sevensome.get(currentItemSize);

		if (returnSet == null) {
			returnSet = new HashSet<Item>();
			sevensome.put(currentItemSize, returnSet);
		}
		returnSet.add(item);
		 
        Iterator<Size> iterator = sevensome.keySet().iterator();

        // Mit dem Iterator über die Schlüssel iterieren
        while (iterator.hasNext()) {
            Size key = iterator.next();
            
            returnSet = sevensome.get(key);
            if(returnSet.size() == requestedNumberOfThingsOfSameSize) {
            	return sevensome.remove(key);
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
