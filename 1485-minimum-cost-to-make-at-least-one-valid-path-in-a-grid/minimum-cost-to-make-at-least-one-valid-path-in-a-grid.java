

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

      
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

       
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerFirst(new int[]{0, 0}); 

        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            int r = curr[0];
            int c = curr[1];

            if (r == m - 1 && c == n - 1) {
                return dist[r][c];
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dirs[i][0];
                int nc = c + dirs[i][1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    
                    int weight = (grid[r][c] == i + 1) ? 0 : 1;

                    if (dist[r][c] + weight < dist[nr][nc]) {
                        dist[nr][nc] = dist[r][c] + weight;
                        
                       
                        if (weight == 0) {
                            deque.offerFirst(new int[]{nr, nc});
                        } else {
                            deque.offerLast(new int[]{nr, nc});
                        }
                    }
                }
            }
        }

        return dist[m - 1][n - 1];
    }
}