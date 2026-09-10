class Solution {

    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        // Try every cell as the starting point
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (solve(row, col, 0, board, word, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean solve(int row, int col, int index,
                          char[][] board, String word,
                          boolean[][] visited) {

        // All characters matched
        if (index == word.length()) {
            return true;
        }

        // Invalid cell
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length ||
            visited[row][col] ||
            board[row][col] != word.charAt(index)) {

            return false;
        }

        // Mark current cell as visited
        visited[row][col] = true;

        // Try 4 directions
        boolean found =
                solve(row - 1, col, index + 1, board, word, visited) || // up
                solve(row + 1, col, index + 1, board, word, visited) || // down
                solve(row, col - 1, index + 1, board, word, visited) || 
                solve(row, col + 1, index + 1, board, word, visited);  

        visited[row][col] = false;

        return found;
    }
}