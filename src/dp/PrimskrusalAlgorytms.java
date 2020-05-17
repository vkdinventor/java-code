package dp;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PrimskrusalAlgorytms {

    public static void main(String[] args) {

        /*
        A : 4
        B :
        [
          [1, 2, 1]
          [2, 3, 2]
          [3, 4, 4]
          [1, 4, 3]
        ]
        */
        ArrayList<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(1, 2, 1));
        lists.add(Arrays.asList(2, 3, 2));
        lists.add(Arrays.asList(3, 4, 4));
        lists.add(Arrays.asList(1, 4, 3));

        int ans = new PrimskrusalAlgorytms().krusal(4, lists);
        System.out.println(ans);
    }


    int[] id;
    public static int solve(int A, ArrayList<ArrayList<Integer>> graph1) {
        List<List<Integer>> graph = new ArrayList<>();
        for (List<Integer> list : graph1) {
            graph.add(list);
        }
        return prim(A, graph);
        //return krusal(A, graph);
    }


    public  int krusal(int A, List<List<Integer>> graph) {

        int cost = 0;
        id = new int[A + 1];
        for (int i = 1; i <= A; i++) {
            id[i] = i;
        }

        Collections.sort(graph, (o1, o2) -> o1.get(2) - o2.get(2));

        for (List<Integer> edge : graph) {
            int x = find(edge.get(0));
            int y = find(edge.get(1));
            if (x != y) {
                cost += edge.get(2);
                union(x, y);
            }
        }
        return cost;
    }

    public int find(int x) {
        while (x != id[x]) {
            x = id[x];
        }
        return x;
    }

    public void union(int x, int y) {
        int i = find(x);
        int j = find(y);
        id[i] = j;
    }


    // not working will modify it
    public static int prim(int A, List<List<Integer>> graph) {

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((v1, v2) -> v1.get(2) - v2.get(2));

        for (List<Integer> edge : graph) {
            if (edge.get(0) == 1 || edge.get(1) == 1) {
                pq.add(edge);
            }
        }

        int cost = 0;
        int count = 0;

        boolean[] isVisited = new boolean[A + 1]; // as node start from 1;
        //isVisited[1] = true;
        while (!pq.isEmpty() && count < A - 1) {
            List<Integer> minEdge = pq.poll();
            //System.out.print(" "+Arrays.toString(minEdge.toArray()));
            cost += minEdge.get(2);
            count++;
            int destination = minEdge.get(1);
            isVisited[minEdge.get(0)] = true;

            if (!isVisited[destination]) {
                for (List<Integer> edge : graph) {
                    if ((!isVisited[edge.get(0)] && !isVisited[edge.get(1)]) &&
                            (edge.get(0) == destination || edge.get(1) == destination)) {
                        pq.add(edge);
                    }
                }
            }
        }
        return cost;
    }
}
