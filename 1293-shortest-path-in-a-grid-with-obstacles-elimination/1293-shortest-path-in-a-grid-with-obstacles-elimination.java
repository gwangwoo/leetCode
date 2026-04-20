class Solution {
    public static int shortestPath(int[][] grid, int k) {
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        int N = grid.length;
        int M = grid[0].length;
        if (N == 1 && M == 1) {
            return 0;
        }
        Queue<Point> q = new LinkedList<>();
        int[][][] visited = new int[N][M][k+1];
        q.add(new Point(0,0,k));

        while(!q.isEmpty()) {
            Point p = q.poll();
            int r = p.r;
            int c = p.c;
            int cnt = p.k;
            for (int l = 0 ; l < 4 ; l++) {
                int nr = r + dr[l];
                int nc = c + dc[l];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    continue;
                }
                if (cnt > 0 && grid[nr][nc] > 0 && visited[nr][nc][cnt-1] == 0) {
                    q.add(new Point(nr,nc ,cnt-1));
                    visited[nr][nc][cnt-1] = visited[r][c][cnt] + 1;
                }
                if (grid[nr][nc] == 0 && visited[nr][nc][cnt] == 0) {
                    q.add(new Point(nr, nc, cnt));
                    visited[nr][nc][cnt] = visited[r][c][cnt] + 1;
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0 ; i < k+1 ; i++) {
            if (visited[N-1][M-1][i] == 0) {
                continue;
            }
            answer = Math.min(answer, visited[N-1][M-1][i]);
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    static class Point {
        int r,c,k;
        Point(int r,int c,int k) {
            this.r = r;
            this.c = c;
            this.k = k;
        }
    }
}