//Grant Wilson
//wlsgra012
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Random;
import java.text.DecimalFormat;
public class DriverSort{
//    region main
    public static void main(String[] ar){
//        region debug args
        String[] args = new String[5];
        args[0] = "merge";
        args[1] = "100";
        args[2] = "1000";
        args[3] = "100";
        args[4] = "results.txt";
//        endregion
        String sortType = args[0];
        int arrayMin = Integer.parseInt(args[1]);
        int arrayMax = Integer.parseInt(args[2]);
        int arrayInc = Integer.parseInt(args[3]);
        String outfile = args[4];
        Random rand = new Random();
        long start;
        long end;
        long sequentialTime;
        long parallelTime;
        float speedUp;
        String out="";
        Record record = new Record();
        //used to round speed up values in speed up
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.CEILING);

        if (sortType.equals("merge")){
            System.out.println("merge");
            //for loop for all array values specified in args
            for (int i = arrayMin; i < arrayMax+1; i+=arrayInc) {
                //setUp for first test
                int[] arr = new int[i];
                for (int j = 0; j < i; j++) {
                    arr[j] = rand.nextInt(i);// generates a random number between 0 and arrSize and assigns it to the array
                }
                //create threads and run tests with thread sizes 2,4,8,16,32,64
                int threads = 2;
                record = new Record();//used to record all values for this test
                while(threads<17){
                    //create number of threads by making sequentialCutoff = arraySize/threads
                    int sequentialCutOff = arr.length/threads;
                    //create merge and set the main arr of the merge class to a copy of the above array arr
                    ParallelMergesort merge = new ParallelMergesort(arr.clone(),0,arr.clone().length-1,sequentialCutOff);//create merge object to sort the arrays

                    //run sequential sort and time it
                    System.gc();
                    start = System.currentTimeMillis();
                    Arrays.sort(arr);
                    end =  System.currentTimeMillis();
                    sequentialTime = end-start;

                    //run parallel sort and time it
                    System.gc();
                    start = System.currentTimeMillis();
                    merge.compute();
                    end =  System.currentTimeMillis();
                    parallelTime = end-start;

                    //check speed up of the test
                    speedUp=(float)sequentialTime/parallelTime;
                    if (speedUp>record.getSpeedUp()){
                        //save the record
                        record.saveRun(i,parallelTime,threads,speedUp);
                    }
                    System.out.println("Speed up: "+speedUp+" threads: "+threads);

                    //increment threads to rerun test to find optimal threads
                    threads*=2;
                }
                //save the test to a file
                out = out +"\n"+record.getResults();
            }
            record.write(outfile,out);
        }
        else if (sortType.equals("quick")){
            System.out.println("quick");
            //for loop for all array values specified in args
            for (int i = arrayMin; i < arrayMax+1; i+=arrayInc) {
                //setUp for first test
                int[] arr = new int[i];
                for (int j = 0; j < i; j++) {
                    arr[j] = rand.nextInt(i);// generates a random number between 0 and arrSize and assigns it to the array
                }
                //create threads and run tests with thread sizes 2,4,8,16,32,64
                int threads = 2;
                record = new Record();//used to record all values for this test
                while(threads<17){
                    //create number of threads by making sequentialCutoff = arraySize/threads
                    int sequentialCutOff = arr.length/threads;
                    //create merge and set the main arr of the merge class to a copy of the above array arr
                    QuicksortParallel quick = new QuicksortParallel(arr.clone(),0,arr.clone().length-1,sequentialCutOff);

                    //run sequential sort and time it
                    System.gc();
                    start = System.currentTimeMillis();
                    Arrays.sort(arr);
                    end =  System.currentTimeMillis();
                    sequentialTime = end-start;

                    //run parallel sort and time it
                    System.gc();
                    start = System.currentTimeMillis();
                    quick.compute();
                    end =  System.currentTimeMillis();
                    parallelTime = end-start;

                    //check speed up of the test
                    speedUp=(float)sequentialTime/parallelTime;
                    if (speedUp>record.getSpeedUp()){
                        //save the record
                        record.saveRun(i,parallelTime,threads,speedUp);
                    }
                    System.out.println("Speed up: "+speedUp+" threads: "+threads);

                    //increment threads to rerun test to find optimal threads
                    threads*=2;
                }
                //save the test to a file
                out = out +"\n"+record.getResults();
            }
            record.write(outfile, out);
        }
    }
//    endregion

    //region testing
//    public static void main(String[] args) {
//        TestMerge();
//    }
//
//    public static void TestMerge(){
//        int[] arr = {1,3,4,7,2,5,6,8};
//        int[] expected = {1,2,3,4,5,6,7,8};
//        ParallelMergesort merge = new ParallelMergesort(arr, 0, arr.length, 2);
//        merge.sequentialMerge(arr.length/2);
//        for (int i = 0; i < expected.length; i++) {
//            if (arr[i]!=expected[i]){
//                //wrong output and the method fails
//                System.out.println("wrong");
//            }
//        }
//        //if code hits here the arrays are the same
////        assertTrue(true);
//    }
    //endregion
}