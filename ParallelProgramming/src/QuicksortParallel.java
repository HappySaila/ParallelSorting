public class QuicksortParallel extends java.lang.Thread{
    public static void main(String[] args){
        System.out.println("Hello Quicksort class");
    }
    //region instantiate
    private int[] arr;
    private int sequentialCutoff;
    private int start;
    private int end;
    //endregion

    // region constructors
    public QuicksortParallel(int[] arr) {
        this.arr = arr;
    }
    public QuicksortParallel(int[] arr, int sc) {
        this.arr = arr;
        this.sequentialCutoff =sc;
    }
    public QuicksortParallel(int[] arr, int sequentialCutoff, int start,  int end) {
        this.start = start;
        this.sequentialCutoff = sequentialCutoff;
        this.end = end;
        this.arr = arr;
    }
    //endregion

    // region get set
    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getSequentialCutoff() {
        return sequentialCutoff;
    }

    public void setSequentialCutoff(int sequentialCutoff) {
        this.sequentialCutoff = sequentialCutoff;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
    //endregion

    // region methods
    public int Partition(int[] arr, int start, int end){
        int pivot = arr[end];
        int pIndex = start;
        for (int i=start; i<end+1; i++){
            if (arr[i]<=pivot){
                swap(arr, i, pIndex);
                pIndex++;
            }
        }
        if ((end-start)<0){
            return -1;
        }
        return pIndex-1;
    }
    public void swap(int[] arr, int i, int pIndex){
        int temp = arr[i];
        arr[i]=arr[pIndex];
        arr[pIndex]=temp;
    }
    public void QuicksortSeq(int start, int end){
        if (start<end){
            int pIndex = Partition(this.arr, start, end);
            QuicksortSeq(start, pIndex-1);
            QuicksortSeq(pIndex+1, end);
        }
    }
    public void QuicksortPar(){
        if (arr.length<=sequentialCutoff){
            //sequential quick sort
            QuicksortSeq(this.start, this.end);
        }
        else if(start<end){
            int pIndex = Partition(this.arr, start, end);
            QuicksortParallel threadLeft = new QuicksortParallel(this.arr, this.sequentialCutoff, start, pIndex-1);
            QuicksortParallel threadRight = new QuicksortParallel(this.arr, this.sequentialCutoff, pIndex+1, end);
            threadRight.run();
            threadLeft.start();
            try{
                threadLeft.join();
            }catch(InterruptedException e){
                System.out.println(e.getLocalizedMessage());
            }
        }
    }
    public void run(){
        QuicksortPar();
    }
    //endregion
}