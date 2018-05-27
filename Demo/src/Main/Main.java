package Main;

import DemoTest.InsertSort;

public class Main {

    public static void main(String[] args) {
        int[] nums = {3,2,4,1,6,2,4,7,9,8};
        //nums = BubbleSort.sort(nums);
        //nums = SelectionSort.sort(nums);
        nums = InsertSort.sort(nums);
        System.out.print("["+" ");
        for (int n: nums) {
            System.out.print(n+" ");
        }
        System.out.print("]");
        System.out.println(Math.round(-11.5));
        System.exit(0);
    }
}
