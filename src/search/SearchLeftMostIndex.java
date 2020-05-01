package search;


import java.util.List;

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

class SearchLeftMostIndex {
    public static void main(String[] args) {


        int[] arr = {0, 0,0,1,1,1,1,1, 1};
        int ans = findPivot(arr, 0, arr.length-1);
        //int ans = 10000;
        System.out.print(ans);
    }

    static int findPivot(int[] arr, int left, int right){

        if( left >= right){
            return -1;
        }

        if(arr[left] == 1){
            return left;
        }

        int mid = (left + right)/2;

        if(arr[mid+1] > arr[mid]){
            return mid+1;
        }

        if( mid > 0 && arr[mid-1] < arr[mid]){
            return mid;
        }

        if(arr[left] == arr[mid]){
            return findPivot(arr, mid+1, right);
        }else{
            return findPivot(arr, left, mid-1);
        }

    }
}