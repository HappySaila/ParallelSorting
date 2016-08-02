//Grant Wilson
//wlsgra012
import java.math.RoundingMode;
import java.util.Random;
import java.text.DecimalFormat;
public class DriverSort{
    public static void main(String[] arg){
        //region debug args
        String[] args = new String[5];
        args[0] = "merge";
        args[1] = "100";
        args[2] = "100";
        args[3] = "100";
        args[4] = "results";
        //endregion
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
        //used to round speed up values in speed up
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.CEILING);

        if (sortType.equals("merge")){
            System.out.println("merge");
            //for loop for all array values specified in args
            for (int i = arrayMin; i < arrayMax+1; i+=arrayInc) {
                //setUp for first test
                Record record = new Record();//used to record all values for this test
                int[] arr = new int[i];
                for (int j = 0; j < i; j++) {
                    arr[j] = rand.nextInt(i);// generates a random number between 0 and arrSize and assigns it to the array
                }
                //create threads and run tests with thread sizes 2,4,8,16,32,64
                int threads = 2;
                while(threads<3){
                    //create number of threads by making sequentialCutoff = arraySize/threads
                    int sequentialCutOff = arr.length/threads;
                    //create merge and set the main arr of the merge class to a copy of the above array arr
                    MergesortParallel merge = new MergesortParallel(arr.clone(),sequentialCutOff);//create merge object to sort the arrays

                    //run sequential sort and time it
                    System.gc();
                    start = System.currentTimeMillis();
                    merge.MergesortSeq(merge.getArr());
                    end =  System.currentTimeMillis();
                    sequentialTime = end-start;

                    //reset the main array
                    merge.setArr(arr.clone());

                    //run parallel sort and time it
                    System.gc();
                    start = System.currentTimeMillis();
                    merge.MergesortPar();
                    end =  System.currentTimeMillis();
                    parallelTime = end-start;

                    for (int j = 0; j < merge.getArr().length; j++) {
                        System.out.println(merge.getArr()[j]);
                    }
                    //check speed up of the test
                    speedUp=(float)sequentialTime/parallelTime;
                    System.out.println(sequentialTime+" "+parallelTime);
                    System.out.println(df.format(speedUp)+" threads: "+threads);

                    //increment threads to rerun test to find optimal threads
                    threads*=2;
                }

            }
        }
        else if (sortType.equals("quick")){
            System.out.println("quick");
        }
    }
}