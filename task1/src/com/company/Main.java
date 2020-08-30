package com.company;

import java.util.*;

public class Main{

    public static void main (String[] args){

        Scanner scan = new Scanner(System.in);

        WinogradStrassen s = new WinogradStrassen();

        int N = scan.nextInt();

        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++){
            for(int j=0;j<N; j++){
                A[i][j]=scan.nextInt();
            }
        }
        int[][] B = new int[N][N];
        for (int i = 0; i < N; i++){
            for(int j=0;j<N; j++){
                B[i][j]=scan.nextInt();
            }
        }

        int[][] C = s.multiply(A, B);

        System.out.println("Result ");
        for (int i = 0; i < N; i++){
            if (i!=0){
                System.out.println();
            }
            for (int j = 0; j < N; j++){
                System.out.print(C[i][j] +" ");
            }
        }
    }
}

