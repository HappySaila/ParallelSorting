public class DriverSort{
    public static void main(String[] args){
        testMergeSeq();
    }
    public static void testMergeSeq(){
        //test if the mergesort works sequentially
        int[] sorted = {1,2,3,4};
        int[] unsorted = {4,3,2,1};
        MergesortParallel main = new MergesortParallel();
        main.setArr(unsorted);
        main.MergesortSeq(main.getArr());
        for (int i = 0; i < sorted.length; i++) {
            System.out.println("arr="+main.getArr()[i]);
            System.out.println("expected="+sorted[i]);
            System.out.println("\n");
        }
//        assertTrue(true);
    }
}