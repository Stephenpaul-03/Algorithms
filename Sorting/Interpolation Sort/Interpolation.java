import java.util.Scanner;

public class Interpolation {

    public static int interpolationIdx(int[] arr, int low, int high, int key) {
        if (low <= high && key >= arr[low] && key <= arr[high]) {
            int pos = low + ((key - arr[low]) * (high - low)) / (arr[high] - arr[low]);

            if (arr[pos] == key) {
                return pos;
            } else if (arr[pos] < key) {
                return interpolationIdx(arr, pos + 1, high, key);
            } else {
                return interpolationIdx(arr, low, pos - 1, key);
            }
        }
        return -1;
    }

    public static void interpolationSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int key = arr[i];
            int index = interpolationIdx(arr, i + 1, n - 1, key);

            if (index != -1 && arr[index] != key) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); 

        for (int test = 0; test < t; test++) {
            System.out.print("Enter number of elements: ");
            int n = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Enter elements: ");
            String[] input = sc.nextLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            interpolationSort(arr);

            System.out.print("Sorted Array: ");
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
