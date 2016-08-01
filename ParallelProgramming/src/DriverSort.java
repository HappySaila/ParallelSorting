//Grant Wilson
//wlsgra012
import java.util.Random;
public class DriverSort{
    public static void main(String[] args){
        //region variables for test
        String sortType = args[0];
        int arrayMin = Integer.parseInt(args[1]);
        int arrayMax = Integer.parseInt(args[2]);
        int arrayInc = Integer.parseInt(args[3]);
        String outfile = args[4]+".txt";
        Random rand = new Random();
        long startTime;
        long endTime;
        long timeParallel;
        long timeSequential;
        int threads = 2;
        float speedUp;
        //endregion


        if (sortType.equals("merge")){
            //compare mergesort
            System.out.println("comparing mergeSort...");
            for (int i = arrayMin; i < arrayMax; i+=arrayInc) {
                int [] arr = new int[i];
                Record record = new Record();
                for (int j = 0; j < arr.length; j++) {
                    arr[j] = rand.nextInt(i);
                }
                while (threads< 65){
                    //will sort the array with threads of sizes 2,4,8,16,32,64
                    //will only write to output with best speed up time
                    int[] arrCopy = arr.clone();//keep the array unsorted to benchmark sequential search

                    MergesortParallel merge = new MergesortParallel(arr, threads);//merge object array is set to arr
                    System.gc();

                    //running test now
                    startTime = System.currentTimeMillis();
                    merge.MergesortPar();//sort the array here
                    endTime = System.currentTimeMillis();
                    timeParallel = endTime - startTime;

                    startTime = System.currentTimeMillis();
                    merge.MergesortSeq(merge.getArr());//sort the array here
                    endTime = System.currentTimeMillis();
                    timeSequential = endTime - startTime;

                    speedUp = timeSequential/timeParallel;
                    if (speedUp>record.getSpeedUp()){
                        record.saveRun(i,timeParallel,threads,speedUp);
                    }
                    threads*=2;
                }
                //reset threads and write results for this array size
                threads=2;
                record.addRecords(outfile);
            }
        }



        else if(sortType.equals("quick")){
            //compare quicksort
            System.out.println("comparing quickSort...");
        }
    }
}