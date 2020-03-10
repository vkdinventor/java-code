;

import java.util.HashMap;
import java.util.Map;

public class TriesTest {

    public static void main(String[] args) {
        Trie head = new Trie();

        head.insert("techie");
        head.insert("techi");
        head.insert("tech");
        head.insert("vikash");

        System.out.println(head.search("tech"));            // print true
        System.out.println(head.search("techi"));            // print true
        System.out.println(head.search("techie"));            // print true
        System.out.println(head.search("techiedelight"));    // print false

        head.insert("techiedelight");

        System.out.println(head.search("tech"));            // print true
        System.out.println(head.search("techi"));            // print true
        System.out.println(head.search("techie"));            // print true
        System.out.println(head.search("techiedelight"));    // print true
        System.out.println(head.search("vikash"));    // print true
    }
}


class Trie {
    private boolean isLeaf = false;
    private Map<Character, Trie> trieMap;

    Trie(){
        isLeaf = false;
        trieMap = new HashMap<>();
    }

    public void insert(String key){

        Trie curr = this;
        for(char ch : key.toCharArray()){
            if(trieMap.get(ch) == null){
                trieMap.put(ch, new Trie());
            }
            curr = trieMap.get(ch);
        }
        curr.isLeaf = true;
    }

    public boolean search(String key){

        Trie curr = this;
        for(char ch : key.toCharArray()){

            curr = trieMap.get(ch);
            if(curr == null){
                return false;
            }
        }
        return curr.isLeaf;
    }
}
