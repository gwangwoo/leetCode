class Solution {
    static int[] p;
    static int N;
    public static int[] findRedundantConnection(int[][] edges) {
        N = edges.length;
        p = new int[N+1];
        for (int i = 1 ; i <= N ; i++) {
            p[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (find(u) == find(v)) {
                return edge;
            }
            union(u, v);
        }
        return new int[0];
    }

    private static void union(int u, int v) {
        u = find(u);
        v = find(v);
        if (u != v) {
            p[u] = v;
        }
    }

    private static int find(int u) {
        if (p[u] == u) return u;
        return p[u] = find(p[u]);
    }
}