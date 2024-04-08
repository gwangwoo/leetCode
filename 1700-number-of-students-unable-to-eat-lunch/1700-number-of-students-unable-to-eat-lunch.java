class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> targetQ = new LinkedList<>();
        Arrays.stream(students).forEach(q::add);
        Arrays.stream(sandwiches).forEach(targetQ::add);
        int answer = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            int count = 0;
            while (size-- > 0) {
                int now = q.poll();
                if (now == targetQ.peek()) {
                    targetQ.poll();
                    answer++;
                    count = 0;
                    break;
                }
                q.add(now);
                count++;
            }
            if(count == q.size()) break;
        }
        return students.length - answer;
    }
}