public class Board {
     public boolean check(int x, int y, int z,double[][] A){
         boolean result = false;
         if ((A[x-1][y-1] == -1.0) && (A[x-1][z-1] == -1.0) && (A[y-1][z-1] == -1.0)){
             result = true;
         }
         //System.out.println(result);
         return result;
     }
}
