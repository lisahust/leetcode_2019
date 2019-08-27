package com_shopee.yx;

import java.util.LinkedList;
import java.util.Scanner;

//记得进行修改呀，别一模一样
public class pro1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String digits=sc.nextLine();
        if(digits.length()==0){
            System.out.print("");
            return;
        }
        String[]mapping=new String[]{"abc","def","ghi","jkl","mno","pqr","stu","vwx","yz"};
        LinkedList<String>result=new LinkedList<>();
        result.add(" ");
        for(int i=0;i<digits.length();++i){
            int x=Character.getNumericValue(digits.charAt(i));
            while(result.peek().length()==i){
                String tmp=result.remove();
                for(int j=0;j<mapping[x-1].length();++j){
                    result.add(tmp+mapping[x-1].charAt(j));

                }
            }
        }
        for(int i=0;i<result.size();++i){

                System.out.println(result.get(i));

        }

    }
}
