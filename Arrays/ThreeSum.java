import java.util.*;

public class ThreeSum{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] nums = new int[size];
        
        for(int i=0;i<size;i++){
            nums[i] = input.nextInt();
        }
        
        List<List<Integer>> result = new Solution().threeSum(nums);
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i == 0 || nums[i] != nums[i-1]){
                temp = this.twoSumTwo(nums, i, -nums[i]);
                result.addAll(temp);
            }
        }
        return result;
    }
    //With hasMap 
    public List<List<Integer>> twoSum(int[] nums, int start, int target){
        Map<Integer, Integer> hashMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=start+1; i<nums.length;i++){
            int complement = target - nums[i];
            List<Integer> temp = new ArrayList<>();
            if(hashMap.containsKey(complement)){
                temp.add(nums[start]);
                temp.add(nums[i]);
                temp.add(nums[hashMap.get(complement)]);
                result.add(temp);
                hashMap.remove(complement);
                while(i+1<nums.length && nums[i]==nums[i+1]){
                    i++;               
                }
            }else{
                hashMap.put(nums[i], i);
            }
        }
        return result;
    }
    //With out hasMap
    public List<List<Integer>> twoSumTwo(int[] nums, int start, int target){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int low = start+1; 
        int high = nums.length-1;
        while(low < high){
            List<Integer> temp = new ArrayList<>();
            int sum = nums[low]+nums[high];
            if(target < sum){
                high--;
            }else if(target > sum){
                low++;
            }else{
                temp.add(nums[start]);
                temp.add(nums[low]);
                temp.add(nums[high]);
                result.add(temp);
                low++;high--;
                while(low < high && nums[low] == nums[low-1]){
                    low++;
                }
            }
        }
        return result;
    }
}
