//Grant Wilson
//Mergesort Parallel
public class MergesortParallel extends java.lang.Thread{
    //region initialisation
    private int[] left;
    private int[] right;
    private int[] arr;



    private int sequencialCutoff=2;
    //endregion

    //region constructors
    public MergesortParallel(int[] main){
        this.arr = main;
    }
    public MergesortParallel(int[] main, int threads){
        this.arr = main;
        this.sequencialCutoff =main.length/threads;
    }
    public MergesortParallel(){
    }
    //endregion

    //region GetSet
    public int[] getLeft() {
        return left;
    }

    public int[] getRight() {
        return right;
    }
    public int[] getArr(){
        return this.arr;
    }
    public void setArr(int[] Arr){
        this.arr = Arr;
    }

    //endregion

    //region methods
    public static void Merge(int arr[], int[] left, int[] right){
        //will Merge this objects left array with this objects right array.
        //the resulting array will be saved in arr.
        int i=0;
        int j=0;
        int k=0;
        while (i<left.length && j<right.length){
            if (left[i]<=right[j]){
                arr[k]=left[i];
                i++; k++;
            }else {
                arr[k] = right[j];
                j++;
                k++;
            }
        }
        //check if there are any elements left in the array.
        while(i<left.length){
            arr[k]=left[i];
            i++; k++;
        }
        while(j<right.length){
            arr[k]=right[j];
            j++; k++;
        }
    }

    public void MergesortSeq(int[] arr){
        int n=arr.length;
        if (n<2){
            //one element left in the array
            return;
        }
        int mid = n/2;
        int[] left = new int[n/2];
        int[] right = new int[n-n/2]; //for odd numbered arrays as well
        //splitting main array into right and left arrays
        for (int l = 0; l < mid; l++) {
            left[l]=arr[l];
        }
        for (int l = mid; l < n; l++) {
            right[l-mid]=arr[l];
        }
        MergesortSeq(left);
        MergesortSeq(right);
        Merge(arr,left,right);
    }
    public void MergesortPar(){
        int n=arr.length;
        if (n<sequencialCutoff){
            //sequencialCutoff must me strictly >1
            MergesortSeq(arr);
            return;
        }
        int mid = n/2;
        int[] left = new int[n/2];
        int[] right = new int[n-n/2]; //for odd numbered arrays as well
        //splitting main array into right and left arrays
        for (int l = 0; l < mid; l++) {
            left[l]=arr[l];
        }
        for (int l = mid; l < n; l++) {
            right[l-mid]=arr[l];
        }
        //create 2 mergesortparallel classes so that we can pass through arr as an attribute
        MergesortParallel leftThread = new MergesortParallel(left);
        MergesortParallel rightThread = new MergesortParallel(right);
        rightThread.start();
        leftThread.run();
        try{
            rightThread.join();
        }catch(InterruptedException e){
            System.out.println(e.getLocalizedMessage());
        }

        Merge(arr,leftThread.getArr(),rightThread.getArr());
    }

    public void run(){
        MergesortPar();
    }
    //endregion

}