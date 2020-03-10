package dp;

import java.lang.*;
import java.util.*;
import java.util.stream.IntStream;

public class Fabonaci {


    public static void main(String[] args) {

        long t = System.currentTimeMillis();
        System.out.println(fib3(40));
        System.out.println("Total Time : " + (System.currentTimeMillis() - t));

         t = System.currentTimeMillis();
        System.out.println(fib2(40));
        System.out.println("Total Time : " + (System.currentTimeMillis() - t));
    }

    private static int fib(int num) {
        if (num <= 1) {
            System.out.print('.');
            return num;
        }
        return fib(num - 1) + fib(num - 2);
    }

    private static int fib2(int num) {

        List<Integer> list = new ArrayList<>();
        for (int i=0; i < num+1; i++) {
            list.add(-1);
        }
        //IntStream.range(0, num+1).forEach(v -> list.add(-1));
        return fib2(num, list);
    }

    private static int fib2(int num, List<Integer> list){
        if (num <= 1) {
            list.set(num, num);
            return num;
        }
        Integer ans = list.get(num);
        if (ans == -1) {
            ans = fib2(num - 1,list) + fib2(num - 2,list);
            list.add(num, ans);
        }
        return ans;

    }

    private static int fib3(int num){

        List<Integer> list = new ArrayList<>();
        list.add(0,0);
        list.add(1,1);

        for(int i=2; i < num+1; i++){
            list.add(i, list.get(i-1)+ list.get(i-2));
        }
        return list.get(num);
    }
}

