package search;

public class RotatedSortedSearch {

    public static void main(String[] args){
        int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        //int arr[] = {1,1};
        int n = arr.length;

        int key = 0;
        System.out.println("find pivot: "+ findPivot(arr, 0, n-1));
        int i = search(arr, 0, n - 1, key);
        if (i != -1)
            System.out.println("Index: " + i);
        else
            System.out.println("Key not found");
    }

    public static int findPivot(int[] arr, int low, int high){
        if(low > high){
            return -1;
        }

        if (high == low)
            return low;

        /* low + (high - low)/2; */
        int mid = (low + high)/2;
        if (arr[mid] > arr[mid + 1])
            return mid;
        if (mid >= 1 && arr[mid] < arr[mid - 1])
            return (mid-1);

        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid-1);

        return findPivot(arr, mid + 1, high);
    }

    public static int search(int[] arr, int low, int high, int target){

        if(low > high){
            return -1;
        }

        int mid = (low + high)/2;
        if(arr[mid] == target){
            return mid;
        }

        if(arr[low] <= arr[mid]){ // first half array sorted
            if(target <= arr[mid] && target >= arr[low]){
                return search(arr, low, mid-1, target);
            }else{
                return search(arr, mid+1, high, target);
            }
        }else { /// 2nd half array sorted
            if(target >= arr[mid] && target <= arr[high]){
                return search(arr, mid+1, high, target);
            }else{
                return search(arr, low, mid-1, target);
            }

        }
    }
}
