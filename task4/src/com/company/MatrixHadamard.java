package com.company;


public class MatrixHadamard {
    public int[][] matrix;
    private int size;

    public MatrixHadamard(int p, int[][] Matrix){
        size = p+1;

        matrix = new int[size][size];
        for(int i = 0; i<size; i++)
            for (int j = 0 ; j <size; j++)
                matrix[i][j] = 1;

        for(int i = 1; i<size; i++)
            for (int j = 1 ; j <size; j++)
                matrix[i][j] = Matrix[i-1][j-1];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 1)
                    matrix[i][j] = 0;
                else   matrix[i][j] = 1;
            }
        }
    }

    public int[][] getCode(){
        int[][] output = new int[size][size-1];

        for(int i = 0; i < size; i++)
            for (int j = 1; j < size; j++)
                output[i][j-1] = matrix[i][j];

        return output;
    }

}
