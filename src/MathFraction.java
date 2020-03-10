;

import java.util.HashMap;
import java.util.Map;

public class MathFraction {

    public static void main(String[] args){

        System.out.println(MathFraction.fractionToDecimal(1, 227870000));
    }


    public static String fractionToDecimal(int a, int b) {
        // 87 22
        if ( a == 0){
            return "0";
        }
        long num = a;
        long denum = b;
        StringBuilder sb = new StringBuilder();
        if((num < 0) ^ (denum < 0)){
            sb.append("-");
        }

        num = Math.abs(num);
        denum = Math.abs(denum);
        long ans = num / denum;
        if (num % denum == 0){
            return sb.append(ans).toString();
        }

        sb.append(ans).append(".");
        Map<Long, Integer> map =  new HashMap<>();
        num = (num % denum)*10;

        while(!map.containsKey(num)){
            map.put(num,sb.length());
            sb.append(num/denum);
            num = (num % denum)*10;
            if(num==0) return sb.toString();
        }
        return sb.insert(map.get(num),"(").append(")").toString();
    }
}
