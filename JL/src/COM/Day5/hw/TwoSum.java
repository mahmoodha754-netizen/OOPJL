package COM.Day5.hw;
import java.util.HashMap;
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store number and its index
        HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];

                // Check if complement already exists in map
                if (map.containsKey(complement)) {
                    // Found the pair
                    return new int[] { map.get(complement), i };
                }

                // Otherwise, store current number and its index
                map.put(nums[i], i);
            }

            // If no pair found
            throw new IllegalArgumentException("No two sum solution");
        }

        public static void main(String[] args) {
            int[] nums = {2, 7, 11, 15};
            int target = 9;

            int[] result = twoSum(nums, target);
            System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        }
    }
