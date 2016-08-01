//Grant Wilson -WLSGRA012
//Parallel Programming Testing

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class TestQuicksortParallel{

    //region Test cases
    @Test
    public void TestSwap(){
        System.out.println("Testing swap");
        int [] arr = {4,6,8,3,7,5};
        QuicksortParallel q = new QuicksortParallel(arr);
        q.swap(arr,0,1);
        assertTrue(arr[0]==6 && arr[1]==4);
        q.swap(arr,1,2);
        assertTrue(arr[1]==8 && arr[2]==4);
    }
    @Test
    public void TestPartition(){
        System.out.println("Testing partition");
        int [] expected = {4,3,5,6,7,8};
        int [] arr = {4,6,8,3,7,5};
        QuicksortParallel q = new QuicksortParallel(arr);
        int pIndex = q.Partition(q.getArr(),0,q.getArr().length-1);
        assertTrue(pIndex == 2);
        for (int i = 0; i < q.getArr().length; i++) {
            if(q.getArr()[i]!=expected[i]){
                assertTrue(false);
            }
        }
        assertTrue(true);
    }
    @Test
    public void TestQuicksortSeq(){
        System.out.println("Testing quicksortSeq");
        int [] expected = {-12,-7,3,4,5,6,7,8,10,16};
        int [] arr = {4,6,8,16,3,7,5,10,-12,-7,};
        QuicksortParallel q = new QuicksortParallel(arr);
        q.QuicksortSeq(0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            if(q.getArr()[i]!=expected[i]){
                assertTrue(false);
            }
        }
        assertTrue(true);
    }
    @Test
    public void TestQuicksortPar(){
        System.out.println("Testing quicksortparallel");
        int [] expected = {-12,-7,3,4,5,6,7,8,10,16};
        int [] arr = {4,6,8,16,3,7,5,10,-12,-7,};
        QuicksortParallel q = new QuicksortParallel(arr, 0, 0, arr.length-1);
        q.QuicksortPar();
        for (int i = 0; i < arr.length; i++) {
            if(q.getArr()[i]!=expected[i]){
//                System.out.println("array is:"+arr[i]+" But expected is:"+expected[i]);
                assertTrue(false);
            }
        }
        assertTrue(true);
    }
    //    @Test
    public void SpeedUp(){
        //test if the parallel code is faster than sequentially code
        //AssertTrue if parallel method is faster than sequential method.
        System.out.println("Testing speedUp");
    }
    //endregion
}