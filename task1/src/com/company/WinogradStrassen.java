package com.company;
import java.lang.Math;


public class WinogradStrassen {

    private int[][] prepare(int[][] A){
        int[] arr = {64, 128, 256, 512};
        if ((A.length >= 64)&&(notEqual(arr, A.length))){
            int k = newSize(arr, A.length);
            int[][] A1 = new int[k][k];
            A1 = addNull(A, k);
            return A1;
        } else {
            int[][] A1 = new int[A.length][A.length];
            for (int i = 0; i < A.length; i++){
                for (int j = 0; j < A.length; j++){
                    A1[i][j] = A[i][j];
                }
            }
            return A1;
        }

    }

    private int newSize(int[] mas, int x){
        int k = 0;
        for (int i = 0; i < mas.length; i++){
            if (mas[i] > x){
                k = mas[i];
                break;
            }
        }
        return k;
    }

    private int[][] addNull(int[][] A, int n){
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = 0;
            }
        }
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < A.length; j++){
                C[i][j] = A[i][j];
            }
        }
        return C;
    }


    private boolean notEqual(int[] A, int x){
        int N = A.length;
        boolean compp = true;
        for (int i = 0; i < N; i++){
            if (A[i] == x){
                compp = false;
                break;
            }
        }
        return compp;
    }

    private int[][] simpleMultiply(int[][] A, int[][] B){
        int N = A.length;
        int[][] C = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                C[i][j] = 0;
                for(int k = 0; k < N; k++){
                    C[i][j] = C[i][j] + A[i][k]*B[k][j];
                }
            }
        }
        return C;
    }
    private void divide(int[][] A, int[][] B, int i, int j) {
        for (int i1 = 0, i2 = i; i1 < B.length; i1++, i2++)
            for (int j1 = 0, j2 = j; j1 < B.length; j1++, j2++)
                B[i1][j1] = A[i2][j2];
    }

    private int[][] substraction(int[][] A, int[][] B) {
        int N = A.length;
        int[][] C = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                C[i][j] = A[i][j] - B[i][j];
        return C;
    }

    private int[][] addition(int[][] A, int[][] B) {
        int N = A.length;
        int[][] C = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                C[i][j] = A[i][j] + B[i][j];
        return C;
    }

    private void union(int[][] A, int[][] B, int i, int j) {
        for (int i1 = 0, i2 = i; i1 < A.length; i1++, i2++)
            for (int j1 = 0, j2 = j; j1 < A.length; j1++, j2++)
                B[i2][j2] = A[i1][j1];
    }

    public int[][] multiply(int[][] A, int[][] B) {

        int[][] A1 = prepare(A);
        int[][] B1 = prepare(B);

        int N = A1.length;
        int[][] Result = new int[N][N];

        if (N <= 64)
            Result = simpleMultiply(A1, B1);
        else {
            int n = N / 2;
            int[][] A11 = new int[n][n];
            int[][] A12 = new int[n][n];
            int[][] A21 = new int[n][n];
            int[][] A22 = new int[n][n];
            int[][] B11 = new int[n][n];
            int[][] B12 = new int[n][n];
            int[][] B21 = new int[n][n];
            int[][] B22 = new int[n][n];

            divide(A1, A11, 0, 0);
            divide(A1, A12, 0, n);
            divide(A1, A21, n, 0);
            divide(A1, A22, n, n);

            divide(B1, B11, 0, 0);
            divide(B1, B12, 0, n);
            divide(B1, B21, n, 0);
            divide(B1, B22, n, n);

            int[][] S1 = addition(A21, A22);
            int[][] S2 = substraction(S1, A11);
            int[][] S3 = substraction(A11, A21);
            int[][] S4 = substraction(A12, S2);
            int[][] S5 = substraction(B12, B11);
            int[][] S6 = substraction(B22, S5);
            int[][] S7 = substraction(B22, B12);
            int[][] S8 = substraction(S6, B21);

            int[][] P1 = multiply(S2, S6);
            int[][] P2 = multiply(A11, B11);
            int[][] P3 = multiply(A12, B21);
            int[][] P4 = multiply(S3, S7);
            int[][] P5 = multiply(S1, S5);
            int[][] P6 = multiply(S4, B22);
            int[][] P7 = multiply(A22, S8);

            int[][] T1 = addition(P1, P2);
            int[][] T2 = addition(T1, P4);

            int[][] C11 = addition(P2, P3);
            int[][] C12 = addition(T1, addition(P5, P6));
            int[][] C21 = substraction(T2, P7);
            int[][] C22 = addition(T2, P5);

            union(C11, Result, 0, 0);
            union(C12, Result, 0, n);
            union(C21, Result, n, 0);
            union(C22, Result, n, n);
        }
        return Result;
    }
}
