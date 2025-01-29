class Solution {
    static int[] parent;
    static int N;
    public static int[] findRedundantConnection(int[][] edges) {
        N = edges.length;
        parent = new int[N+1];
        for (int i = 1 ; i <= N ; i++) {
            parent[i] = i;
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
            parent[u] = v;
        }
    }

    private static int find(int v) {
        if (parent[v] == v) return v;
        return parent[v] = find(parent[v]);
    }
}