//Time Complexity: O(mn)
//Space Complexiy:O(1)

class Solution {
    int [][]dirs;
    int m,n;
    public void gameOfLife(int[][] board) {
        if(board==null)return;
        m=board.length;
        n=board[0].length;
        dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int countAlive=countAlive(board,i,j);
                //Rule 1 and 3 when count is less than 2 or count is greater than 3
                if(board[i][j]==1 && (countAlive<2 || countAlive>3)){
                    board[i][j]=2; // marking it as dead
                }
                if(board[i][j]==0 && (countAlive==3))
                    board[i][j]=3;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==2)
                    board[i][j]=0;
                if(board[i][j]==3)
                    board[i][j]=1;
            }
        }
    }
    public int countAlive(int[][] board,int i, int j){
        int result=0;
        for(int dir[]:dirs){
            int r=i+dir[0];
            int c=j+dir[1];
            //Checking 2 because we need to check previous state.
            if(r>=0 && c>=00 && r<m && c<n && (board[r][c]==1 || board[r][c]==2))
               result++;
        }
        return result;
    }
}
