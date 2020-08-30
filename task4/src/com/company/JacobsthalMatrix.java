package com.company;

public class JacobsthalMatrix {
    private int p;
    public int[][] Matrix;
    private int[] Field;
    private int[] QuadraticField;
    

    private boolean QuadraticResidue(int a){
        boolean res = false;
        for (int i = 0; i < p; i++)
            if (QuadraticField[i] == a) {
                res = true;
                break;
            }
        return res;
    }

    private int LegendreSymbol(int a){
        int res = -2;
        if (a == 0) res = 0;
        if (QuadraticResidue(a)) res = 1;
            else res = -1;
        return res;
    }


    public JacobsthalMatrix(int p){
        this.p = p;
        Matrix = new int[p][p];
        Field = new int[p];
        QuadraticField = new int[p];

        for (int i = 0; i < p; i++)
            Field[i] = i;

        for (int i = 0; i < p; i++)
            QuadraticField[i] = (i*i) % p;

        for (int i = 0; i < p; i++)
            for (int j = 0; j < p; j++){
                if (i == j) Matrix[i][j] = -1;
                else {
                    if (j-i >0) Matrix[i][j] = LegendreSymbol(j - i);
                    else Matrix[i][j] = -1*Matrix[j][i];
                }
            }


    }

}
