class Solution {
    private static ArrayList<Integer> arl[];
    private static int N;
    private static boolean[] visited;

    public static int magnificentSets(int n, int[][] edges) {
        N = n;
        arl = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            arl[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            arl[u].add(v);
            arl[v].add(u);
        }
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int sum = 1;
            if (visited[i]) {
                continue;
            }
            Set<Integer> component = getComponent(i);
            for (int j : component) {
                int res = bfs(j);
                if (res == -1) {
                    return -1;
                }
                sum = Math.max(sum, res);
            }
            answer += sum;
        }
        return answer;
    }

    private static Set<Integer> getComponent(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i] = true;
        Set<Integer> components = new HashSet<>();
        while(!q.isEmpty()) {
            int p = q.poll();
            for (int j : arl[p]) {
                if (visited[j]) {
                    continue;
                }
                components.add(j);
                visited[j] = true;
                q.add(j);
            }
        }
        return components;
    }

    private static int bfs(int s) {
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[N + 1];
        int maxValue = 0;
        dist[s] = 1;
        q.add(s);
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            level++;
            while(size-- > 0) {
                int p = q.poll();
                for (int next : arl[p]) {
                    if (dist[next] == level) {
                        return -1;
                    }
                    if (dist[next] > 0) {
                        continue;
                    }
                    dist[next] = dist[p] + 1;
                    maxValue = Math.max(dist[next], maxValue);
                    q.add(next);
                }
            }
        }
        return maxValue;
    }
}