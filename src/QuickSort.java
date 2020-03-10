;

import java.util.Arrays;

class QuickSort {
    public static void main(String[] args) {

        int[] arr = new int[]{9,8,10,11,2,7,15,6};

        System.out.println(Arrays.toString(quickSort(arr,0,arr.length-1)));


    }

    public static int[] quickSort(int[] arr, int low, int high){

        if (low > high){
            return arr;
        }
        int p = partition(arr, low, high);
        quickSort(arr,low,p-1);
        quickSort(arr,p+1, high);
        return arr;
    }

    public static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;
        return i + 1;
    }
    
    public static int partition2(int[] arr, int low, int high){

        int pivot = arr[low];
        int[] tempArray = new int[high-low + 1];
        int left = 0;
        int right = tempArray.length-1;

        for(int i = low+1; i <= high; i++){
            if (arr[i] <= pivot){
                tempArray[left] = arr[i];
                left++;
            }else {
                tempArray[right--] = arr[i];
            }
        }

        tempArray[left] = pivot;
        System.arraycopy(tempArray, 0, arr, low, tempArray.length);
        return low+left;
    }
}
