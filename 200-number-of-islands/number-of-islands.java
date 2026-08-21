class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    islandCount++;       // found the "start" of a new island
                    sinkIsland(grid, r, c); // mark this whole island as visited
                }
            }
        }
        return islandCount;
    }

    private void sinkIsland(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Base case: out of bounds, or water, or already visited -> stop
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] != '1') {
            return;
        }

        grid[r][c] = '0'; // mark visited by "sinking" it (turning land into water)

        // Visit all 4 neighbors
        sinkIsland(grid, r + 1, c); // down
        sinkIsland(grid, r - 1, c); // up
        sinkIsland(grid, r, c + 1); // right
        sinkIsland(grid, r, c - 1); // left
    }
}