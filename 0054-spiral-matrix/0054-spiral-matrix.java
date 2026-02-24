import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] map) {
        int N = map.length;
        int M = map[0].length;
        int T = N*M;
        int[] dr = {0,1,0,-1}; // 오 아 왼 위
        int[] dc = {1,0,-1,0};
        List<Integer> answer = new ArrayList<>();
        int r = 0; int c = 0;
        boolean[][] visited = new boolean[N][M];
        answer.add(map[r][c]);
        visited[r][c] = true;
        while(T-- > 0) {
            for (int k = 0 ; k < 4 ; k++) {
                r += dr[k];
                c += dc[k];
                while(r >= 0 && r < N && c >= 0 && c < M && !visited[r][c]) {
                    visited[r][c] = true;
                    answer.add(map[r][c]);
                    r += dr[k];
                    c += dc[k];
                }
                r -= dr[k];
                c -= dc[k];
            }
        }
        return answer;
    }
}