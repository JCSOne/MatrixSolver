public class Operations {
    public static int[][] multiply(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length == secondMatrix[0].length) {
            int[][] result = new int[firstMatrix.length][secondMatrix[0].length];
            for (int i = 0; i < firstMatrix.length; i++) {
                for (int j = 0; j < secondMatrix[0].length; j++) {
                    for (int k = 0; k < firstMatrix[0].length; k++) {
                        result[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                    }
                }
            }
            return result;
        }
        return null;
    }

    public static int[][] multiply(int[][] matrix, int scalar) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[i][j] = matrix[i][j] * scalar;
            }
        }
        return result;
    }

    public static int[][] add(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length == secondMatrix.length && firstMatrix[0].length == secondMatrix[0].length) {
            int[][] result = new int[firstMatrix.length][firstMatrix[0].length];
            for (int i = 0; i < firstMatrix.length; i++) {
                for (int j = 0; j < firstMatrix[0].length; j++) {
                    result[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
                }
            }
            return result;
        }
        return null;
    }

    public static int[][] subtract(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length == secondMatrix.length && firstMatrix[0].length == secondMatrix[0].length) {
            int[][] result = new int[firstMatrix.length][firstMatrix[0].length];
            for (int i = 0; i < firstMatrix.length; i++) {
                for (int j = 0; j < firstMatrix[0].length; j++) {
                    result[i][j] = firstMatrix[i][j] - secondMatrix[i][j];
                }
            }
            return result;
        }
        return null;
    }

    public static int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    public static int determinant(int[][] matrix) {
        int result = 0, sign = 1, p, q;

        if (matrix.length == 1) {
            result = matrix[0][0];
        } else {
            int smallMatrix[][] = new int[matrix.length - 1][matrix.length - 1];
            for (int i = 0; i < matrix.length; i++) {
                p = 0;
                q = 0;
                for (int j = 1; j < matrix.length; j++) {
                    for (int k = 0; k < matrix.length; k++) {
                        if (k != i) {
                            smallMatrix[p][q++] = matrix[j][k];
                            if (q % (matrix.length - 1) == 0) {
                                p++;
                                q = 0;
                            }
                        }
                    }
                }
                result = result + matrix[0][i] * determinant(smallMatrix) * sign;
                sign = -sign;
            }
        }
        return result;
    }
}
