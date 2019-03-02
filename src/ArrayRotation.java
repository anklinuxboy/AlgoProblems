import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int rot = sc.nextInt();

        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = sc.nextInt();
        }

        int[] result = rotateLeft(array, rot);
        for (int i = 0; i < num; i++) {
            System.out.print(result[i] + " ");
        }
    }

    private static int[] rotateLeft(int[] array, int rot) {
        int size = array.length;
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            int rotation = i - rot%size;
            if (rotation < 0) {
                rotation += size;
            }

            result[rotation] = array[i];
        }

        return result;
    }
}
