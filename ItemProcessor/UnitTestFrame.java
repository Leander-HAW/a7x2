package ItemProcessor;
import static org.junit.jupiter.api.Assertions.*;
import static ItemProcessor.ItemProcessor_I.*;
//
import java.util.*;

import org.junit.jupiter.api.Test;
import thingy.*;


public class UnitTestFrame {

    @Test
    public void testIsProcessWorkingLikeExpectet() {
    	
        final ItemProcessor_I ItemProcessor = new ItemProcessor();
        Collection<Item> processedResult=new HashSet<Item>();;
        final Item[] ia = {
                new Item( Color.BLACK, Size.LARGE,  Weight.HEAVY,  1L ),
                new Item( Color.FLAX, Size.LARGE,  Weight.HEAVY,  2L ),
                new Item( Color.GOLD, Size.LARGE,  Weight.HEAVY,  3L ),
                new Item( Color.AERO, Size.LARGE,  Weight.HEAVY,  4L ),
                new Item( Color.GRAY, Size.LARGE,  Weight.HEAVY,  5L ),
                new Item( Color.PURPLE, Size.LARGE,  Weight.HEAVY,  5L ),
                new Item( Color.LEMON, Size.LARGE,  Weight.HEAVY,  5L ),
            };
       for (int i = 0; i <= ia.length-1; i++) {
        	
    	   processedResult = ItemProcessor.process( ia[i] );
        }
    
       for (int i = 0; i < ia.length; i++) {
    	   
    	   assertTrue(processedResult.contains(ia[i]));
       }

       
    }//method()
    
    /*
    /**
     * Erzeuge alle Kombination von Color x Size x Weight
     * Jedes 5.Mal gibt es 5 unterschiedliche Items
    //*##/
    @Test
    public void testFiveDifferentItemsWithoutDuplicates(){
        final Collector_I collector = new Collector();
        
        // prepare for test loop
        Collection<Item> expectedResult = new ArrayList<Item>();
        long value = 1;
        //
        // test loop
        for( final Color color : Color.values() ){
            for( final Size size : Size.values() ){
                for( final Weight weight : Weight.values() ) {
                    final Item item = new Item( color, size, weight, value );
                    expectedResult.add( item );
                    final Collection<Item> computedResult = collector.process( item );
                    if( value%requestedNumberOfDifferentItems == 0 ){
                        assertTrue(
                            isEqualCollection( expectedResult, computedResult ),
                            String.format( "expected: <%s> but was: <%s>", expectedResult, computedResult )
                        );
                        expectedResult.clear();
                    }else{
                        assertNull( computedResult );
                    }//if
                    value++;
                }//for
            }//for
        }//for
        
    }//method()
    //
    public static boolean isEqualCollection( final Collection<?> coll1,  final Collection<?> coll2 ){
        if( coll1.size() != coll2.size() )  return false;
        for( final Object obj : coll1 ) {
            if( ! coll2.remove( obj ))  return false;
        }//for
        return coll2.isEmpty();
    }//method()
    
    
    
    // Vorschlaege fuer weitere Tests
    // ==============================
    // o) Funktioniert reset()?
    // o) Funktioniert Implementierung, wenn sich Items nur in einer Eigenschaft unterscheiden?
    // o) Funktioniert Implementierung, wenn Doppelte auftreten? -> Achtung! (Nicht nur) wegen Aufgabenstellung  DOPPELT ::="Gleich aber NICHT dasselbe (Objekt)"
    // o) Ist Collection, die als Ergebnis von process() abgeliefert wird, geeignet?
    // ...
    
}//class
*/
}
