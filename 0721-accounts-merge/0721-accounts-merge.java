class Solution {
    static int N;
    static int[] p;
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        N = accounts.size();
        p = new int[10001];
        Map<String, Integer> hm = new HashMap<>();
        Map<String, String> nameFromEmail = new HashMap<>();    //email : name
        int idx = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1 ; i < account.size(); i++) {
                String email = account.get(i);
                if (!hm.containsKey(email)) {
                    hm.put(email, ++idx);
                    p[idx] = idx;
                }
                nameFromEmail.put(email, name);
            }
        }
        for (List<String> account : accounts) {
            for (int i = 1 ; i < account.size(); i++) {
                String now = account.get(i);
                String next = account.get(i+1 == account.size() ? 1 : i+1);
                union(hm.get(now), hm.get(next));
            }

        }
        Map<Integer, List<String>> answerMap = new HashMap<>();
        hm.forEach((k, v) ->
                       answerMap.computeIfAbsent(find(v), key -> new ArrayList<>()).add(k)
        );
        List<List<String>> answer = new ArrayList<>();
        answerMap.forEach((k, v) -> {
            Collections.sort(v);
            String name = nameFromEmail.get(v.get(0));
            v.addFirst(name);
            answer.add(v);
        });
        return answer;
    }

    private static void union(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) {
            return;
        }
        p[u] = v;
    }

    private static int find(int u) {
        if (u == p[u]) return u;
        return p[u] = find(p[u]);
    }
}