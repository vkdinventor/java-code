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

        int index = 0;
        int i = 0;

        for(i= 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[index]= nums[i];
                index++;
            }
        }
        while(index < nums.length){
            nums[index]=0;
            index++;
        }
    }
}