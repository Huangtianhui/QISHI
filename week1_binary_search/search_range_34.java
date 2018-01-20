
public class search_range_34 {

	public class Solution {
	    public int[] searchRangemethod1(int[] nums, int target) {
	         if (nums.length == 0) {
	             return new int[]{-1, -1};
	         }
	        
	         int start, end, mid;
	         int[] bound = new int[2]; 
	        
	         // search for left bound
	         start = 0; 
	         end = nums.length - 1;
	         while (start + 1 < end) {
	             mid = start + (end - start) / 2;
	             if (nums[mid] == target) {
	                 end = mid;
	             } else if (nums[mid] < target) {
	                 start = mid;
	             } else {
	                 end = mid;
	             }
	         }
	         if (nums[start] == target) {
	             bound[0] = start;
	         } else if (nums[end] == target) {
	             bound[0] = end;
	         } else {
	             bound[0] = bound[1] = -1;
	             return bound;
	         }
	        
	         // search for right bound
	         start = 0;
	         end = nums.length - 1;
	         while (start + 1 < end) {
	             mid = start + (end - start) / 2;
	             if (nums[mid] == target) {
	                 start = mid;
	             } else if (nums[mid] < target) {
	                 start = mid;
	             } else {
	                 end = mid;
	             }
	         }
	         if (nums[end] == target) {
	             bound[1] = end;
	         } else if (nums[start] == target) {
	             bound[1] = start;
	         } else {
	             bound[0] = bound[1] = -1;
	             return bound;
	         }
	        
	         return bound;
	     }
	        
	        public int[] searchRangemethod2(int[] nums, int target) {
	            int[] result={-1,-1};
	            int right=searchRightRange(nums,target,nums.length-1,0);
	            if (right<0 || nums[right]!=target) return result;
	            result[0]=searchLeftRange(nums,target,right,0);
	            result[1]=right;
	            return result;        
	        }
	    
	        public int searchRightRange(int[]nums,int target,int hi, int lo){
	            while(lo<=hi){
	                int mid=(hi+lo)/2;
	                if(nums[mid]>target) hi=mid-1;
	                else lo=mid+1;
	            }
	            return hi;
	        }
	    
	        public int searchLeftRange(int[] nums,int target,int hi,int lo){
	            while(lo<=hi){
	                int mid=(hi+lo)/2;
	                if (nums[mid]<target) lo=mid+1;
	                else hi=mid-1;
	            }
	            return lo;
	        }

	}

}
