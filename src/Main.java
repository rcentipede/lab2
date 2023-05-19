import java.util.Scanner;
import java.util.Random;

public class Main {
    private static final int MAX_SIZE = 20;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width, height;

        System.out.print("input width: ");
        width = scanner.nextInt();

        System.out.print("input height: ");
        height = scanner.nextInt();


        int[][] matrix;
        if (width <= MAX_SIZE && height <= MAX_SIZE) {
                matrix = generateRandomMatrix(width, height);





            System.out.println("matrix:");
            printMatrix(matrix);

            int min = findMinValue(matrix);
            int max = findMaxValue(matrix);
            double avg = calculateAverage(matrix);
            double avgg = calculategeom(matrix, width, height);

            System.out.println("min value: " + min);
            System.out.println("max value: " + max);
            System.out.println("arithmetic medium: " + avg);
            System.out.println("geometric medium: " + avgg);
        } else {
            System.out.println("matrix is too huge.");
        }
    }



    private static int[][] generateRandomMatrix(int width, int height) {
        int[][] matrix = new int[height][width];
        Random random = new Random();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
            }
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int findMinValue(int[][] matrix) {
        int min = Integer.MAX_VALUE;

        for (int[] row : matrix) {
            for (int element : row) {
                if (element < min) {
                    min = element;
                }
            }
        }

        return min;
    }

    private static int findMaxValue(int[][] matrix) {
        int max = Integer.MIN_VALUE;

        for (int[] row : matrix) {
            for (int element : row) {
                if (element > max) {
                    max = element;
                }
            }
        }

        return max;
    }

    private static double calculateAverage(int[][] matrix) {
        int sum = 0;
        int count = 0;

        for (int[] row : matrix) {
            for (int element : row) {
                sum += element;
                count++;
            }
        }

        return (double) sum / count;
    }
    private static double calculategeom(int[][] matrix, int width, int height) {
        int sum = 0;
        double product = 1.0;

        for (int[] row : matrix) {
            for (int element : row) {
                product *= element;

            }
        }


        return (double) Math.pow(product, 1.0 / (width * height));
    }
}