package com_beike;

/**
 * ac 100%
 */

import java.math.BigInteger;
import java.util.Scanner;

public class pro7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n表示贝壳的种数，m表示小明背包的体积
        int n = sc.nextInt();
        BigInteger m = sc.nextBigInteger();

        int[][] shell = new int [n][2];
        for(int i = 0; i < n; ++i) {
            shell[i][0] = sc.nextInt();
            shell[i][1] = sc.nextInt();
        }

        BigInteger count = BigInteger.valueOf(0);
        for (int i = 0; i < n; ++i) {
            // 背包不够用
            if(m.compareTo(BigInteger.valueOf(0)) < 1){
                break;
            }
            if (m.compareTo(BigInteger.valueOf(shell[i][1])) != -1) {
                BigInteger tmp = m.divide(BigInteger.valueOf(shell[i][1]));
                if (BigInteger.valueOf(shell[i][0]).compareTo(tmp) > -1) {
                    count = count.add(tmp);
                    m = m.subtract(tmp.multiply(BigInteger.valueOf(shell[i][1])));
                } else {
                    count = count.add(BigInteger.valueOf(shell[i][0]));
                    m = m.subtract(BigInteger.valueOf(shell[i][0]).multiply(BigInteger.valueOf(shell[i][1])));
                }
            }
        }
        System.out.print(count);

    }

}
