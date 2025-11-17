package Day9;
    public class LeftRotateRecursive {

        // Rotate array left by 1 position
        public static void rotateRecursive(int[] arr, int k) {
            if (k == 0)
                return;

            int temp = arr[0];
            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = temp;

            rotateRecursive(arr, k - 1); // recursive call
        }

        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5};
            int k = 2;

            rotateRecursive(arr, k);

            for (int val : arr) {
                System.out.print(val + " ");
            }
        }
    }
