package com_shopee.yx;

import java.util.Scanner;

public class pro2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []nums={20,10,5,4,2,1};
        int count=0;
        for(int i=0;i<nums.length;++i){
            int num=n/nums[i];
            n=n-num*nums[i];
            count+=num;
        }
        System.out.print(count);
    }
}
