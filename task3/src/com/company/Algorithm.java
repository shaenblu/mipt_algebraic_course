package com.company;

import java.util.ArrayList;
import java.util.List;

public class Algorithm {
    public List V_output;

    private int min(int a, int b){
        int c = a;
        if (a < b){
            c = a;
        } else c = b;
        return c;
    }

    public void getVerticesCover(int[][] Adjacency_matrix, int[] weights){
        int[] x = new int[weights.length];
        for(int i = 0; i < weights.length; i++){
            x[i] = 0;
        }

        for (int i = 0; i < weights.length; i++)
            for (int j = i+1; j < weights.length; j++){
                if (Adjacency_matrix[i][j] == 1){
                    int a = weights[i] - x[i];
                    int b = weights[j] - x[j];
                    x[i] += min(a,b);
                    x[j] += min(a,b);
                }
            }

        V_output = new ArrayList();

        for (int i = 0; i < weights.length; i++)
            if (x[i] == weights[i]){
                V_output.add(i+1);
            }

    }
}
