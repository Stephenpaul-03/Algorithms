public class Binary {

    // Iterative Binary Search
    public static int binarySearchIterative(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;  // Middle index

            if (arr[mid] == target) {
                return mid; // Target found
            } else if (arr[mid] < target) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }
        return -1; // Target not found
    }

    // Recursive Binary Search
    public static int binarySearchRecursive(int[] arr, int target, int low, int high) {
        if (low > high) {
            return -1; // Base case: not found
        }

        int mid = (low + high) / 2;

        if (arr[mid] == target) {
            return mid; // Target found
        } else if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, high); // Search right half
        } else {
            return binarySearchRecursive(arr, target, low, mid - 1); // Search left half
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40};
        int target = 10;

        // Iterative search
        int result1 = binarySearchIterative(arr, target);
        System.out.println("Iterative Binary Search: " + (result1 != -1 ? "Found at index " + result1 : "Not found"));

        // Recursive search
        int result2 = binarySearchRecursive(arr, target, 0, arr.length - 1);
        System.out.println("Recursive Binary Search: " + (result2 != -1 ? "Found at index " + result2 : "Not found"));
    }
}
