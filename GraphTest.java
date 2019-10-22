import java.util.*;
import java.lang.*;

public class GraphTest {

    public static void main (String[] args){

        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");
        new GraphTraversal().doBfs(2, g);

        System.out.println("\nFollowing is Depth First Traversal "+
                "(starting from vertex 2)");

        new GraphTraversal().dfsPath(2, g);

    }
}

class Path {

    public Path(int s, Graph graph){

    }

    // has path from s to v
    boolean hasPath(int v){
        return true;
    }

    // path from s to v
    List<Integer> pathTo(int v){
        return null;
    }
}

class GraphTraversal {

    private boolean[] marked;
    private int[] edgeTo;

    void dfsPath( int src, Graph graph){
        marked =  new boolean[graph.V()];
        doDfs(src,graph, marked );

    }

    public void doDfs( int src, Graph graph, boolean[] marked){
        marked[src] = true;
        System.out.print(src+" ");
        for( int i : graph.adj(src)){
            if(!marked[i]){
                marked[i] = true;
                doDfs(i, graph, marked);
            }
        }
    }

    public void doBfs(int src, Graph graph){
        boolean[] marked = new boolean[graph.V()];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(src);
        marked[src] = true;
        while (!queue.isEmpty()){
            int v = queue.poll();
            System.out.print(v+" ");
            for(int i : graph.adj(v)){
                if( !marked[i]){
                    marked[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void verticesConnectedTo(int s, Graph graph){
        Path path = new Path(s, graph);
        for(int i : graph.adj(s)){
            if(path.hasPath(i)){
                System.out.print(i+" ");
            }
        }
    }
}

class Graph {
    // V is number of vertex;
    private int V;
    private List<Integer>[] adj;
    Graph( int v){
        this.V = v;
        adj = (ArrayList<Integer>[]) new ArrayList[V];
        for( int i = 0; i< v; i++ ){
            adj[i] = new ArrayList<>();
        }
    }

    int V(){
        return V;
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        //adj[w].add(v);
    }

    List<Integer> adj(int v){
        return adj[v];
    }

}