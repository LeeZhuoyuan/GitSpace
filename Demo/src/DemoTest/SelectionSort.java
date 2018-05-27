package DemoTest;

public class SelectionSort {
    public static int[] sort(int[] nums){
        int k = 0;
        int temp = 0;
        for(int i=0; i<nums.length-1; i++){
            k=i;
            for (int j=i; j<nums.length; j++){
                if(nums[j]<nums[k]){
                    k=j;
                }
                temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
            }
        }
        return nums;
    }
}
