package graph;

import static javafx.scene.input.KeyCode.M;

public class NumberOfIsLand {

    public static void main(String[] args) {
        int mat[][] = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        System.out.println(countIslands(mat));

    }

    static int countIslands(int[][] graph) {

        boolean[][] visited = new boolean[graph.length][graph[0].length];
        int count = 0;
        for (int i = 0; i < graph.length; ++i)
            for (int j = 0; j < graph[i].length; ++j)
                if (graph[i][j] == 1 && !visited[i][j]) {
                    doDfs(graph, visited, i, j);
                    ++count;
                }

        return count;
    }

    static void doDfs(int[][] graph, boolean[][] visited, int i, int j) {
        visited[i][j] = true;
        int[] col = {0, 0, 1, -1};
        int[] row = {-1, 1, 0, 0};

        for (int k = 0; k < 4; k++) {
            int r = i+row[k];
            int c = j+col[k];
            if (isSafe(graph, visited, r, c)) {
                doDfs(graph, visited, r, c);
            }
        }
    }

    private static boolean isSafe(int[][] graph, boolean[][] visited, int i, int j) {
        return (i >= 0 && j >= 0 && i < graph.length && j < graph[0].length && (!visited[i][j] && graph[i][j] == 1));
    }


}
