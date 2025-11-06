package COM.Day6.hw;
import java.util.HashMap;

    public class ValidAnagram {
        public static boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            HashMap<Character, Integer> map = new HashMap<>();

            // Count frequency of each character in s
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            // Decrease frequency based on t
            for (char c : t.toCharArray()) {
                if (!map.containsKey(c)) {
                    return false;
                }
                map.put(c, map.get(c) - 1);
                if (map.get(c) < 0) {
                    return false;
                }
            }

            return true;
        }

        public static void main(String[] args) {
            String s = "anagram";
            String t = "nagaram";
            System.out.println(isAnagram(s, t)); // true
        }
    }
