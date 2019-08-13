package beike;

import java.util.*;
import java.math.*;

public class pro1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 第一行为n
        int n = sc.nextInt();
        sc.nextLine();

        // 第二行是n个用空格分隔的正整数
        String str = sc.nextLine();
        String [] arr = str.split(" ");
        BigInteger  [] numArr = new BigInteger[n];

        for (int i = 0; i < n; ++i) {
            numArr[i] = new BigInteger(arr[i]);
        }

        BigInteger  num1 = numArr[0];
        BigInteger  num2 = numArr[1];
        BigInteger min = numArr[0].compareTo(numArr[1]) > 0 ? numArr[0].subtract(numArr[1]) : numArr[1].subtract(numArr[0]) ;

        for (int i = 0; i < n-1; ++i) {
            BigInteger tmp = numArr[i].compareTo(numArr[i+1]) > 0 ? numArr[i].subtract(numArr[i+1]) : numArr[i+1].subtract(numArr[i]) ;
            //            System.out.println(i + " min "+min);
            //            System.out.println(i + " tmp "+tmp);

            // tmp < min
            if (tmp.compareTo(min) == -1) {
                num1 = numArr[i];
                num2 = numArr[i+1];
                min = tmp;
            }
        }

        System.out.print(num1 + " " + num2);


    }

}
