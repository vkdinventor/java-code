;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CountAndSay {

    public static void main(String[] args){
        //nextString(new StringBuilder("1211")); //111221
//        StringBuilder ans = new StringBuilder("113211");
//        for(int i=1; i < 5; i++){
//            ans = nextString(ans);
//            System.out.print(ans+" ");
//        }
        System.out.println(minWindow("AAAAAA","AA"));

    }

    public static String minWindow(String S, String T) {

        //A : "ADOBECODEBANC"
        //B : "ABC"

        ArrayList<Character> set  = new ArrayList<>();

        String ans = "";
        int len = Integer.MAX_VALUE;
        int left = 0, right = 0;
        while (right < S.length()){
            set.add(S.charAt(right));

            while(isPresnt(set,T)){
                String temp = S.substring(left,right+1);
                if (temp.length() < len ){
                    len = temp.length();
                    ans = temp;
                }
                set.remove(0);
                left++;
            }
            right++;
        }
        return ans;
    }

    static boolean isPresnt (ArrayList<Character> set, String T){
        //Queue

        ArrayList<Character> charSet = new ArrayList<>(set);
        for(char ch : T.toCharArray()){
            if(!charSet.contains(ch)){
                return false;
            }else {
                charSet.remove(Character.valueOf(ch));
            }
        }
        return true;
    }

    public static StringBuilder nextString(StringBuilder ans){

        StringBuilder tempAns = new StringBuilder();
        int key = ans.charAt(0)-'0';
        int count = 1;

        int prevKey = key;
        int prevCount = count;
        for(int i=1; i< ans.length(); i++){
            key = ans.charAt(i)-'0';
            if (prevKey != key){
                tempAns.append(count).append(prevKey);
                prevCount = count;
                prevKey = key;
                count =0;
            }
            count++;
        }
        if( count > 0 ){
            tempAns.append(count).append(key);
        }

        return tempAns;
    }

    public static StringBuilder nextString2(StringBuilder ans){
        Map<Integer, Integer> map = new LinkedHashMap<>();

        StringBuilder tempAns = new StringBuilder();
        int key = ans.charAt(0)-'0';
        map.put(key,1);

        int prevKey = key;
        for(int i=1; i< ans.length(); i++){
            key = ans.charAt(i)-'0';
            if(map.containsKey(key)){
                int val = map.get(key);
                map.put(key,val+1);
            }else{
                map.put(key,1);
            }
            if(prevKey != key){
                tempAns.append(map.get(prevKey)).append(prevKey);
                map.remove(prevKey);
                prevKey = key;
            }
        }

        if(map.containsKey(key)){
            tempAns.append(map.get(prevKey)).append(prevKey);
        }
        return tempAns;
    }
}
