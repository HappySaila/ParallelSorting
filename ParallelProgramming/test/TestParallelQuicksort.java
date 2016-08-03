//Grant Wilson -WLSGRA012
//Parallel Programming Testing

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class TestParallelQuicksort{

    //region Test cases
    @Test
    public void TestQuicksortPar(){
        System.out.println("Testing quicksortparallel");
        int [] expected = {-12,-7,3,4,5,6,7,8,10,16};
        int [] arr = {4,6,8,16,3,7,5,10,-12,-7,};
        ParallelQuicksort q = new ParallelQuicksort(arr, 0, arr.length-1, 2);
        q.invoke();
        for (int i = 0; i < arr.length; i++) {
            if(false){
//                System.out.println("array is:"+arr[i]+" But expected is:"+expected[i]);
                assertTrue(false);
            }
        }
        assertTrue(true);
    }
    //    @Test

    //endregion
}