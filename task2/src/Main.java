import java.util.*;

public class Main{

    public static void main (String[] args){

        Scanner scan = new Scanner(System.in);


        Input input = new Input();


        int k = 0;
        LUDecomposition l = new LUDecomposition();
        l.decision(input.A, input.bx);
        for (int i = 0; i < input.B.length; i++) {
            if (input.B[i].getX() == -100) {
                input.B[i].x = l.x[k++];
            }
        }


        k = 0;
        l.decision(input.A, input.by);
        for (int i = 0; i < input.B.length; i++) {
            if (input.B[i].getY() == -100) {
                input.B[i].y = l.x[k++];
            }
        }


        for(int i = 0; i < input.B.length; i++){
            System.out.println(input.B[i].getX()+" "+ input.B[i].getY());
        }

    }
}
