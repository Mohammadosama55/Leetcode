import java.util.*;

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        
        int[][] effort = new int[rows][cols];
        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        effort[0][0] = 0;

      
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, 0, 0});

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currentEffort = curr[0];
            int r = curr[1];
            int c = curr[2];

           
            if (r == rows - 1 && c == cols - 1) {
                return currentEffort;
            }

            
            if (currentEffort > effort[r][c]) {
                continue;
            }

         
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    int stepEffort = Math.abs(heights[r][c] - heights[nr][nc]);
                    int maxEffort = Math.max(currentEffort, stepEffort);

                    
                    if (maxEffort < effort[nr][nc]) {
                        effort[nr][nc] = maxEffort;
                        pq.offer(new int[]{maxEffort, nr, nc});
                    }
                }
            }
        }

        return 0;
    }
}