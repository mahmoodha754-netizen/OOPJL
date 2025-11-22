package COM.Miniproject3;
    public class MiniAlgorithmToolkit {

        // Bubble Sort (short version)
        public static void bubbleSort(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++)
                for (int j = 0; j < arr.length - i - 1; j++)
                    if (arr[j] > arr[j + 1]) {
                        int t = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = t;
                    }
        }

        // Linear Search
        public static int linearSearch(int[] arr, int target) {
            for (int i = 0; i < arr.length; i++)
                if (arr[i] == target) return i;
            return -1;
        }

        // Timer
        public static long measure(Runnable task) {
            long start = System.currentTimeMillis();
            task.run();
            return System.currentTimeMillis() - start;
        }

        public static void main(String[] args) {

            int[] arr = {5, 3, 8, 1, 4};

            long time = measure(() -> bubbleSort(arr));

            System.out.println("Sorted Array:");
            for (int x : arr) System.out.print(x + " ");

            System.out.println("\nIndex of 4: " + linearSearch(arr, 4));
            System.out.println("Time Taken: " + time + " ms");
        }
    }
