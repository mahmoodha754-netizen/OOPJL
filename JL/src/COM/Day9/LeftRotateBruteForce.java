package Day9;
    public class LeftRotateBruteForce {

        // Rotate array left by 1 position
        public static void rotateOnce(int[] arr) {
            int temp = arr[0];
            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = temp;
        }

        // Rotate left by k times
        public static void leftRotate(int[] arr, int k) {
            k = k % arr.length; // avoid extra rotations
            for (int i = 0; i < k; i++) {
                rotateOnce(arr);
            }
        }

        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5};
            int k = 2;

            leftRotate(arr, k);

            for (int val : arr) {
                System.out.print(val + " ");
            }
        }
    }
