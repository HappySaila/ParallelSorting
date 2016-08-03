/**
* Created by wlsgra012 on 2016/08/03.
*/
import java.util.Arrays;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinPool;
public class ParallelMergesort extends RecursiveAction{
    private int[] arr;
    private int start, end;
    private int threshold;

    public ParallelMergesort(int[] arr, int start, int end, int threshold) {
        this.arr = arr;
        this.start = start;
        this.end = end;
        this.threshold = threshold;
    }

    @Override
    protected void compute() {
        if (end - start <= threshold) {
            // sequential sort
            Arrays.sort(arr, start, end);
            return;
        }

        // Sort halves in parallel
        int mid = start + (end-start) / 2;
        invokeAll(
                new ParallelMergesort(arr, start, mid, threshold),
                new ParallelMergesort(arr, mid, end, threshold) );

        // sequential merge
        sequentialMerge(mid);
    }

    public void sequentialMerge(int mid){
        //will Merge this objects left array with this objects right array.
        //the resulting array will be saved in arr.
        int i=0;//left counter
        int j=0;//right counter
        int k=start;//main counter
        int[] left = Arrays.copyOfRange(arr,start,mid);
        int[] right = Arrays.copyOfRange(arr,mid,end);
        while (i<left.length && j<right.length){
            if (left[i]<=right[j]){
                arr[k++]=left[i++];
            }else {
                arr[k++]=right[j++];
            }
        }
        //check if there are any elements left in the array.
        while(i<left.length){
            arr[k++]=left[i++];
        }
        while(j<right.length){
            arr[k++]=right[j++];
        }
    }

}


