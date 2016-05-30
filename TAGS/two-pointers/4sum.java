/*
 Given an array S of n integers, are there elements a , b , c , and d in S such
that a + b + c + d = target? Find all unique quadruplets in the array which
gives the sum of target.  Note:   Elements in a quadruplet ( a , b , c , d )
must be in non-descending order. (ie, a ≤ b ≤ c ≤ d )  The solution set must not
contain duplicate quadruplets.    For example, given array S = {1 0 -1 0 -2 2},
and target = 0.
A solution set is:
(-1,  0, 0, 1)
(-2, -1, 1, 2)
(-2,  0, 0, 2)   Subscribe to see which companies asked this question    Show
Tags   Array  Hash Table  Two Pointers     Show Similar Problems   (E) Two Sum
(M) 3Sum
*/

//first solution, exceed time limit
public class Solution {
    int len = 0;
    Map<Integer,Integer> map = new HashMap<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            map.put(nums[i],i);
        }
        return kSum(nums, target, 4, 0);
    }
   private ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if(index >= len) {
            return res;
        }
        if(k == 2) {
        	int i = index;
            for (i = index; i < len && nums[i] < (target+1)/2; i++){
                if(map.containsKey(target-nums[i])){
                	List<Integer> temp = new ArrayList<>();
                	temp.add(nums[i]);
                	temp.add(target-nums[i]);
                    res.add(temp);
                }
                while (i < len-1 && nums[i] == nums[i+1]) {
                    i++;
                }
            }
            if(i < len - 1 && nums[i] == target/2 && nums[i] == nums[i+1]){
            	List<Integer> temp = new ArrayList<>();
            	temp.add(nums[i]);
            	temp.add(nums[i+1]);
                res.add(temp);
            }
        } else{
            for (int i = index; i < len - k + 1; i++) {
                ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], k-1, i+1);
                if(temp != null){
                    for (List<Integer> t : temp) {
                        t.add(0, nums[i]);
                    }
                    res.addAll(temp);
                }
                while (i < len-1 && nums[i] == nums[i+1]) {
                    i++;
                }
            }
        }
        return res;
    }

}

//second solution accepted
public class Solution {
    int len = 0;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        len = nums.length;
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }
   private ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if(index >= len) {
            return res;
        }
        if(k == 2) {
        	int i = index, j = len - 1;
        	while(i < j) {
        	    if(target - nums[i] == nums[j]) {
        	    	List<Integer> temp = new ArrayList<>();
                	temp.add(nums[i]);
                	temp.add(target-nums[i]);
                    res.add(temp);
                    while(i<j && nums[i]==nums[i+1]) i++;
                    while(i<j && nums[j-1]==nums[j]) j--;
                    i++;
                    j--;
        	    } else if (target - nums[i] > nums[j]) {
        	        i++;
        	    } else {
        	        j--;
        	    }
        	}
        } else{
            for (int i = index; i < len - k + 1; i++) {
                ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], k-1, i+1);
                if(temp != null){
                    for (List<Integer> t : temp) {
                        t.add(0, nums[i]);
                    }
                    res.addAll(temp);
                }
                while (i < len-1 && nums[i] == nums[i+1]) {
                    i++;
                }
            }
        }
        return res;
    }
}