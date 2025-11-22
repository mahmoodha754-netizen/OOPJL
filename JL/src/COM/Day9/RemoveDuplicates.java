package Day9;

public class RemoveDuplicates {
    public static int[] removeDuplicates(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        int j = 0;

        for (int i = 0; i < n; i++) {
            boolean found = false;

            // Check if arr[i] already exists in temp[]
            for (int k = 0; k < j; k++) {
                if (arr[i] == temp[k]) {
                    found = true;
                    break;
                }
            }

            // If not duplicate, add to temp
            if (!found) {
                temp[j++] = arr[i];
            }
        }

        // Create result array with exact size j
        int[] result = new int[j];
        for (int i = 0; i < j; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 5};

        int[] unique = removeDuplicates(arr);

        for (int x : unique) {
            System.out.print(x + " ");
        }
    }
}