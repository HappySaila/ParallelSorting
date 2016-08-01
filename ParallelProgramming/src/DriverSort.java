public class DriverSort{
    public static void main(String[] args){
        System.out.println("drive");
        TestQuicksortPar();
    }
    public static void TestQuicksortPar(){
        System.out.println("Testing quicksortparallel");
        int [] expected = {-12,-7,3,4,5,6,7,8,10,16};
        int [] arr = {4,6,8,16,3,7,5,10,-12,-7,};
        QuicksortParallel q = new QuicksortParallel(arr, 0, 0, arr.length-1);
        q.QuicksortPar();
        for (int i = 0; i < arr.length; i++) {
            if(true){
                System.out.println(arr[i]+" "+expected[i]);
//                assertTrue(false);
            }
        }
//        assertTrue(true);
    }
}