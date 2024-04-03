class Solution {
    public boolean exist(char[][] board, String word) {
        int i,j,m=board.length,n=board[0].length;
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                if(helper(board,i,j,word,0))
                return true;
            }
        }
        return false;
    }
    public boolean helper(char [][]board,int i,int j,String word,int ind)
    {
        if(ind>=word.length())
        return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length)
        return false;
        char ch=board[i][j];
        if(ch=='.')
        return false;
        if(ch!=word.charAt(ind))
        return false;
        board[i][j]='.';
        boolean r=helper(board,i+1,j,word,ind+1)||helper(board,i-1,j,word,ind+1)||helper(board,i,j+1,word,ind+1)||helper(board,i,j-1,word,ind+1);
        board[i][j]=ch;
        return r;
    }
}