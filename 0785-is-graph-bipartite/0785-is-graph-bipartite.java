class Solution {
    private static ArrayList<Integer>[] arl;
    private static int N;
    public static void main(String[] args) {
        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(isBipartite(graph));
    }

    public static boolean isBipartite(int[][] graph) {
        N = graph.length;
        arl = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            arl[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0 ; j < graph[i].length; j++) {
                arl[i].add(graph[i][j]);
                arl[graph[i][j]].add(i);
            }
        }

        return bfs(0);
    }

    private static boolean bfs(int s) {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[N];
        q.add(s);
        visited[s] = 1;

        while (!q.isEmpty()) {
            int p = q.poll();
            for (int y : arl[p]) {
                if (visited[y] == visited[p]) {
                    return false;
                }
                if (visited[y] != 0) {
                    continue;
                }
                q.add(y);
                visited[y] = visited[p] + 1;
            }
        }
        return true;
    }
}
