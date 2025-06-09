import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int food = scanner.nextInt();
        int l = scanner.nextInt();
        int r = scanner.nextInt();

        int[] energy = new int[food];
        for (int i = 0; i < food; i++) {
            energy[i] = scanner.nextInt();
        }

        int count = countMethods(energy, l, r);
        System.out.println(count);
        scanner.close();
    }

    public static int countMethods(int[] energy, int l, int r) {
        int maxSum = 0;

        for (int num : energy) {
            maxSum += num;
        }

        int[] dp = new int[maxSum + 1];
        dp[0] = 1;

        for (int num : energy) {
            for (int j = maxSum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        int count = 0;
        for (int i = l; i <= r && i <= maxSum; i++) {
            count += dp[i];
        }

        return count;
    }
}