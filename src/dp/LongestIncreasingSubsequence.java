package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * L(i) = 1 + max( L(j) ) where 0 < j < i and arr[j] < arr[i]; or
 * L(i) = 1, if no such j exists.
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args){

        List<Integer> list = Arrays.asList(5, 8, 7, 1, 9);
        System.out.println(lis(list));

    }

    public static int lis(List<Integer> list){

        List<Integer> lis = new ArrayList<>(list.size());

        for(int i= 0; i < list.size(); i++){
            lis.add(1);
        }

        for(int i= 1; i < lis.size(); i++){
            for(int j = 0; j < i; j++){
                if(list.get(j) < list.get(i) && (lis.get(i) < 1 + lis.get(j))){
                    lis.set(i, 1 + lis.get(j));
                }
            }
        }
        return Collections.max(lis);
    }

    static int longestSpecialSubseq(String str , int n, int k){
        // Write your code here
        // afcbedf   k = 2
        // a c b d

        int[] lis = new int[n];
        Arrays.fill(lis,1);

        for(int i = 1; i < str.length(); i++){
            for(int j = 0; j < i; j++){
                if( diff(str.charAt(j),str.charAt(i)) <= k ){
                    lis[i] = Math.max( lis[i], 1+ lis[j]);
                }
            }
        }
        int ans = 0;
        return Arrays.stream(lis).max().getAsInt();
    }

    private static int diff(char charAt, char charAt1) {
        return Math.abs(charAt - charAt1);
    }
}
