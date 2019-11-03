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

        /*
        29 4
6 21 17 12 2 11 9 11
         */
        Graph graph1 = new Graph(29);
        graph1.addEdge(6,21);
        graph1.addEdge(17,12);
        graph1.addEdge(2,11);
        graph1.addEdge(9,11);
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i< 29; i++){
            graph.add(graph1.adj(i));
        }
        System.out.print(GraphTraversal.isCyclic(graph, 29));

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


    static Boolean isCyclicUtil(int v, List<List<Integer>> list, Boolean[] visited, int parent) {
        // Mark the current node as visited
        visited[v] = true;
        // Recur for all the vertices adjacent to this vertex
        for (Integer i : list.get(v)) {
            // If an adjacent is not visited, then recur for that adjacent
            if (!visited[i]) {
                if (isCyclicUtil(i, list, visited, v))
                    return true;
            } else if (i != parent) {
                // If an adjacent is visited and not parent of current vertex, then there is a cycle.
                return true;
            }
        }
        return false;
    }

    // Returns true if the graph contains a cycle, else false.
    static boolean isCyclic(List<List<Integer>> list, int V) {
        // Mark all the vertices as not visited and not part of recursion stack
        Boolean[] visited = new Boolean[V];

        // Call the recursive helper function to detect cycle in different DFS trees
        for (int u = 0; u < V; u++)
            // Don't recur for u if already visited
            if (!visited[u]) {
                if (isCyclicUtil(u, list, visited, -1)) {
                    return true;
                }
            }
        return false;
    }

    boolean bfsInMatrix(int[][] G, int v) {
        //add code here.
        boolean[] marked = new boolean[v];
        Queue<Integer> q = new ArrayDeque<>();
        int src = G[0][0];
        marked[src] = true;
        q.add(src);
        while (!q.isEmpty()) {
            Integer a = q.poll();
            //System.out.print(a+" ");
            for (int i = 0; i < v; i++) {
                if (G[a][i] == 1 && !marked[i]) {
                    marked[i] = true;
                    q.add(i);
                }
            }
        }
        return true;
    }

    public static boolean isBipartite(int[][] G, int V) {

        int[] colorArr = new int[V];
        for (int i = 0; i < V; ++i)
            colorArr[i] = -1;
        // This code is to handle disconnected graoh
        for (int i = 0; i < V; i++)
            if (colorArr[i] == -1)
                if (!isBipartiteUtil(G, V, colorArr, i))
                    return false;

        return true;
    }

    public static boolean isBipartiteUtil(int[][] G, int v, int[] colorArr, int src) {

        Queue<Integer> q = new ArrayDeque<>();
        colorArr[src] = 1;
        q.add(src);
        while (!q.isEmpty()) {
            Integer a = q.poll();
            // self loop
            if (G[a][a] == 1) {
                return false;
            }
            //System.out.print(a+" ");
            for (int i = 0; i < v; i++) {
                if (G[a][i] == 1 && colorArr[i] == -1) {
                    colorArr[i] = 1 - colorArr[a];
                    q.add(i);
                } else if (G[a][i] == 1 && colorArr[i] == colorArr[a]) {
                    return false;
                }
            }
        }
        return true;
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
        adj[w].add(v);
    }

    List<Integer> adj(int v){
        return adj[v];
    }

}