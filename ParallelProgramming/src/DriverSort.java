public class DriverSort{
    public static void main(String[] args){
        System.out.println("drive");
        testMergeParallel();
    }
    public static void testMergeParallel(){
        //test if the mergesort works in parallel
        int[] sorted = {1,2,3,4,5,6,7,8,9};
        int[] unsorted = {8,2,4,6,5,7,1,3,9};
        MergesortParallel main = new MergesortParallel();
        main.setArr(unsorted);
        main.MergesortPar();
        for (int i = 0; i < sorted.length; i++) {
            System.out.println(main.getArr()[i]);
        }
    }
}