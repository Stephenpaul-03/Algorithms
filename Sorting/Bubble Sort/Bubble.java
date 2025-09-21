import java.util.Scanner;

public class Bubble {

    public static int[] bubble(int[] arr) {
        int n = arr.length;
        boolean flag;
        for (int i = 0; i < n; i++) {
            flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        sc.nextLine();

        for (int i = 0; i < t; i++) {
            String[] input = sc.nextLine().split(" ");
            int[] arr = new int[input.length];
            for (int j = 0; j < input.length; j++) {
                arr[j] = Integer.parseInt(input[j]);
            }

            int[] sortedArr = bubble(arr);

            for (int num : sortedArr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
