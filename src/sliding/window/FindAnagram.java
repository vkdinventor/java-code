package sliding.window;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// s: "cbaebabacd" p: "abc"
        /*"abab"
"ab"*/
public class FindAnagram {

    public static void main(String[] arg) {

        List<Integer> ans = findAnagrams("cbaebabacd", "abc");
        System.out.println(Arrays.toString(ans.toArray()));
    }

    public List<Integer> findAnagramsSimple(String s, String p) {
        int ns = s.length();
        int np = p.length();
        int[] sRef = new int[26];
        int[] pRef = new int[26];
        List<Integer> results = new ArrayList<>();

        if(ns < np) {
            return results; // No solution
        }
        // Build the reference array for p
        for(char ch : p.toCharArray()) {
            pRef[ch - 'a']++;
        }

        // Slide window and compare
        for(int i = 0; i < ns; i++) {
            sRef[s.charAt(i) - 'a'] ++; // Add right
            if(i >= np) {
                sRef[s.charAt(i - np) - 'a']--; // Remove from left
            }

            if(Arrays.equals(sRef, pRef)) {
                results.add((i - np) + 1);
            }
        }
        return results;
    }


    //sliding window
    public static List<Integer> findAnagrams(String s, String p) {

        int windowSize = p.length();
        if(windowSize > s.length()){
            return new ArrayList<>();
        }
        Map<Character, Integer> mapP = new HashMap<>();
        for (char ch : p.toCharArray()) {
            mapP.merge(ch, 1, Integer::sum);
        }


        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> mapS = new HashMap<>();
        for (int i = 0; i < windowSize - 1; i++) {
            mapS.merge(s.charAt(i), 1, Integer::sum);
        }

        for (int i = windowSize - 1; i < s.length(); i++) {
            //System.out.println(s.substring(i, i + p.length())+" ");
            char ch = s.charAt(i);
            mapS.merge(ch, 1, Integer::sum);
            if (mapP.equals(mapS)) {
                list.add(i + 1 - windowSize);
            }
            char key = s.charAt(i + 1 - windowSize);
            Integer count = mapS.get(key);
            if(count != null && count > 1){
                mapS.merge(s.charAt(i + 1 - windowSize), -1, Integer::sum);
            }else {
                mapS.remove(key);
            }
        }
        return list;
    }

    public static List<Integer> findAnagrams2(String s, String p) {

        // s: "cbaebabacd" p: "abc"
        /*"abab"
````````"ab"*/
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : p.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null) {
                map.put(ch, 1);
            } else {
                map.put(ch, count + 1);
            }
        }

        int left = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= s.length() - p.length(); i++) {
            System.out.println(s.substring(i, i + p.length()) + " ");
            if (isAnagram(s.substring(i, i + p.length()), map)) {
                list.add(i);
            }
        }
        return list;
    }

    static boolean isAnagram(String s, Map<Character, Integer> mapKey) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null) {
                map.put(ch, 1);
            } else {
                map.put(ch, count + 1);
            }
        }
        return mapKey.equals(map);
    }
}
