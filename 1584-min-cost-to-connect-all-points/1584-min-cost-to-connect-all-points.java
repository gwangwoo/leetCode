class Solution {
        static int[] p;
    public static int minCostConnectPoints(int[][] points) {
        int N = points.length;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0 ; i < N-1 ; i++) {
            for (int j = i+1 ; j < N ; j++) {
                int weight = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                pq.add(new Edge(i,j, weight));
            }
        }
        p = new int[N];
        for (int i = 0 ; i < N ; i++) {
            p[i] = i;
        }

        int answer = 0;
        int answerCnt = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int u = find(edge.u);
            int v = find(edge.v);
            int weight = edge.weight;
            if (u == v) continue;
            union(u, v);
            answerCnt++;
            answer += weight;
            if (answerCnt == N-1) {
                return answer;
            }
        }
        return answer;
    }

    private static void union(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return;
        p[u] = v;
    }

    private static int find(int u) {
        if (u == p[u]) return u;
        return p[u] = find(p[u]);
    }

    static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge target) {
            return this.weight - target.weight;
        }
    }

}