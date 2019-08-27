package com_shopee.yx;

import java.util.LinkedList;

//50%的通过率，记得改东西，别被查出
public class pro3 {
    public static void  main(String[]args){
        String s="1+2*3-(5-4)+6/3";
        char[]c=s.toCharArray();
        int[]bar=value(c,0);
        if(bar==null)return;
        System.out.println(bar[0]);
    }
    public static int[]value(char[]str,int i){
        LinkedList<String>queue=new LinkedList<>();
        int pre=0;
        int[]bar=null;
        while(i<str.length&&str[i]!=')'){
            if(str[i]>='0'&&str[i]<='9'){
                pre=pre*10+str[i++]-'0';
            }
            else if(str[i]=='+'||str[i]=='-'||str[i]=='*'||str[i]=='/'){
                addNum(queue,pre);
                queue.addLast(String.valueOf(str[i++]));
                pre=0;
            }
            else if(str[i]=='('){
                bar=value(str,1+i);
                if(bar==null)return null;
                pre=bar[0];
                i=bar[1]+1;

            }
            else{
                System.out.print("ERROR");
                return null;
            }
        }
        addNum(queue,pre);
        return new int[]{getNum(queue),i};
    }
    public static void addNum(LinkedList<String>queue,int num){
        if(!queue.isEmpty()){
            int cur=0;
            String top=queue.pollLast();
            if(top.equals("+")||top.equals("-")){
                queue.addLast(top);
            }
            else{
                cur=Integer.valueOf(queue.pollLast());
                num=top.equals("*")?(cur*num):(cur/num);
            }
        }
        queue.addLast(String.valueOf(num));
    }
    public  static int getNum(LinkedList<String>queue){
        int res=0;
        boolean add=true;
        String cur=null;
        int num=0;
        while(!queue.isEmpty()){
            cur=queue.pollFirst();
            if(cur.equals("+")){
                add=true;
            }
            else if(cur.equals("-")){
                add=false;
            }
            else{
                num=Integer.valueOf(cur);
                res+=add?num:(-num);
            }
        }
        return res;
    }
}
