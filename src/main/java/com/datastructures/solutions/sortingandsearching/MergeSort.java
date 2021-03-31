package main.java.com.datastructures.solutions.sortingandsearching;

public class MergeSort {
    public int[] mergeSort(int[] unsortedArray, int left, int right){
        if(left < right) {
            int middle = (left + right) / 2;
            mergeSort(unsortedArray, left, middle);
            mergeSort(unsortedArray, middle + 1, right);
            merge(unsortedArray, middle, left, right);
            return unsortedArray;
        }
        return unsortedArray;
    }
    public void merge (int[] unsortedArray, int middle, int left, int right) {
        int leftArray[] = new int[middle-left+1];
        int rightArray[] = new int[right-middle];
        

        int leftIndex = 0;
        int rightIndex = 0;
        int currentIndex = left;

        while(leftIndex <= middle && rightIndex <= right ){
            if(leftArray[leftIndex] <= rightArray[rightIndex]) {
                unsortedArray[currentIndex] = leftArray[leftIndex];
                leftIndex++;
            }
            else{
                unsortedArray[currentIndex] = rightArray[rightIndex];
                rightIndex++;
            }
        }



    }
    public static void main(String[] args)
    {
        int[] arr = new int[]{2,4,1,6,7,3,5,4,6};
        MergeSort sort = new MergeSort();
        sort.mergeSort(arr, 0, arr.length-1);


    }
}
