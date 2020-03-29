package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestAirthmeticProgession {

    public static void main(String[] args){
        //List<Integer> list = Arrays.asList(9, 4, 7, 2, 10);
        List<Integer> list = Arrays.asList(3, 6, 9, 12);
        list = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        System.out.print(solve(list));
    }

    public static int solve(final List<Integer> A) {

        List<Map<Integer, Integer>> mapList = new ArrayList<>();
        for(int i=0; i < A.size(); i++){
            mapList.add(new HashMap<>());
        }

        for(int i = 0; i < A.size(); i++){
            for(int j=0; j < i; j++){
                int diff = A.get(i) - A.get(j);
                Map<Integer, Integer> mapi = mapList.get(i);
                Map<Integer, Integer> mapj = mapList.get(j);

                Integer count = mapj.get(diff);
                if(count == null){
                    mapi.put(diff, 1);
                }else {
                    mapi.put(diff, count+1);
                }
            }
        }

        int ans = 0;
        for (int i=0; i < A.size(); i++) {
            for(Map.Entry<Integer, Integer>  o : mapList.get(A.size()-1).entrySet()){
                ans = Math.max(ans, o.getValue());
            }
        }

        return 1+ ans;
    }
}


