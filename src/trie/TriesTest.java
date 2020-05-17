package trie;

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
        head.insert("vikashVerma");

        System.out.println(head.search("tech"));            // print true
        System.out.println(head.search("techi"));            // print true
        System.out.println(head.search("techie"));            // print true
        System.out.println(head.search("techiedelight"));    // print true
        System.out.println(head.search("vikash"));    // print true
        System.out.println(head.search("vikashVerma"));

    }
}


class Trie {

    /** Initialize your data structure here. */
    Map<Character, Trie> childMap;
    boolean isLeaf;
    public Trie() {
        this.isLeaf = false;
        this.childMap = new HashMap<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        Trie curr = this;
        for(Character ch : word.toCharArray()){
            if(curr.childMap.get(ch) == null){
                curr.childMap.put(ch, new Trie());
            }
            curr = curr.childMap.get(ch);
        }
        curr.isLeaf = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie curr = this;
        for(Character ch : word.toCharArray()){
            if(!curr.childMap.containsKey(ch)){
                return false;
            }
            curr = curr.childMap.get(ch);
        }
        return curr.isLeaf;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
        Trie curr = this;
        for(Character ch : word.toCharArray()){
            if(!curr.childMap.containsKey(ch)){
                return false;
            }
            curr = curr.childMap.get(ch);
        }
        return true;
    }
}
