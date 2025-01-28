class Solution {
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, 1, 0, -1};
    private static int N, M;
    public static int findMaxFish(int[][] grid) {
        N = grid.length;
        M = grid[0].length;
        boolean[][] visited = new boolean[N][M];
        int answer = 0;

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    int res = bfs(grid, visited, i, j);
                    answer = Math.max(answer, res);
                }
            }
        }
        return answer;
    }

    private static int bfs(int[][] grid, boolean[][] visited, int sr, int sc) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        visited[sr][sc] = true;
        int result = grid[sr][sc];

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int r = p.r;
            int c = p.c;
            for (int k = 0 ; k < 4 ; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || grid[nr][nc] == 0 || visited[nr][nc]) continue;
                q.add(new Pair(nr, nc));
                visited[nr][nc] = true;
                result += grid[nr][nc];
            }
        }
        return result;
    }

    static class Pair {
        int r, c;
        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}