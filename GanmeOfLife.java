// Time Complexity :O(mn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Follow the given rules
class Solution {
    public void gameOfLife(int[][] board) {
        //edge case
        if(board==null || board.length==0) return;
        
     
        for(int i = 0 ; i <board.length;i++)
        {
            for(int j = 0 ; j <board[0].length;j++)
            {
                int live = neighbour(board,i,j);
                //live cell
                if(board[i][j]==1)
                {
                    //condition 1
                    if(live<2 || live >3)
                        board[i][j] =5; //DEAD
                }
                else //dead cell
                {
                    if(live==3)
                       board[i][j] =3; //Live
                }
            }
        }
        for(int i = 0 ; i <board.length;i++)
        {
            for(int j = 0 ; j <board[0].length;j++)
            {
                if(board[i][j] == 5)
                    board[i][j] =0;
                if(board[i][j]==3)
                    board[i][j]=1;
            }
        }
    
    }
    private int neighbour(int[][] board,int i , int j)
    {
        int count=0;
        //up
        if(i-1>=0)
        {
            count+=board[i-1][j]==5 || board[i-1][j]==1 ?1:0;
            if(j+1<board[0].length) count+=board[i-1][j+1]==5 || board[i-1][j+1]==1 ?1:0;
            if(j-1>=0) count+=board[i-1][j-1]==5 || board[i-1][j-1]==1 ?1:0;
        }
        if(i+1<board.length) // down
        {
            count+=board[i+1][j]==5 || board[i+1][j]==1 ?1:0;
            if(j+1<board[0].length) count+=board[i+1][j+1]==5 || board[i+1][j+1]==1 ?1:0;
            if(j-1>=0) count+=board[i+1][j-1]==5 || board[i+1][j-1]==1 ?1:0;
            
        }
        if(j-1>=0) //left
        {
            count+=board[i][j-1]==5 || board[i][j-1]==1 ?1:0;
        }
        if(j+1<board[0].length) //right
        {
            count+=board[i][j+1]==5 || board[i][j+1]==1 ?1:0;
        }
        return count;
    }
}