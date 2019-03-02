import java.io.IOException;
import java.util.Scanner;

public class CountingValleys {
    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int valleys = 0;
        int currentLevel = 0;
        int lastLevel = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'U') {
                currentLevel++;
            } else if (s.charAt(i) == 'D') {
                currentLevel--;
            }

            if (currentLevel == 0 && lastLevel == -1) {
                valleys++;
            }

            lastLevel = currentLevel;
        }

        return valleys;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        scanner.close();
    }
}
