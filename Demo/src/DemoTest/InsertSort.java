package DemoTest;

public class InsertSort {
    public static int[] sort(int[] nums){
        int temp = 0;
        for(int i = 1; i<nums.length; i++){
            temp = nums[i];
            int j = i;
            while(j > 0 && nums[j-1]>temp){
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }
}
