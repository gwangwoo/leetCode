class Solution {
    public static int findCircleNum(int[][] isConnected) {
        int N = isConnected.length;
        int[] root = new int[N];
        for (int i = 0 ; i < N ; i++) {
            root[i] = i;
        }

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                if (i == j) {
                    continue;
                }
                if (isConnected[i][j] == 1 || isConnected[j][i] == 1) {
                    union(root, i, j);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        Arrays.stream(root).forEach(p -> set.add(find(root, p)));
        return set.size();
    }

    public static void union(int[] root, int u, int v) {
        u = find(root, u);
        v = find(root, v);
        if (u == v) {
            return;
        }
        root[u] = v;
    }

    public static int find(int[] root, int u) {
        if (u == root[u]) {
            return u;
        }
        return root[u] = find(root, root[u]);
    }
}