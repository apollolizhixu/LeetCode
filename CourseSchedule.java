public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Time: O(n), Space:O(n)
        if (numCourses <= 0 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        HashMap<Integer, List<Integer>> edge = new HashMap<Integer, List<Integer>>();
        int[] inDegree = new int[numCourses];
        for (int[] pair : prerequisites) {
            inDegree[pair[0]]++;
            if (!edge.containsKey(pair[1])) {
                edge.put(pair[1], new ArrayList<Integer>());
            }
            edge.get(pair[1]).add(pair[0]);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        int num = 0;
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            num++;
            List<Integer> list = edge.get(node);
            if (list != null) {
                for (int i : list) {
                    if (--inDegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        return num == numCourses;
    }
}