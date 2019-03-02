import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class NewYearChaos {
    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int maxBribe = 2;
        int minBribes = 0;

        List<Integer> misplacedNumbers = new ArrayList<>();

        for (int i = 0; i < q.length; i++) {
            if (q[i] > i + 1 + maxBribe) {
                System.out.println("Too chaotic");
                return;
            }

            for (int j = 0 > q[i] - 2 ? 0 : q[i] - 2; j < i; j++) {
                if (q[j] > q[i]) minBribes++;
            }
        }

        System.out.println(minBribes);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
