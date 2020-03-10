;

public class ConnectedComponent {

    private boolean[] marked;
    private int[] id;
    private int count = 0;

    public static void main(String[] args) {

        Graph graph = new Graph(13);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(4,6);
        graph.addEdge(4,3);
        graph.addEdge(0,6);
        graph.addEdge(0,5);
        graph.addEdge(5,3);
        graph.addEdge(5,4);
        graph.addEdge(7,8);
        graph.addEdge(9,10);
        graph.addEdge(9,10);
        graph.addEdge(9,11);
        graph.addEdge(9,12);

        GraphTraversal graphTraversal = new GraphTraversal();
        System.out.print("\nDFS :");
        graphTraversal.doDfs(0, graph,new boolean[7]);
        System.out.print("\nBFS :");
        graphTraversal.doBfs(0, graph);

        ConnectedComponent cc = new ConnectedComponent(graph, 13);
        System.out.println("No of connected component : "+ cc.getCount());

        System.out.print("Component connected to "+2+ " is: ");
        for(int i = 0; i< 13; i++){
            if(cc.id(i) == 1){
                System.out.print(i+" ");
            }
        }
    }

    public ConnectedComponent(Graph graph, int v){
        marked = new boolean[v];
        id = new int[v];
        for (int i = 0; i< v; i++){
            if(!marked[i]){
                dfs(graph, i);
                count++;
            }
        }
    }

    public int getCount(){
        return count;
    }
    public int id(int v){
        return id[v];
    }
    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        for(int i:G.adj(v)){
            if(!marked[i]){
                dfs(G, i);
            }
        }
    }

}
