import java.util.concurrent.RecursiveAction;
import java.util.Arrays;

public class QuicksortParallel extends RecursiveAction {
    private int[] arr;
    private int start, end;
    private int sequantialcutoff;

    public QuicksortParallel(int[] arr, int start, int end,int threshhold) {
        this.arr = arr;
        this.start = start;
        this.end = end;
        this.sequantialcutoff = threshhold;

    }


    public void compute() {
        //System.out.print(pindex + " ");
        if (end - start <= sequantialcutoff){
            Arrays.sort(arr, start, end + 1);
            return;
        }
        int pindex = end-1;
        int i = start;

        while (i < pindex){
            if(arr[i] > arr[pindex]){
                int place = arr[pindex];
                arr[pindex] = arr[pindex-1];
                arr[pindex-1] = place;
                place = arr[i];
                arr[i] = arr[pindex];
                arr[pindex] = place;
                pindex--;
            }else{
                i++;
            }
        }

        invokeAll(
                new QuicksortParallel(arr, start, pindex-1,sequantialcutoff),
                new QuicksortParallel(arr, pindex-1, end,sequantialcutoff));
    }

}
