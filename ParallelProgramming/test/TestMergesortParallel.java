public class TestMergesortParallel{
    @Test
    pubilc void testMergeEven(){
        //test if two arrays merge successfully into a resulting array with even numbered elements
        int[] sorted = {1,2,3,4,5,6,7,8,9,10};
        int[] right = {4,5,9,8,2};
        int[] left = {7,10,3,1,6};
        MergesortParallel main = new MergesortParallel();
        p.setLeft(left);
        p.setRight(right);
        p.merge();
        for (int i = 0; i < p.arr.legth; i++) {
            if(arr[i]!=sorted[i]){
                assertTrue(false);
            }
        }
        assertTrue(true);
    }
    @Test
    pubilc void testMergeOdd(){
        //test if two arrays merge successfully into a resulting array with odd numbered elements
        int[] sorted = {1,2,3,4,5,6,7,8,9};
        int[] right = {4,5,8,2};
        int[] left = {7,10,3,1,6};
        MergesortParallel main = new MergesortParallel();
        p.setLeft(left);
        p.setRight(right);
        p.merge();
        for (int i = 0; i < p.arr.legth; i++) {
            if(arr[i]!=sorted[i]){
                assertTrue(false);
            }
        }
        assertTrue(true);
    }
    @Test
    public void testMergeSeq(){
        //test if the mergesort works sequentially
        int[] sorted = {1,2,3,4,5,6,7,8,9};
        int[] unsorted = {8,2,4,6,5,7,1,3,9};
        MergesortParallel main = new MergesortParallel();
        main.setArr(unsorted);
        main.MergesortSeq();
        for (int i = 0; i < sorted.length; i++) {
            if (main.getArr[i]!=sorted[i]){
                assertTrue(false);
            }
        }
        assertTrue(true);
    }
    @Test
    public void testMergeParallel(){
        //test if the mergesort works in parallel
        int[] sorted = {1,2,3,4,5,6,7,8,9};
        int[] unsorted = {8,2,4,6,5,7,1,3,9};
        MergesortParallel main = new MergesortParallel();
        main.setArr(unsorted);
        main.MergesortParallel();
        for (int i = 0; i < sorted.length; i++) {
            if (main.getArr[i]!=sorted[i]){
                assertTrue(false);
            }
        }
        assertTrue(true);
    }
    @Test
    public void testSpeed(){
        //test sequencial time versus parallel time.
        //AssertTrue if parallel method is faster than sequential method.
    }
}