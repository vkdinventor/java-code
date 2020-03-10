package graph;

;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DiGraphTest {
    public static void main(String[] args){
        Digraph digraph = new Digraph(7);
        digraph.addEdge(0,1);
        digraph.addEdge(0,2);
        digraph.addEdge(0,5);
        digraph.addEdge(3,6);
        digraph.addEdge(3,5);
        digraph.addEdge(3,4);
        digraph.addEdge(5,2);
        digraph.addEdge(6,4);
        digraph.addEdge(6,0);
        digraph.addEdge(3,2);
        digraph.addEdge(1,4);
        TopologicalSort topologicalSort = new TopologicalSort(digraph);
        topologicalSort.topologicalSort();
    }
}

class TopologicalSort {
    boolean[] marked;
    Digraph digraph;

    public TopologicalSort(Digraph digraph) {
        this.digraph = digraph;
    }

    public void topologicalSort(){

        Stack<Integer> reversePostOrder = new Stack<>();
        marked = new boolean[digraph.V()];
        for(int i=0; i< digraph.V(); i++){
            if(!marked[i]){
                dfs(i, digraph, marked, reversePostOrder);
            }
        }

        while (!reversePostOrder.isEmpty()){
            System.out.print(reversePostOrder.pop()+" ");
        }

    }

    public void postOrder(int src, Digraph graph, boolean[] marked){
        marked[src] = true;
        for( int i : graph.adj(src)){
            if(!marked[i]){
                postOrder(i, graph, marked);
            }
        }
        System.out.print(src+" ");
    }

    //post order dfs
    public void dfs(int src, Digraph digraph, boolean[] marked, List<Integer> reversePostOrder){
        marked[src] = true;
        for( int i:  digraph.adj(src)){
            if(!marked[i]){
                dfs(i, digraph, marked, reversePostOrder);
            }
        }
        reversePostOrder.add(src);
    }
}

class Digraph {

    //create a digraph from input stream
    //graph.Digraph(In in)
    private final int V;
    private final List<Integer>[] adj;

    //create an empty digraph with V vertices
    Digraph(int v) {
        this.V = v;
        adj = (List<Integer>[]) new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    //add a directed edge v→w
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    int V() {
        return V;
    }

    //vertices pointing from v
    List<Integer> adj(int v) {
        return adj[v];
    }

    //number of edges
    int E() {
        return 0;
    }

    //reverse of this digraph
    Digraph reverse() {
        return null;
    }

    public String toString() {
        return null;
    }
}