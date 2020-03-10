import java.util.HashMap;
import java.util.Map;

public class ShortestUniquePrefix {

    public static void main(String[] args){

        String[] arr = {"zebra", "dog", "duck", "dove"};
        //String[] arr = {"bearcat", "bert"};
        CustomTrie root = new CustomTrie();
        for (String s : arr) {
            root.insert(s);
        }

        for (String s : arr) {
         //   root.insert(s);
            System.out.println(root.getPrifix(s));
        }
    }
}

class CustomTrie {

    private int frequency;
    private boolean isLeaf = false;
    private Map<Character, CustomTrie> trieMap;

    CustomTrie(){
        this(0, false);
    }

    CustomTrie( int frequency, boolean isLeaf){
        this.frequency = frequency;
        this.isLeaf = isLeaf;
        trieMap = new HashMap<>();
    }

    void insert(String key){
        CustomTrie currentTrie = this;
        for(char ch : key.toCharArray() ){
            if(currentTrie.trieMap.get(ch) == null){
                currentTrie.trieMap.put(ch, new CustomTrie());
            }
            currentTrie = currentTrie.trieMap.get(ch);
            currentTrie.frequency = 1+currentTrie.frequency;
        }
        currentTrie.isLeaf = true;
    }

    String getPrifix(String key){
        int count = 0;
        CustomTrie currentTrie = this;
        for(char ch : key.toCharArray()){
            currentTrie = currentTrie.trieMap.get(ch);
            if(currentTrie != null && currentTrie.frequency > 1){
                count++;
            }else {
                return key.substring(0, count+1);
            }
        }
        return key;
    }
}
