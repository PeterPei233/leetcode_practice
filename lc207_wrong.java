class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> res= new HashMap<>();
        boolean[] visited = new boolean[numCourses];
         for(int i = 0; i< prerequisites.length;i++){
            if(res.containsKey((prerequisites[i][1]))) {
            res.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
            else{
            List<Integer> cur = new ArrayList<>();
            cur.add(prerequisites[i][0]);
            res.put(prerequisites[i][1],cur);
            }
         }
        for(int i = 0;i<numCourses;i++){
            DFS(res,visited,i);
        }
        void DFS(Map<Integer, List<Integer>> res, boolean[] visited,int begin){
            if(visited[begin]) return;
            else{
                if(!res.containsKey(i)){
                    visited[begin] = true;
                    return;
                }
            }
        }
    }
}