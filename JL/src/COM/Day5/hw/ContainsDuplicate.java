package COM.Day5.hw;
import java.util.HashSet;
public class ContainsDuplicate {
        public static boolean containsDuplicate(int[] nums) {
            // Create a HashSet to store unique numbers
            HashSet<Integer> set = new HashSet<>();

            for (int num : nums) {
                // If number already exists in the set, it's a duplicate
                if (set.contains(num)) {
                    return true;
                }
                // Otherwise, add the number to the set
                set.add(num);
            }

            // If loop completes, no duplicates found
            return false;
        }

        public static void main(String[] args) {
            int[] nums1 = {1, 2, 3, 1};
            int[] nums2 = {1, 2, 3, 4};

            System.out.println("Array 1 has duplicate? " + containsDuplicate(nums1));
            System.out.println("Array 2 has duplicate? " + containsDuplicate(nums2));
        }
    }
