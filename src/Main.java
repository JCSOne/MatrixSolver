import javax.swing.*;

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
                        firstMatrix = getMatrix();

                        JOptionPane.showMessageDialog(menu, "Segunda matriz");
                        secondMatrix = getMatrix();

                        int[][] result = Operations.multiply(firstMatrix, secondMatrix);
                        if (result != null) {
                            printMatrix(result);
                        } else {
                            JOptionPane.showMessageDialog(menu, "Las matrices no se pueden operar");
                        }
                    }
                    break;
                    case 2: {
                        int[][] firstMatrix, secondMatrix;

                        JOptionPane.showMessageDialog(menu, "Primera matriz");
                        firstMatrix = getMatrix();

                        JOptionPane.showMessageDialog(menu, "Segunda matriz");
                        secondMatrix = getMatrix();

                        int[][] result = Operations.add(firstMatrix, secondMatrix);
                        if (result != null) {
                            printMatrix(result);
                        } else {
                            JOptionPane.showMessageDialog(menu, "Las matrices no se pueden operar");
                        }
                    }
                    break;
                    case 3: {
                        int[][] firstMatrix, secondMatrix;
                        JOptionPane.showMessageDialog(menu, "Primera matriz");
                        firstMatrix = getMatrix();

                        JOptionPane.showMessageDialog(menu, "Segunda matriz");
                        secondMatrix = getMatrix();

                        int[][] result = Operations.subtract(firstMatrix, secondMatrix);
                        if (result != null) {
                            printMatrix(result);
                        } else {
                            JOptionPane.showMessageDialog(menu, "Las matrices no se pueden operar");
                        }
                    }
                    break;
                    case 4: {
                        JOptionPane.showMessageDialog(menu, "Matriz");
                        printMatrix(Operations.transpose(getMatrix()));
                    }
                    break;
                    case 5: {
                        int[][] matrix;
                        JOptionPane.showMessageDialog(menu, "Matriz");
                        matrix = getMatrix();

                        if (matrix.length == matrix[0].length) {
                            JOptionPane.showMessageDialog(menu, "El determinante de la matriz es: " + Operations.determinant(matrix));
                        } else {
                            JOptionPane.showMessageDialog(menu, "La matriz no es una matriz cuadrada");
                        }
                    }
                    break;
                    case 6: {
                        int scalar = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Ingrese el valor del escalar"));
                        JOptionPane.showMessageDialog(menu, "Matriz");

                        printMatrix(Operations.multiply(getMatrix(), scalar));
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

    private static int[][] getMatrix() {
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

    private static void printMatrix(int[][] matrix) {
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
