package backtracking;

import java.util.Arrays;

class MoveZero {

    public static void main(String[] args){
        int[] arr = {0,1,0,3,12};
        MoveZero moveZero = new MoveZero();
        moveZero.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
    public void moveZeroes(int[] nums) {

        int zero = -1;
        int nonZero = -1;
        for(int i= 0; i < nums.length-1; i++){
            if(nums[i] == 0){
                swap(nums, i, i+1);
            }
        }
    }

    public void swap(int[] arr, int i, int j){
        //System.out.println("before: "+arr[i] +", "+ arr[j]);
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        //System.out.println("before: "+arr[i] +", "+ arr[j]);
    }
}