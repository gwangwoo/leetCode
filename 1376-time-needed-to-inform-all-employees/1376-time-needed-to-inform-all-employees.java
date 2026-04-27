class Solution {
    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] mangerList = new ArrayList[n];
        boolean[] visited = new boolean[n];
        for (int i = 0 ; i < n ; i++) {
            mangerList[i] = new ArrayList<>();
        }
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] == -1) {
                continue;
            }
            mangerList[manager[i]].add(i);
        }
        visited[headID] = true;
        return dfs(mangerList, visited, informTime, headID, informTime[headID]);
    }

    private static int dfs(List[] neighborhood, boolean[] visited, int[] informTime, int now, int result) {
        int res = result;
        List<Integer> neighbors = neighborhood[now];
        for (int idx : neighbors) {
            if (visited[idx]) {
                continue;
            }
            visited[idx] = true;
            res = Math.max(res, dfs(neighborhood, visited, informTime, idx, result + informTime[idx]));
            visited[idx] = false;
        }
        return res;
    }
}