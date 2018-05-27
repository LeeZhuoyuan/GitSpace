package DemoTest;

public class demo {

    public int binarySearch(int[] nums, int value){
        int middle = 0;
        int max = nums.length;
        int low = 0;
        while(true){
            middle = (max + low)/2;
            if(nums[middle] == value){
                return middle;
            }else if(low > max || value > nums[max - 1]){
                return -1;
            }else {
                if(nums[middle] > value){
                    max = middle - 1;
                }else {
                    low = middle + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        demo d = new demo();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(d.binarySearch(nums, 9));
    }
}
