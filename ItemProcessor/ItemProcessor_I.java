package ItemProcessor;

import thingy.*;
import java.util.Collection;

public interface ItemProcessor_I {

    final int requestedNumberOfThingsOfSameSize = 7;
    
    Collection<Item> process( Item item );
    
    
    void reset();

    boolean isEmpty();



}
