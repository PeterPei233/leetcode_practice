import java.util.*;

public class test2 {
	    public int[] twoSum(int[] nums, int target) {
	        int[] result = new int[2];
	        HashMap<Integer,List<Integer>> map = new HashMap<>();
	        int j = 0;
	        for(int i : nums ){
	        		if(!map.containsKey(i)) {
	        			List<Integer> s = new ArrayList<>();
	        			s.add(j++);
	        			map.put(i,s);
	        		}
	        		else map.get(i).add(j++);
	        }
	        for(Integer k:map.keySet()){
	            if(map.get(target-k)!=null){
	            		if(k+k!=target) {
		                result[0] = map.get(k).get(0);
		                result[1] = map.get(target-k).get(0);
		                return result;
	            		}
	            		if(map.get(k).size()>1) {
	            			result[0] = map.get(k).get(0);
	            			result[1] = map.get(k).get(1);
	            			return result;
	            		}
	            }
	        }
	        throw new IllegalArgumentException("No two sum solution");
	    }
	    public static void main(String[] args) {
	    	test2 t = new test2();
	    	int[] a = {3,3};
	    	System.out.println(Arrays.toString(t.twoSum(a,6)));    	
	    }
	}