class Solution {
static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int N,M;
    public static int numIslands(char[][] grid) {
        N = grid.length;
        M = grid[0].length;
        boolean[][] visited = new boolean[N][M];

        int answer = 0;
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    answer += dfs(grid, visited, i, j);
                }
            }
        }

        return answer;
    }

    private static int dfs(char[][] grid, boolean[][] visited, int i, int j) {
        visited[i][j] = true;

        for (int k = 0 ; k < 4 ; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];
            if (nr < 0 || nr >= N || nc < 0 || nc >= M || grid[nr][nc] == '0' || visited[nr][nc]) {
                continue;
            }
            dfs(grid, visited, nr, nc);
        }
        return 1;
    }
}
