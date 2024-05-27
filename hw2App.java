package gr.aueb.cf.ch9;
public class hw2App {

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Ο πίνακας πρέπει να περιέχει τουλάχιστον ένα στοιχείο.");
        }

        int currentMax = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            if (currentMax > globalMax) {
                globalMax = currentMax;
            }
        }

        return globalMax;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum Sum Subarray: " + maxSubArray(nums));
    }
}
