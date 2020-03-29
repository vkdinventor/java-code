

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubStringConcatation {
//aabaaaabcaabcacabaa
//aab aaa abc aab cac abaa
    //[ "cac", "aaa", "aba", "aab", "abc" ]

    public static void main(String[] args) {
        ArrayList<String> listKey = new ArrayList<>(Arrays.asList("foo", "bar"));
        ArrayList<Integer> ans = findSubstring("barfoothefoobarman", listKey);
        System.out.println(Arrays.toString(ans.toArray()));
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String S, String T) {
        int[] src = new int[256];
        int[] target = new int[256];

        for (int i = 0; i < T.length(); i++) {
            target[T.charAt(i)]++;
        }

        String res = "";
        int count = 0;
        int start = 0;
        int minWindow = Integer.MAX_VALUE;

        //A : "ADOBECODEBANC"
        //B : "ABC"

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            src[ch]++;
            if (src[ch] <= target[ch]) {
                count++;
            }

            if (count == T.length()) {
                while (src[S.charAt(start)] > target[S.charAt(start)]) {
                    src[S.charAt(start)]--;
                    start++;
                }

                if (i - start + 1 < minWindow) {
                    res = S.substring(start, i + 1);
                    minWindow = i - start + 1;
                }
            }

        }
        return res;
    }

    public static ArrayList<Integer> findSubstring(String string, final List<String> list) {

        Map<String, Integer> map = new HashMap<>();
        for (String key : list) {
            Integer val = map.get(key);
            if (val == null) {
                map.put(key, 1);
            } else {
                map.put(key, val + 1);
            }
        }
        ArrayList<Integer> ansList = new ArrayList<Integer>();
        int size = list.size();
        int wordSize = list.get(0).length();
        int strSize = size * wordSize;
        for (int i = 0; i + strSize <= string.length(); i++) {
            String tempStr = string.substring(i, i + strSize);
            if (isValid(wordSize, tempStr, map)) {
                ansList.add(i);
            }
        }
        return ansList;
    }

    static boolean isValid(int wordSize, String str, Map<String, Integer> map2) {
        Map<String, Integer> map = new HashMap<>(map2);
        for (int i = 0; i + wordSize <= str.length(); i = i + wordSize) {
            String word = str.substring(i, i + wordSize);
            Integer val = map.get(word);
            if (val == null || val <= 0) {
                return false;
            }
            map.put(word, val - 1);
        }
        return true;
    }

}
