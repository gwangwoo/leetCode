class Solution {
    public static int orangesRotting(int[][] map) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        Queue<Point> q = new LinkedList<>();
        int N = map.length;
        int M = map[0].length;
        boolean[][] visited = new boolean[N][M];
        boolean hasFreshOrange = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    q.add(new Point(i, j));
                    visited[i][j] = true;
                } else if(map[i][j] == 1) {
                    hasFreshOrange = true;
                }
            }
        }
        if (!hasFreshOrange) {
            return 0;
        }
        if (q.isEmpty()) {
            return -1;
        }
        int answer = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Point p = q.poll();
                int r = p.r;
                int c = p.c;
                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] != 1 || visited[nr][nc]) {
                        continue;
                    }
                    q.add(new Point(nr, nc));
                    visited[nr][nc] = true;
                }
            }
            answer++;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    return -1;
                }
            }
        }
        return answer-1;
    }


    static class Point {
        int r,c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}