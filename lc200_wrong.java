class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length==0||grid[0].length==0) return 0;
        char symbol = '2';
        if(grid[0][0] == '1') grid[0][0] = ++symbol;
        for(int i = 1;i<grid[0].length;i++){
            if(grid[0][i]=='1'){
                if(grid[0][i-1]>'0') grid[0][i] = grid[0][i-1];
                else grid[0][i]=++symbol;
            }
        }
        for(int i = 1; i<grid.length;i++){
            if(grid[i][0]=='1'){
                if(grid[i-1][0]>'0') grid[i][0] = grid[i-1][0];
                else grid[i][0] = ++symbol;
            }
            for(int j = 1;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    if(grid[i-1][j]>'0'&&grid[i][j-1]>'0'){
                    char key = grid[i-1][j]>grid[i][j-1]?grid[i][j-1]:grid[i-1][j];
                      grid[i][j] =  key;
                     if(grid[i][j-1] !=grid[i-1][j]) {
                         symbol--;
                        } 
                    }
                    else if(grid[i-1][j]>'0') grid[i][j] = grid[i-1][j];
                    else if(grid[i][j-1]>'0') grid[i][j] = grid[i][j-1];
                    else grid[i][j] = ++symbol;
                }
            }
        }
        return (int)symbol-50;
    }
}