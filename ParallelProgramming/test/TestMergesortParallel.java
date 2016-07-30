//Grant Wilson -WLSGRA012
//Parallel Programming Testing

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class TestMergesortParallel{
    @Test
    public void testMergeEven(){
        //test if two arrays Merge successfully into a resulting array with even numbered elements
        int[] sorted = {0,1,2,3,4,5,6,7,8,9};
        int[] right = {2,4,5,8,9};
        int[] left = {0,1,3,6,7};
        MergesortParallel main = new MergesortParallel(new int[10]);
        main.setBranches(left, right);
        main.Merge();
        for (int i = 0; i < main.getArr().length; i++) {
            if(main.getArr()[i]!=sorted[i]){
                assertTrue(false);
            }
        }
        assertTrue(true);
    }
    @Test
    public void testMergeOdd(){
        //test if two arrays Merge successfully into a resulting array with odd numbered elements
        int[] sorted = {0,1,2,3,4,5,6,7,8};
        int[] right = {2,4,5,8};
        int[] left = {0,1,3,6,7};
        MergesortParallel main = new MergesortParallel(new int[9]);
        main.setBranches(left, right);
        main.Merge();
        for (int i = 0; i < main.getArr().length; i++) {
            if(main.getArr()[i]!=sorted[i]){
                assertTrue(false);
            }
        }
        assertTrue(true);
    }
//    @Test
    public void testMergeSeq(){
        //test if the mergesort works sequentially
        int[] sorted = {1,2,3,4,5,6,7,8,9};
        int[] unsorted = {8,2,4,6,5,7,1,3,9};
        MergesortParallel main = new MergesortParallel();
        main.setArr(unsorted);
        main.MergesortSeq(main.getArr());
        for (int i = 0; i < sorted.length; i++) {
            if (main.getArr()[i]!=sorted[i]){
                assertTrue(false);
            }
        }
        assertTrue(true);
    }
//    @Test
    public void testMergeParallel(){
        //test if the mergesort works in parallel
        int[] sorted = {1,2,3,4,5,6,7,8,9};
        int[] unsorted = {8,2,4,6,5,7,1,3,9};
        MergesortParallel main = new MergesortParallel();
        main.setArr(unsorted);
        main.MergesortParallel();
        for (int i = 0; i < sorted.length; i++) {
            if (main.getArr()[i]!=sorted[i]){
                assertTrue(false);
            }
        }
        assertTrue(true);
    }
//    @Test
    public void testSpeed(){
        //test sequencial time versus parallel time.
        //AssertTrue if parallel method is faster than sequential method.
    }
}