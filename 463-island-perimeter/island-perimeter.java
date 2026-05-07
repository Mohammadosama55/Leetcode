class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int perimeter = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                // If current cell is land
                if (grid[i][j] == 1) {

                    perimeter += 4;

                    // Check upper cell
                    if (i > 0 && grid[i - 1][j] == 1) {
                        perimeter--;
                    }

                    // Check lower cell
                    if (i < rows - 1 && grid[i + 1][j] == 1) {
                        perimeter--;
                    }

                    // Check left cell
                    if (j > 0 && grid[i][j - 1] == 1) {
                        perimeter--;
                    }

                    // Check right cell
                    if (j < cols - 1 && grid[i][j + 1] == 1) {
                        perimeter--;
                    }
                }
            }
        }

        return perimeter;
    }
}