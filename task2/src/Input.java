import java.util.*;

public class Input {
    public double[][] A;
    public Coordinates[] B;
    public double[] bx;
    public double[] by;
    private int x;
    private int y;
    private int z;

    public Input() {

        Scanner scan = new Scanner(System.in);

        int NV = scan.nextInt();
        int NE = scan.nextInt();


        double[][] A = new double[NV][NV];
        this.B = new Coordinates[NV];
        double[] bxx = new double[NV];
        double[] byy = new double[NV];

        this.bx = new double[NV-3];
        this.by = new double[NV-3];


        for (int i = 0; i < NV; i++) {
            B[i] = new Coordinates(-100, -100);
        }


        this.x = scan.nextInt();
        B[x - 1] = new Coordinates(0, 0);

        this.y = scan.nextInt();
        B[y - 1] = new Coordinates(1, 0);

        this.z = scan.nextInt();
        B[z - 1] = new Coordinates(1, 1);


        for (int i = 0; i < NV; i++) {
            for (int j = 0; j < NV; j++) {
                A[i][j] = 0;
            }
        }


        for (int i = 0; i < NE; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            A[a - 1][b - 1] = -1;
            A[b - 1][a - 1] = -1;
        }


        for (int i = 0; i < NV; i++) {
            int sum = 0;
            for (int j = 0; j < NV; j++) {
                if (i != j) {
                    sum += -1 * A[i][j];
                }
            }
            A[i][i] = sum;
        }


        if (new Board().check(x, y, z, A) == false) {
            System.exit(0);
        }


        for (int i = 0; i < NV; i++) {
            bxx[i] = -1 * (A[i][x - 1] * B[x - 1].getX() + A[i][y - 1] * B[y - 1].getX() + A[i][z - 1] * B[z - 1].getX());
            byy[i] = -1 * (A[i][x - 1] * B[x - 1].getY() + A[i][y - 1] * B[y - 1].getY() + A[i][z - 1] * B[z - 1].getY());
        }

        List<Double> bbx = new ArrayList<Double>();
        List<Double> bby = new ArrayList<Double>();
        for (int i = 0; i < NV; i++) {
            if ((i != x - 1) && (i != y - 1) && (i != z - 1)) {
                bbx.add(bxx[i]);
                bby.add(byy[i]);
            }
        }

        int k = 0;
        int j = 0;
        for(int i = 0; i < NV - 3; i++){
            this.bx[i] = bbx.get(k++);
            this.by[i] = bby.get(j++);
        }

        this.A = new double[NV - 3][NV - 3];
        List<Double> l = new ArrayList<Double>();
        for (int i = 0; i < NV; i++) {
            if ((i != x - 1) && (i != y - 1) && (i != z - 1)) {
                for (j = 0; j < NV; j++)
                    if ((j != x - 1) && (j != y - 1) && (j != z - 1)) {
                        l.add(A[i][j]);
                    }
            }
        }

        k = 0;
        for(int i = 0; i < NV - 3; i++){
            for (j = 0; j < NV -3; j++){
                this.A[i][j] = l.get(k++);
            }
        }

    }
}
