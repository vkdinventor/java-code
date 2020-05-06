;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class TestSomething {

    public static void main(String[] args) {

        System.out.println(new Solution().cpFact(21,49));
        //int[] arr = new int[]{ 756898537, -1973594324, -2038664370, -184803526, 1424268980 };
        int[] arr = new int[]{1756898537, -1973594324, -2038664370, -184803526, 24268980};
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : arr) {
            list.add(i);
        }
        System.out.print(Arrays.toString(Solution.maxset(list).toArray()));

        List<Integer> list1 = new ArrayList<>();
        list1.add(19);
        list1.add(9);
        list1.add(12);

        Solution.maxInt(list1);

        int ans = lastStoneWeight(new int[]{2,7,4,1,8,1});
        Map<Integer, Integer> map = new HashMap<>();
        map.merge(0, 1, Integer::sum);

        map.merge(1, 1, Integer::sum);
        AtomicInteger ans1 = new AtomicInteger();
        map.forEach( (k, v) -> {
            if (v > list.size()){
                ans1.set(k);
            }
        });

        boolean istrue = isAanagram("abc","bca");
    }

    static boolean isAanagram(String test, String target) {

        if (test.length() == target.length()) {
            Map<Character, Integer> map = new HashMap<>();

            for (char ch : test.toCharArray()) {
                Integer count = map.get(ch);
                if (count == null) {
                    map.put(ch, 1);
                } else {
                    map.put(ch, count + 1);
                }
            }

            for (char ch : target.toCharArray()) {
                Integer count = map.get(ch);
                if (count == null) {
                    return false;
                } else {
                    map.put(ch, count - 1);
                }
            }

            for (Integer val : map.values()) {
                if (val != 0) {
                    return false;
                }
            }
            return true;

        }
        return false;
    }

    public static int lastStoneWeight(int[] stones) {

        int count = stones.length;
        int lastIndex = stones.length - 1;
        while (count > 1) {

            Arrays.sort(stones);
            if(stones[lastIndex] == stones[lastIndex - 1]){
                count--;
                stones[lastIndex] = 0;
            }else{
                stones[lastIndex] = stones[lastIndex] - stones[lastIndex - 1];
            }
            stones[lastIndex - 1] = 0;
            count--;
        }

        for (int i = 0; i < stones.length; i++) {
            if (stones[i] > 0) {
                return stones[i];
            }
        }
        return 0;
    }
}

class Solution {
    public static ArrayList<Integer> maxset(List<Integer> list) {
        ArrayList<Integer> maxList = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();

        long sum = 0L;
        long tempSum = 0L;

//756898537, -1973594324, -2038664370, -184803526, 1424268980
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) >= 0) {
                tempSum = tempSum + list.get(i);
                tempList.add(list.get(i));
            } else {
                tempSum = 0;
                tempList.clear();
            }
            //System.out.print(list.get(i));
            //System.out.print(" "+tempSum+" "+sum);
            if (tempSum > sum || (tempSum == sum && tempList.size() > maxList.size())) {
                sum = tempSum;
                maxList.clear();
                maxList.addAll(tempList);
                tempList.clear();
            }
        }

        return maxList;

    }

    public static void maxInt(List<Integer> list) {
        String.valueOf(0);

        Collections.sort(list, (o1, o2) -> {
            Integer i1 = Integer.parseInt(o1 + "" + o2);
            Integer i2 = Integer.parseInt(o2 + "" + o1);
            return i2.compareTo(i1);
        });

        System.out.print(Arrays.toString(list.toArray()));

    }

    /*
      x divides A i.e. A % X = 0
    X and B are co-prime i.e. gcd(X, B) = 1

    */
    public int cpFact(int A, int B) {
        //return gcd(30, 10);

        //int x = (int)Math.sqrt(A);
        int x = A;
        int i = 2;
        while (x >= 1) {
            if (A % x == 0 && gcd(x, B) == 1) {
                return x;
            }
            x = x / 2;
            i++;
        }

        return 1;

    }

    public int gcd(int a, int b) {

        if (a == 0) {
            return b;
        }

        if (b == 0) {
            return a;
        }

        if (a == b) {
            return a;
        }

        if (a > b) {
            return gcd(a % b, b);
        } else {
            return gcd(b, a % b);
        }


    }


}