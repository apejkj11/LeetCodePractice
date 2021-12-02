//36. Valid Sudoku


class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
		boolean[][] col = new boolean[9][9];
		boolean[][] box = new boolean[9][9];
		for(int i = 0; i < 9; i ++){
			for(int j = 0; j < 9; j ++){
				if(board[i][j] != '.'){
					int t = board[i][j] - '1';
					if(row[i][t] || col[j][t] || box[(i / 3) * 3 + j / 3][t]){
						return false;
					}
					row[i][t] = true;
					col[j][t] = true;
					box[(i / 3) * 3 + j / 3][t] = true;
				}
			}
		}
		return true;
    }
}