import java.util.Arrays;

class MergeSort {
    public static void main(String[] args){

        int[] arr = new int[]{3,5,2,12,4,3,53,23,19, 23, 89};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }

    private  static int[] mergeSort(int[] arr){
        int length = arr.length;
        if (length == 1){
            return arr;
        }
        int[] left, right;
        if ( length % 2 == 0){
            left = new int[length/2];
            right = new int[length/2];
        }else {
            left =  new int[length/2];
            right = new int[1 + (length/2)];
        }

        System.arraycopy(arr, 0, left, 0, length / 2);
        System.arraycopy(arr, length/2, right, 0, length-(length/2));

        left = mergeSort(left);
        right = mergeSort(right);

        return  merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int length = left.length + right.length;

        int[] result = new int[length];

        int i=0, j=0 , index = 0;

        while ( i < left.length && j < right.length){
            if( left[i] < right[j]){
                result[index++] = left[i++];
            }else {
                result[index++] = right[j++];
            }
        }

        // add every leftover elelment from the subarray
        while (i < left.length) {
            result[index++] = left[i++];
        }

        // only one of these two while loops will be executed
        while (j < right.length) {
            result[index++] = right[j++];
        }
        
        return result;
    }
}

