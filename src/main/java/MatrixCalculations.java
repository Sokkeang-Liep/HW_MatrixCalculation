import java.util.Scanner;

public class MatrixCalculations {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) { // Home menu loop
            System.out.println("""
                 ========== WELCOME TO MATRIX CALCULATION ========
                 |           1. Matrix Calculation 2D            |
                 |           2. Matrix Calculation 3D            |
                 =================================================           
                """);
            System.out.print("Please choose Matrix Option: ");
            int option = input.nextInt();
            System.out.println();

            if (option == 1) {
                System.out.println("""
                     ====================WELCOME TO===================
                     |              2D Matrix Calculation            |
                     =================================================          
                    """);
                handle2DMatrix(input);

            } else if (option == 2) {
                System.out.println("""
                     ====================WELCOME TO===================
                     |              3D Matrix Calculation            |
                     =================================================         
                    """);
                handle3DMatrix(input);
            } else {
                System.out.println("Invalid selection!");
            }
        }
    }

    // 2D Matrix Calculation
    static void handle2DMatrix(Scanner input) {
        int[][] matA = new int[2][2];
        int[][] matB = new int[2][2];
        int[][] resultMat = new int[2][2];

        System.out.println("\n===============Please Enter Matrix A==============");
        readMatrix2D(input, matA);

        System.out.println("\n===============Please Enter Matrix B===============");
        readMatrix2D(input, matB);

        while (true) {
            System.out.println("\n====================2D MATRIX====================");
            System.out.println("Matrix A:");
            showMatrix2D(matA);
            System.out.println("Matrix B:");
            showMatrix2D(matB);

            System.out.println("""
                 ============MATRIX OPERATIONS MENU===============  
                 |            1 -> Addition                      |
                 |            2 -> Subtraction                   |
                 |            3 -> Multiplication                |
                 |            4 -> Transpose                     |
                 |            5 -> Back to Home                  |
                 |            0 -> Exit Program                  |
                 =================================================          
                """);
            System.out.print("Please choose Matrix Operation: ");
            int choice = input.nextInt();

            if (choice == 0) {
                System.out.println("Program ended.");
                System.exit(0);
            }
            if (choice == 5) {
                System.out.println("Returning to Home Menu...");
                break;
            }

            switch (choice) {
                case 1 -> {
                    for (int i = 0; i < 2; i++)
                        for (int j = 0; j < 2; j++)
                            resultMat[i][j] = matA[i][j] + matB[i][j];
                    System.out.println("\nAddition Matrix (A+B) Result:");
                    showMatrix2D(resultMat);
                }
                case 2 -> {
                    for (int i = 0; i < 2; i++)
                        for (int j = 0; j < 2; j++)
                            resultMat[i][j] = matA[i][j] - matB[i][j];
                    System.out.println("\nSubtraction Matrix (A-B) Result:");
                    showMatrix2D(resultMat);
                }
                case 3 -> {
                    for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < 2; j++) {
                            resultMat[i][j] = 0;
                            for (int k = 0; k < 2; k++) {
                                resultMat[i][j] += matA[i][k] * matB[k][j];
                            }
                        }
                    }
                    System.out.println("\nMultiplication Matrix (A*B) Result:");
                    showMatrix2D(resultMat);
                }
                case 4 -> {
                    int[][] transA = new int[2][2];
                    int[][] transB = new int[2][2];
                    for (int i = 0; i < 2; i++)
                        for (int j = 0; j < 2; j++) {
                            transA[j][i] = matA[i][j];
                            transB[j][i] = matB[i][j];
                        }
                    System.out.println("\nTranspose of Matrix A:");
                    showMatrix2D(transA);
                    System.out.println("\nTranspose of Matrix B:");
                    showMatrix2D(transB);
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    static void readMatrix2D(Scanner input, int[][] matrix) {
        for (int r = 0; r < 2; r++)
            for (int c = 0; c < 2; c++) {
                System.out.print("Enter [" + r + "][" + c + "]: ");
                matrix[r][c] = input.nextInt();
            }
    }

    static void showMatrix2D(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + "\t");
            System.out.println();
        }
    }

    // 3D Matrix Calculation
    static void handle3DMatrix(Scanner input) {
        int[][][] cubeA = new int[2][2][2];
        int[][][] cubeB = new int[2][2][2];
        int[][][] result = new int[2][2][2];

        System.out.println("\n===============Please Enter Matrix A===============");
        readMatrix3D(input, cubeA);

        System.out.println("\n===============Please Enter Matrix B===============");
        readMatrix3D(input, cubeB);

        while (true) {
            System.out.println("\n=====================3D MATRIX=====================");
            System.out.println("Matrix A:");
            showMatrix3D(cubeA, "Original A");
            System.out.println("Matrix B:");
            showMatrix3D(cubeB, "Original B");

            System.out.println("""
             ============MATRIX OPERATIONS MENU===============  
             |            1 -> Addition                      |
             |            2 -> Subtraction                   |
             |            3 -> Multiplication                |
             |            4 -> Transpose                     |
             |            5 -> Back to Home                  |
             |            0 -> Exit Program                  |
             =================================================          
            """);
            System.out.print("Please choose Matrix Operation: ");
            int option = input.nextInt();

            if (option == 0) {
                System.out.println("Program ended.");
                System.exit(0);
            }
            if (option == 5) {
                System.out.println("Returning to Home Menu....");
                break;
            }

            switch (option) {
                case 1 -> {
                    for (int l = 0; l < 2; l++)
                        for (int i = 0; i < 2; i++)
                            for (int j = 0; j < 2; j++)
                                result[l][i][j] = cubeA[l][i][j] + cubeB[l][i][j];
                    showMatrix3D(result, "Addition");
                }
                case 2 -> {
                    for (int l = 0; l < 2; l++)
                        for (int i = 0; i < 2; i++)
                            for (int j = 0; j < 2; j++)
                                result[l][i][j] = cubeA[l][i][j] - cubeB[l][i][j];
                    showMatrix3D(result, "Subtraction");
                }
                case 3 -> {
                    for (int l = 0; l < 2; l++)
                        for (int i = 0; i < 2; i++)
                            for (int j = 0; j < 2; j++) {
                                result[l][i][j] = 0;
                                for (int k = 0; k < 2; k++)
                                    result[l][i][j] += cubeA[l][i][k] * cubeB[l][k][j];
                            }
                    showMatrix3D(result, "Multiplication");
                }
                case 4 -> {
                    int[][][] transA = new int[2][2][2];
                    int[][][] transB = new int[2][2][2];

                    // Transpose cubeA and cubeB
                    for (int l = 0; l < 2; l++) {
                        for (int i = 0; i < 2; i++) {
                            for (int j = 0; j < 2; j++) {
                                transA[l][j][i] = cubeA[l][i][j];
                                transB[l][j][i] = cubeB[l][i][j];
                            }
                        }
                    }

                    System.out.println("\nTranspose of A:");
                    showMatrix3D(transA, "Transpose");

                    System.out.println("\nTranspose of B:");
                    showMatrix3D(transB, "Transpose");
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    static void readMatrix3D(Scanner input, int[][][] matrix) {
        for (int l = 0; l < 2; l++) {
            System.out.println("Layer " + l);
            for (int i = 0; i < 2; i++)
                for (int j = 0; j < 2; j++) {
                    System.out.print("Enter [" + l + "][" + i + "][" + j + "]: ");
                    matrix[l][i][j] = input.nextInt();
                }
        }
    }
    static void showMatrix3D(int[][][] matrix, String operation) {
        for (int l = 0; l < 2; l++) {
            System.out.println("The Result of " + operation + " - Layer " + l + ":");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++)
                    System.out.print(matrix[l][i][j] + "\t");
                System.out.println();
            }
        }
    }
}