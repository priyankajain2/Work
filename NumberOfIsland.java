public class NumberOfIsland {

    private static int land[][] = {{1,0,0,0},
                    {1,0,0,0},
                    {0,0,1,0},
                    {0,0,0,1}};

    public static void main(String args[]){
        int result = noOfIsland(land);
        System.out.println("count: " + result);
    }

    private static int noOfIsland(int[][] land) {
        boolean visited[][] = new boolean[land.length][land[0].length];
        int count=0;
        for(int row=0; row<land.length; row++){
            for(int col=0; col<land[0].length; col++){
                if(!visited[row][col] && land[row][col]==1){
                    dfs(row,col,visited,land);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int row, int col, boolean[][] visited, int[][] land) {
        if(row<0 || col<0 || row>=land.length || col>=land[0].length || land[row][col]==0 || visited[row][col]){
            return;
        }
        visited[row][col] = true;
        dfs(row,col-1,visited,land);
        dfs(row-1,col,visited,land);
        dfs(row,col+1,visited,land);
        dfs(row+1,col,visited,land);
    }
}
