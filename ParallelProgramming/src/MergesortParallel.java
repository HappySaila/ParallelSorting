public class MergesortParallel{
    public static void main(String[] args){
        System.out.println("Hello Mergesort class");
    }

    //initialisation
    int[] left;
    int[] right;
    int[] arr;
    int i=0;
    int j=0;
    int k=0;

    public void merge(){
        //will merge this objects left array with this objects right array.
        //the resulting array will be saved in arr.
        while (i<left.length && j<right.length){
            if (left[i]<=right[j]){
                arr[k]=left[i];
                i++; k++;
            }else{
                arr[k]=right[j];
                i++; k++;
            }
            //check if there are any elements left in the array.
        }
    }
}