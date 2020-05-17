package graph;


public class FillColor {

    public static void main(String[] args){

        int[][] graph = {{1,1,1},{1,1,0},{1,0,1}};
        SolutionG solution = new SolutionG();
        int[][] ans = solution.floodFill(graph, 1, 1, 2);
        System.out.println(ans);
    }


}
class SolutionG {

    int oldColor = 0;
    int newColor = 0;
    int rowSize = 0;
    int colSize = 0;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.oldColor = image[sr][sc];
        this.newColor = newColor;
        rowSize = image.length;
        colSize = image[0].length;

        boolean[][] isVisited = new boolean[rowSize][colSize];
        dfs(image, isVisited, sr, sc);
        return image;
    }

    public void dfs(int[][] img, boolean[][] isVisited, int sr, int sc){

        isVisited[sr][sc] = true;
        img[sr][sc] = newColor;

        int[] dx = {1 , -1, 0,  0};
        int[] dy = {0,   0, 1, -1};

        for(int i=0; i< 4; i++){
            int r = sr + dy[i];
            int c = sc + dx[i];
            if(isSafeVisit(img, isVisited, r, c )){
                dfs(img, isVisited, r, c);
            }
        }
    }

    boolean isSafeVisit(int[][] img, boolean[][] isVisited, int sr, int sc){
        return (sr >= 0 && sc >=0 && sr < rowSize && sc < colSize && !isVisited[sr][sc] && img[sr][sc] == oldColor);
    }
}