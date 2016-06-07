import javax.swing.*;

public class Main {
    static JFrame menu = new JFrame();

    public static void main(String[] args) {
        int opcion = 0;
        JOptionPane.showMessageDialog(menu, "Bienvenido");

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(menu, "Elija una de las siguientes opciones:\n1. Multiplicar\n2. Sumar\n3. Restar\n4. Transpuesta\n5. Determinante\n6. Multiplicación por escalar\n7. Salir"));
                switch (opcion) {
                    case 1: {
                        int[] firstMatrixDimensions, secondMatrixDimensions;
                        int[][] firstMatrix, secondMatrix;

                        JOptionPane.showMessageDialog(menu, "Dimensiones primera matriz");
                        firstMatrixDimensions = getDimensions();

                        JOptionPane.showMessageDialog(menu, "Dimensiones segunda matriz");
                        secondMatrixDimensions = getDimensions();

                        if (firstMatrixDimensions[0] == secondMatrixDimensions[1]) {

                            JOptionPane.showMessageDialog(menu, "Primera matriz");
                            firstMatrix = getMatrix(firstMatrixDimensions);

                            JOptionPane.showMessageDialog(menu, "Segunda matriz");
                            secondMatrix = getMatrix(secondMatrixDimensions);

                            int[][] result = Operations.multiply(firstMatrix, secondMatrix);
                            printMatrix(result);
                        } else {
                            JOptionPane.showMessageDialog(menu, "Las matrices no se pueden operar");
                        }
                    }
                    break;
                    case 2: {
                        int[][] firstMatrix, secondMatrix;

                        JOptionPane.showMessageDialog(menu, "Primera matriz");
                        firstMatrix = getMatrix(new int[2]);

                        JOptionPane.showMessageDialog(menu, "Segunda matriz");
                        secondMatrix = getMatrix(new int[2]);

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
                        firstMatrix = getMatrix(new int[2]);

                        JOptionPane.showMessageDialog(menu, "Segunda matriz");
                        secondMatrix = getMatrix(new int[2]);

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
                        printMatrix(Operations.transpose(getMatrix(new int[2])));
                    }
                    break;
                    case 5: {
                        int[][] matrix;
                        JOptionPane.showMessageDialog(menu, "Matriz");
                        matrix = getMatrix(new int[2]);

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

                        printMatrix(Operations.multiply(getMatrix(new int[2]), scalar));
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

    private static int[] getDimensions() {
        int[] dimensions = new int[2];
        dimensions[0] = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Ingrese el número de filas"));
        dimensions[1] = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Ingrese el número de columnas"));
        return dimensions;
    }

    private static int[][] getMatrix(int[] dimensions) {
        int[][] result = new int[dimensions[0]][dimensions[1]];
        try {
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    boolean isNotInt = true;
                    while (isNotInt) {
                        try {
                            result[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de la matriz en (" + (i + 1) + ", " + (j + 1) + ")"));
                            isNotInt = false;
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(menu, "Solo puede ingresar valores númericos");
                        }
                    }
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
