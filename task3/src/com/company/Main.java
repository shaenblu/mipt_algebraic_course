package com.company;

import java.util.Scanner;



public class Main{

    public static void main (String[] args){

        Scanner scan = new Scanner(System.in);

        Input input = new Input();

        Algorithm algo = new Algorithm();
        algo.getVerticesCover(input.Adjacency_matrix, input.weights);

        for(int i = 0; i < algo.V_output.size(); i++){
            System.out.print(algo.V_output.get(i)+" ");
        }

    }
}

