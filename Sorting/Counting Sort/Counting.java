import java.util.Arrays;

public class Counting {

    // Basic Counting Sort (no stability, no order preservation)
    public static int[] countingSort(int[] arr) {
        if (arr.length == 0) return new int[]{};

        int maxVal = Arrays.stream(arr).max().getAsInt();
        int[] count = new int[maxVal + 1];

        // Count each number
        for (int num : arr) {
            count[num]++;
        }

        // Build the sorted array
        int[] sortedArr = new int[arr.length];
        int index = 0;
        for (int num = 0; num < count.length; num++) {
            for (int freq = 0; freq < count[num]; freq++) {
                sortedArr[index++] = num;
            }
        }

        return sortedArr;
    }

    // Stable Counting Sort (preserves order of duplicates)
    public static int[] stableCountingSort(int[] arr) {
        if (arr.length == 0) return new int[]{};

        int maxVal = Arrays.stream(arr).max().getAsInt();
        int[] count = new int[maxVal + 1];

        // Count frequencies
        for (int num : arr) {
            count[num]++;
        }

        // Update count[i] to store actual positions
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] output = new int[arr.length];

        // Build the output array backwards (for stability)
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i];
            count[num]--;
            output[count[num]] = num;
        }

        return output;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};

        int[] basicSorted = countingSort(arr);
        System.out.println("Basic Counting Sort: " + Arrays.toString(basicSorted));

        int[] stableSorted = stableCountingSort(arr);
        System.out.println("Stable Counting Sort: " + Arrays.toString(stableSorted));
    }
}
