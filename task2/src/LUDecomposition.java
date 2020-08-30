public class LUDecomposition {
    private double[][] L;
    private double[][] U;
    public double[] x;


    public void decomposition(double[][] A, int size){
        double[][] L = new double[size][size];
        double[][] U = new double[size][size];
        this.L = new double[size][size];
        this.U = new double[size][size];


        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                L[i][j] = 0;
                if (i == j){
                    U[i][j] = 1;
                } else U[i][j] = 0;
            }
        }


        for (int i = 0; i < size; i++) {
            L [i][0] = A [i][0];
            U [0][i] = A [0][i] / L [0][0];
        }


        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                if (i >= j){
                    double sum = 0;
                    for (int k = 0; k < j; k++) {
                        sum += L[i][k] * U[k][j];
                    }
                    L [i][j] = A [i][j] - sum;
                } else {
                    double sum = 0;
                    for (int k = 0; k < i; k++) {
                        sum += L[i][k] * U[k][j];
                    }
                    U [i][j] = (A [i][j] - sum) / L [i][i];
                }
            }
        }


        for(int i = 0; i<size; i++) {
            for (int j = 0; j < size; j++)
                this.L[i][j] = L[i][j];
        }


        for(int i = 0; i<size; i++) {
            for (int j = 0; j < size; j++)
                this.U[i][j] = U[i][j];
        }

    }



    public void decision(double[][] A, double[] B){
        decomposition(A, B.length);
        this.x = new double[B.length];
        double[] y = new double[B.length];


        y[0]=B[0]/L[0][0];
        for(int i = 1; i < B.length; i++){
            double sum=0;
            for(int j = 0; j < i; j++)
                sum+=L[i][j]*y[j];
            y[i]=(B[i]-sum)/L[i][i];
        }

        x[B.length-1]=y[B.length-1];
        for(int i = B.length-2; i >= 0; i--){
            double sum=0;
            for(int j = B.length-1; j >= i+1; j--)
                sum += x[j] * U[i][j];
            x[i] = y[i]-sum;
        }

    }

}
