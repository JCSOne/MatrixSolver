import javax.swing.*;

/**
 * Created by JCS on 19/04/16.
 */
public class Main {
    static JFrame menu = new JFrame();

    public static void main(String[] args) {
        int opcion = 0;
        JOptionPane.showMessageDialog(menu, "Bienvenido");

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(menu, "Elija una de las siguientes opciones:\n1. Multiplicar\n2. Sumar\n3. Restar\n4. Transpuesta\n5. Determinante\n6. Multiplicación por escalar\n7. Salir"));
                int n1 = 0;
                int n2 = 0;
                switch (opcion) {
                    case 1: {
                        int[][] firstMatrix, secondMatrix;

                        JOptionPane.showMessageDialog(menu, "Primera matriz");
                        firstMatrix = GetMatrix();

                        JOptionPane.showMessageDialog(menu, "Segunda matriz");
                        secondMatrix = GetMatrix();

                        PrintMatrix(Multiply(firstMatrix, secondMatrix));
                    }
                    break;
                    case 2: {
                        int[][] firstMatrix, secondMatrix;

                        JOptionPane.showMessageDialog(menu, "Primera matriz");
                        firstMatrix = GetMatrix();

                        JOptionPane.showMessageDialog(menu, "Segunda matriz");
                        secondMatrix = GetMatrix();

                        PrintMatrix(Add(firstMatrix, secondMatrix));
                    }
                    break;
                    case 3: {
                        int[][] firstMatrix, secondMatrix;
                        JOptionPane.showMessageDialog(menu, "Primera matriz");
                        firstMatrix = GetMatrix();

                        JOptionPane.showMessageDialog(menu, "Segunda matriz");
                        secondMatrix = GetMatrix();

                        PrintMatrix(Substract(firstMatrix, secondMatrix));
                    }
                    break;
                    case 4: {
                        JOptionPane.showMessageDialog(menu, "Matriz");
                        PrintMatrix(Transpose(GetMatrix()));
                    }
                    break;
                    case 5: {
                        int[][] matrix;
                        JOptionPane.showMessageDialog(menu, "Matriz");
                        matrix = GetMatrix();

                        JOptionPane.showMessageDialog(menu, "El determinante de la matriz es: " + Determinant(matrix));
                    }
                    break;
                    case 6: {
                        int scalar = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Ingrese el valor del escalar"));
                        JOptionPane.showMessageDialog(menu, "Matriz");

                        PrintMatrix(Multiply(GetMatrix(), scalar));
                    }
                    break;
                    case 7:
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(menu, "Opción inconrecta, por favor ingrese una opción valida");
                        break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(menu, "Algo salio mal");
            }
        } while (opcion != 6);
    }

    private static int[][] GetMatrix() {
        int x, y;
        x = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Ingrese el número de filas"));
        y = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Ingrese el número de columnas"));

        int[][] result = new int[x][y];
        try {

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    result[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de la matriz en (" + (i + 1) + ", " + (j + 1) + ")"));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(menu, "Solo puede ingresar valores númericos");
            return new int[0][0];
        }
        return result;
    }

    private static int[][] Multiply(int[][] firstMatrix, int[][] secondMatrix) {
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

    private static int[][] Multiply(int[][] matrix, int scalar) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[i][j] = matrix[i][j] * scalar;
            }
        }
        return result;
    }

    private static int[][] Add(int[][] firstMatrix, int[][] secondMatrix) {
        int[][] result = new int[firstMatrix.length][firstMatrix[0].length];
        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[0].length; j++) {
                result[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
            }
        }
        return result;
    }

    private static int[][] Substract(int[][] firstMatrix, int[][] secondMatrix) {
        int[][] result = new int[firstMatrix.length][firstMatrix[0].length];
        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[0].length; j++) {
                result[i][j] = firstMatrix[i][j] - secondMatrix[i][j];
            }
        }
        return result;
    }

    private static int[][] Transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    private static int Determinant(int[][] matrix) {
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
                result = result + matrix[0][i] * Determinant(smallMatrix) * sign;
                sign = -sign;
            }
        }
        return result;
    }

    private static void PrintMatrix(int[][] matrix) {
        String result = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result += matrix[i][j] + "\t";
            }
            result += "\n";
        }
        JOptionPane.showMessageDialog(menu, new JTextArea(result));
    }
}
