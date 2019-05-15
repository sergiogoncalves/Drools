package br.com.sergiogoncalves.drools.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;


public class Sandbox {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {



        staircase(4);



    }

    static void staircase(int n) {


        for (int i = 0; i <  n; i++) {

            int j = 0;

                do {
                    System.out.print("#");

                    j++;
                }while (j <= i);
            System.out.println();
        }

    }



}
