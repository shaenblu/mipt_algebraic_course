package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int p = scan.nextInt();

        JacobsthalMatrix m = new JacobsthalMatrix(p);

        MatrixHadamard mat = new MatrixHadamard(p, m.Matrix);

        int[][] code = mat.getCode();

        try(FileWriter writer = new FileWriter("/Users/gulnur/Documents/input.txt", false))
        {
            for (int i = 0; i < p+1; i++) {
                for (int j = 0; j < p; j++) {
                    final String s = Integer.toString(code[i][j]);
                    writer.write(s);
                }
                writer.write("\n");
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }


    }
}
