public class Exponential {

    // Binary Search used by Exponential Search
    public static int binarySearch(int[] arr, int target, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // Exponential Search
    public static int exponentialSearch(int[] arr, int target) {
        if (arr.length == 0) return -1;

        if (arr[0] == target) return 0;

        int i = 1;
        while (i < arr.length && arr[i] <= target) {
            i *= 2;
        }

        return binarySearch(arr, target, i / 2, Math.min(i, arr.length - 1));
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40, 60, 80};
        int target = 10;

        int result = exponentialSearch(arr, target);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found.");
        }
    }
}
