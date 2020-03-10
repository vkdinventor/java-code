package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
                if(list.get(i) > list.get(j) && (lis.get(i) < 1 + lis.get(j))){
                    lis.set(i, 1 + lis.get(j));
                }
            }
        }
        return Collections.max(lis);
    }
}
