package com.company;

import java.util.*;

public class Input {
    public int N;
    public int M;
    public int[] weights;
    public int[][] Adjacency_matrix;



    public Input() {

        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();


        weights = new int[N];
        for (int i = 0; i < N; i++) {
            weights[i] = scan.nextInt();
        }


        Adjacency_matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Adjacency_matrix[i][j] = 0;
            }
        }

        for (int i = 0; i < M; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            Adjacency_matrix[a - 1][b - 1] = 1;
            Adjacency_matrix[b - 1][a - 1] = 1;
        }

    }
}
