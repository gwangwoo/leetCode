class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        Queue<Point> q = new LinkedList<>();
        int N = mat.length;
        int M = mat[0].length;
        int[][] visited = new int[N][M];
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Point(i,j));
                }
            }
        }
        while(!q.isEmpty()) {
            Point p = q.poll();
            int r = p.r;
            int c = p.c;
            for (int k = 0 ; k < 4 ; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] != 0 || mat[nr][nc] == 0) {
                    continue;
                }
                q.add(new Point(nr,nc));
                visited[nr][nc] = visited[r][c] + 1;
            }
        }
        return visited;
    }

    static class Point {
        int r,c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}