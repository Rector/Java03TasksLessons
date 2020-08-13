package taskLesson07v2;

public class SpiralInMatrix {
    private static final int WIDTH = 4;
    private static final int HEIGHT = 4;

    private static int[][] matrix = new int[HEIGHT][WIDTH];
    private static int counter = 1;

    private static void fillMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 0;
            }
        }
    }


    private static void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%-5d", matrix[i][j]);
            }
        }
    }


    private static void fillHorizontalInMatrix(int[][] arr, int y) {
        for (int x = 0; x < WIDTH; x++) {
            if (arr[y][x] == 0) {
                arr[y][x] = counter;
                counter++;
            }
        }
    }


    private static void fillVerticalInMatrix(int[][] arr, int x) {
        for (int y = 0; y < HEIGHT; y++) {
            if (arr[y][x] == 0) {
                arr[y][x] = counter;
                counter++;
            }
        }
    }


    private static void fillReverseHorizontalInMatrix(int[][] arr, int y) {
        for (int x = WIDTH - 1; x >= 0; x--) {
            if (arr[y][x] == 0) {
                arr[y][x] = counter;
                counter++;
            }
        }
    }


    private static void fillReverseVerticalInMatrix(int[][] arr, int x) {
        for (int y = HEIGHT - 1; y >=0; y--) {
            if (arr[y][x] == 0) {
                arr[y][x] = counter;
                counter++;
            }
        }
    }

    public static void main(String[] args) {
        fillMatrix();
        printMatrix();
        System.out.println();

        fillHorizontalInMatrix(matrix, 0);
        fillVerticalInMatrix(matrix, WIDTH - 1);


        fillReverseHorizontalInMatrix(matrix, HEIGHT - 1);
        fillReverseVerticalInMatrix(matrix, 0);

        fillHorizontalInMatrix(matrix, 1);
        fillVerticalInMatrix(matrix, 2);

        fillReverseHorizontalInMatrix(matrix, 2);
        printMatrix();

    }
}
