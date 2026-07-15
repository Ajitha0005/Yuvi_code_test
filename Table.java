import java.util.Scanner;
import java.util.Random;
public class Table{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int size = 0;
        while (true) {
            System.out.print("Enter array size (for P×P array): ");
            if (sc.hasNextInt()) {
                size = sc.nextInt();
                if (size > 0) {
                    break;
                } 
                else {
                    System.out.println("Invalid input! Size must be greater than 0.");
                }
            } 
            else {
                System.out.println("Invalid input! Please enter an integer.");
                sc.next();
            }
        }
        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = (rand.nextInt(8) + 1) * 2;
            }
        }
        System.out.println("\nGenerated 2D array:\n");
        printTable(array, -1);
        int target;
        while (true) {
            System.out.print("\nEnter a number to highlight (even number 2-16): ");
            if (sc.hasNextInt()) {
                target = sc.nextInt();
                if (target >= 2 && target <= 16 && target % 2 == 0) {
                    break;
                } else {
                    System.out.println("Invalid input! Enter an even number between 2 and 16.");
                }
            } else {
                System.out.println("Invalid input! Please enter an integer.");
                sc.next();
            }
        }
        int count = 0;
        for (int[] row : array) {
            for (int value : row) {
                if (value == target)
                    count++;
            }
        }
        System.out.println("\nArray with " + target + " highlighted:\n");
        printTable(array, target);
        System.out.println("\nNumber " + target + " appeared " + count + " time(s).");

        sc.close();
    }
    public static void printTable(int[][] array, int highlight) {
        int size = array.length;
        System.out.print("    ");
        for (int i = 0; i < size; i++) {
            System.out.printf("%02d    ", i);
        }
        System.out.println();
        printBorder(size);
        for (int i = 0; i < size; i++) {
            System.out.printf("%02d |", i);
            for (int j = 0; j < size; j++) {
                if (array[i][j] == highlight) {
                    System.out.printf("[%2d]|", array[i][j]);
                } 
                else {
                    System.out.printf("%3d |", array[i][j]);
                }
            }
            System.out.println();
            printBorder(size);
        }
    }
    public static void printBorder(int size) {
        System.out.print("   +");
        for (int i = 0; i < size; i++) {
            System.out.print("----+");
        }
        System.out.println();
    }
}
