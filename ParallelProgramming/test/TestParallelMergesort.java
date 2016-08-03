/**
 * Created by wlsgra012 on 2016/08/03.
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class TestParallelMergesort {
    @Test
    public void TestMerge(){
        int[] arr = {1,3,4,7,2,5,6,8};
        int[] expected = {1,2,3,4,5,6,7,8};
        ParallelMergesort merge = new ParallelMergesort(arr, 0, arr.length, 2);
        merge.sequentialMerge(arr.length/2);
        for (int i = 0; i < expected.length; i++) {
            if (arr[i]!=expected[i]){
                //wrong output and the method fails
                assertTrue(false);
            }
        }
        //if code hits here the arrays are the same
        assertTrue(true);
    }
}
