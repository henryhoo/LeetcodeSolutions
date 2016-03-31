c class Solution {
    char[][] boards;
    int[][] visited;
    public boolean exist(char[][] board, String word) {
        boards=board;
        int row = board.length;
        int line = board[0].length;

        visited = new int[row][line];
        
        for (int i = 0;i<row;i++){
            for (int j = 0;j<line;j++){
                
                if(dfs(i,j,0,word)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int cursor,String word){
        if(cursor==word.length()) return true;
        if(i>=boards.length||j>=boards[0].length||i<0||j<0) return false;
        if(visited[i][j]==1) return false;
        if(boards[i][j]!=word.charAt(cursor)) return false;
        visited[i][j]=1;
        cursor++;
        if(dfs(i+1,j,cursor,word)) return true;
        if(dfs(i,j+1,cursor,word)) return true;
        if(dfs(i-1,j,cursor,word)) return true;
        if(dfs(i,j-1,cursor,word)) return true;
        visited[i][j]=0;
        return false;
    }
}
