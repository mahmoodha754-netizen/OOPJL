package COM.Day6.hw;
import java.util.*;

    public class IntersectionOfTwoArrays {
        public static int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> set1 = new HashSet<>();
            HashSet<Integer> resultSet = new HashSet<>();

            // Add all elements from nums1 to set1
            for (int num : nums1) {
                set1.add(num);
            }

            // Check each element in nums2
            for (int num : nums2) {
                if (set1.contains(num)) {
                    resultSet.add(num);
                }
            }

            // Convert resultSet to array
            int[] result = new int[resultSet.size()];
            int i = 0;
            for (int num : resultSet) {
                result[i++] = num;
            }

            return result;
        }

        // Driver method
        public static void main(String[] args) {
            int[] nums1 = {1, 2, 2, 1};
            int[] nums2 = {2, 2};
            int[] output = intersection(nums1, nums2);

            System.out.print("Intersection: ");
            for (int num : output) {
                System.out.print(num + " ");
            }
        }
    }

