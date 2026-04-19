class Solution {
    public static int openLock(String[] deadends, String target) {
        Set<String> visitedSet = new HashSet<>();
        Arrays.stream(deadends).forEach(str -> visitedSet.add(str));
        return bfs(visitedSet, target);
    }

    private static int bfs(Set<String> visitedSet, String target) {
        String start = "0000";
        if (visitedSet.contains(start)) {
            return -1;
        }
        if (start.equals(target)) {
            return 0;
        }
        visitedSet.add(start);
        Queue<String> q = new LinkedList<>();
        q.add(start);

        int answer = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String now = q.poll();
                for (int k = 0; k < 4; k++) {
                    for (int l = 0 ; l < 2 ; l++) {
                        String nextStr = "";
                        if (l % 2 == 0) {
                            nextStr = progress(now, k, 1);
                        } else {
                            nextStr = progress(now, k, -1);
                        }
                        if (nextStr.equals(target)) {
                            return answer + 1;
                        }
                        if (visitedSet.contains(nextStr)) {
                            continue;
                        }
                        visitedSet.add(nextStr);
                        q.add(nextStr);
                    }
                }
            }
            answer++;
        }
        if (!visitedSet.contains(target)) {
            return -1;
        }
        return answer;
    }

    private static String progress(String now, int index, int value) {
        char nextCh = ' ';
        if (value == 1) {
            nextCh = now.charAt(index) == '9' ? '0' : (char)((int)now.charAt(index) + 1);
        } else { // -1
            nextCh = now.charAt(index) == '0' ? '9' : (char)((int)now.charAt(index) - 1);
        }
        return now.substring(0, index) + nextCh + now.substring(index+1 , now.length());
    }
}