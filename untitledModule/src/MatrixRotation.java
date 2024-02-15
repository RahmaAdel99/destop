import java.util.Arrays;

public class MatrixRotation {

        public static void main(String[] args) {
            int[][] matrix = {{1, 2}, {3, 4}};
            int[][] rotatedMatrix = Rotate(matrix);

            for (int[] row : rotatedMatrix) {
                System.out.println(Arrays.toString(row));
            }
        }

        public static int[][] Rotate(int[][] matrix) {
            int rows = matrix.length;
            int cols = matrix[0].length;

            int[][] rotatedMatrix = new int[cols][rows];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    rotatedMatrix[j][i] = matrix[i][j];
                }
            }

            return rotatedMatrix;
        }
    }
