[4/5/2026 10:55 PM] Taing Sengkim: package co.istad.y2;

import java.util.Scanner;

public class MainApp {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Array Mode:");
        System.out.println("1. 2D Matrix Operations");
        System.out.println("2. 3D Matrix Operations");
        int mode = sc.nextInt();

        if (mode == 1) {
            run2D(sc);
        } else if (mode == 2) {
            run3D(sc);
        } else {
            System.out.println("Invalid mode!");
        }
    }
    static void run2D(Scanner sc) {
        int[][] A = new int[2][2];
        int[][] B = new int[2][2];
        int[][] result = new int[2][2];

        System.out.println("Enter Matrix A (2D):");
        inputMatrix2D(sc, A);
        System.out.println("Enter Matrix B (2D):");
        inputMatrix2D(sc, B);

        do {
            System.out.println("====================================");
            System.out.println("\nChoose Operation (2D):");
            printMatrix2D(A);
            printMatrix2D(B);
            System.out.println("====================================");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Transpose (Matrix A)");
            System.out.println("0. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (int i = 0; i < 2; i++)
                        for (int j = 0; j < 2; j++)
                            result[i][j] = A[i][j] + B[i][j];
                    printMatrix2D(result);
                    System.out.println("Enter to continue...");
                    sc.nextLine();
                    sc.nextLine();
                    break;
                case 2:
                    for (int i = 0; i < 2; i++)
                        for (int j = 0; j < 2; j++)
                            result[i][j] = A[i][j] - B[i][j];
                    printMatrix2D(result);
                    System.out.println("Enter to continue...");
                    sc.nextLine();
                    sc.nextLine();
                    break;
                case 3:
                    for (int i = 0; i < 2; i++)
                        for (int j = 0; j < 2; j++) {
                            result[i][j] = 0;
                            for (int k = 0; k < 2; k++)
                                result[i][j] += A[i][k] * B[k][j];
                        }
                    printMatrix2D(result);
                    System.out.println("Enter to continue...");
                    sc.nextLine();
                    sc.nextLine();
                    break;
                case 4:
                    int[][] transpose = new int[2][2];
                    for (int i = 0; i < 2; i++)
                        for (int j = 0; j < 2; j++)
                            transpose[j][i] = A[i][j];
                    printMatrix2D(transpose);
                    System.out.println("Enter to continue...");
                    sc.nextLine();
                    sc.nextLine();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (true);
    }

    static void inputMatrix2D(Scanner sc, int[][] matrix) {
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++) {
                System.out.print("Enter value [" + i + "][" + j + "]: ");
                matrix[i][j] = sc.nextInt();
            }
    }

    static void printMatrix2D(int[][] matrix) {
        System.out.println("\nResult (2D):");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++)
                System.out.print(matrix[i][j] + "\t");
            System.out.println();
        }
    }
[4/5/2026 10:55 PM] Taing Sengkim: 

    static void run3D(Scanner sc) {
        int[][][] A = new int[2][2][2];
        int[][][] B = new int[2][2][2];
        int[][][] result = new int[2][2][2];
        System.out.println("Enter Matrix A (3D - 2 layers of 2x2):");
        inputMatrix3D(sc, A);
        System.out.println("Enter Matrix B (3D - 2 layers of 2x2):");
        inputMatrix3D(sc, B);


        do {

            System.out.println("====================================");
            System.out.println("\nChoose Operation (3D):");
            printMatrix3D(A);
            printMatrix3D(B);
            System.out.println("====================================");

            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication (layer by layer)");
            System.out.println("4. Transpose (Matrix A, layer by layer)");
            System.out.println("0. Exit");
            int choice = sc.nextInt();
            String con ;
            switch (choice) {
                case 1:
                    for (int l = 0; l < 2; l++)
                        for (int i = 0; i < 2; i++)
                            for (int j = 0; j < 2; j++)
                                result[l][i][j] = A[l][i][j] + B[l][i][j];
                    printMatrix3D(result);
                    System.out.println("Enter to continue...");
                    sc.nextLine();
                     sc.nextLine();
                    break;
                case 2:
                    for (int l = 0; l < 2; l++)
                        for (int i = 0; i < 2; i++)
                            for (int j = 0; j < 2; j++)
                                result[l][i][j] = A[l][i][j] - B[l][i][j];
                    printMatrix3D(result);
                    System.out.println("Enter to continue...");
                    sc.nextLine();
                   sc.nextLine();
                    break;
                case 3:
                    for (int l = 0; l < 2; l++)
                        for (int i = 0; i < 2; i++)
                            for (int j = 0; j < 2; j++) {
                                result[l][i][j] = 0;
                                for (int k = 0; k < 2; k++)
                                    result[l][i][j] += A[l][i][k] * B[l][k][j];
                            }
                    printMatrix3D(result);
                    System.out.println("Enter to continue...");
                    sc.nextLine();
                 sc.nextLine();
                    break;
                case 4:
                    // Transpose each layer of A
                    int[][][] transpose = new int[2][2][2];
                    for (int l = 0; l < 2; l++)
                        for (int i = 0; i < 2; i++)
                            for (int j = 0; j < 2; j++)
                                transpose[l][j][i] = A[l][i][j];
                    printMatrix3D(transpose);
                    System.out.println("Enter to continue...");
                    sc.nextLine();
                   sc.nextLine();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (true);
    }
    static void inputMatrix3D(Scanner sc, int[][][] matrix) {
        for (int l = 0; l < 2; l++) {
            System.out.println("  Layer " + l + ":");
            for (int i = 0; i < 2; i++)
                for (int j = 0; j < 2; j++) {
                    System.out.print("  Enter value [" + l + "][" + i + "][" + j + "]: ");
                    matrix[l][i][j] = sc.nextInt();
                }
        }
    }
    static void printMatrix3D(int[][][] matrix) {
        System.out.println("\nResult (3D):");
        for (int l = 0; l < 2; l++) {
            System.out.println("  Layer " + l + ":");
            for (int i = 0; i < 2; i++) {
                System.out.print("  ");
                for (int j = 0; j < 2; j++)
                    System.out.print(matrix[l][i][j] + "\t");
[4/5/2026 10:55 PM] Taing Sengkim: 
                System.out.println();
            }
        }
    }
}