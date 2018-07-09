class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] grid = new int[numCourses][numCourses];
        int[] degree = new int[numCourses];
        int count = 0;
        for(int i = 0;i<prerequisites.length;i++){
            int high =prerequisites[i][0];
            int low = prerequisites[i][1];
            grid[low][high] =1;
            degree[high]++;            
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<numCourses;i++){
            if(degree[i] == 0) queue.add(i);
        }
        //BST add the course when its degree is 0, retrieve the top, minus the degree of the higher_level course
        while(!queue.isEmpty()){
            int top = queue.poll();
            count ++;
            for(int i = 0;i<numCourses;i++){
                if(grid[top][i]==1){
                    if(--degree[i]==0) queue.add(i);
                }
            }
        }
        return count==numCourses;
    }
}