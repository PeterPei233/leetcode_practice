class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> grid= new HashMap<>();
        int[] degree = new int[numCourses];
        int count = 0;
        for(int i = 0;i<prerequisites.length;i++){
            int high =prerequisites[i][0];
            int low = prerequisites[i][1];
            degree[high]++;
            if(grid.containsKey(low)){
                grid.get(low).add(high);
            }
            else{
                List<Integer> list = new ArrayList<>();
                list.add(high);
                grid.put(low,list);
            }                      
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<numCourses;i++){
            if(degree[i] == 0) queue.add(i);
        }
        //BST add the course when its degree is 0, retrieve the top, minus the degree of the higher_level course
        while(!queue.isEmpty()){
            int top = queue.poll();
            count ++;
            if(grid.containsKey(top)){
                for(Integer i:grid.get(top)){
                  if(--degree[i]==0) queue.add(i);
                }
            }
        }
        return count==numCourses;
    }
}