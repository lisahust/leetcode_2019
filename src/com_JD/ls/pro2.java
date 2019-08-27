package com_JD.ls;

/**
 * ac 18%
 * 题目描述：
 * 某校在积极推行无人监考制度，但是总有学生是不自觉的，如果将两个很熟的异性朋友放在同一个考场里，他们就会交流甚至作弊。因此一个考场中不能允许两个很熟的异性朋友存在，学校希望通过搬出一部分学生的方法来改善这一问题。
 * 但是又因为教室数量有限，因此希望一个教室中容下的学生尽可能多，即需要搬出教室的学生数量尽可能少，请你输出搬出教室人数最少，且字典序最小的方案。
 *
 * 输入
 * 输入第一行有两个整数n和m，分别表示有n个男生和n个女生，有m个朋友关系。
 * (1<=n<=500,1<=m<=100000)
 * 接下来m行，每行有两个整数，x和y，表示第x号男生和第y号女生是朋友。男生的编号均为[1,n]，女生的编号为[n+1,2n]。
 *
 * 输出
 * 输出第一行包含一个整数a，表示最少需要搬出教室的人数。
 * 输出第二行有a个整数，即a个需要搬出教室的人的编号，要求人数最少，且字典序最小。
 *
 *
 * 样例输入
 * 2 2
 * 3 1
 * 1 4
 * 样例输出
 * 1
 * 1
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class pro2 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        // n个男生和女生
        int n = sc.nextInt();
        // m个朋友关系
        int m = sc.nextInt();

        int [][] relation = new int[m][2];
        int [] people = new int[2 * m];
        for (int i = 0; i < m; ++i) {
            relation[i][0] = sc.nextInt();
            relation[i][1] = sc.nextInt();
            people[2*i] =  relation[i][0];
            people[2*i + 1] =  relation[i][1];
        }


        Map<Integer, Integer> map = new HashMap<Integer, Integer>() {};
        for (int i = 0; i < 2*m; i++) {
            Integer peoNum = people[i];
            if (!map.containsKey(peoNum)) {
                map.put(peoNum, 1);
            } else {
                int count = map.get(peoNum);
                count++;
                map.put(peoNum, count);
            }
        }

        int count = 0;
        int [] del = new int[2*m];
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry)iter.next();
            Integer key =(Integer)entry.getKey();
            Integer val = (Integer)entry.getValue();
            if(val >= 2){
                del[count] = key;
                count++;
            }
        }

        for (int i = 0; i < m; ++i) {
            if (idDelected(relation[i][0], del)) {
                continue;
            } else {
                if (idDelected(relation[i][1], del)) {
                    continue;
                } else {
                    del[count] = relation[i][0];

                    count++;

                }
            }

        }


        System.out.println(count);

        for (int i = 0; i < count; ++i){
            System.out.print(del[i] + " ");
        }
    }

    public static boolean idDelected(int num, int [] del) {
        for (int i = 0; i < del.length; ++i) {
            if (num == del[i]) {
                return true;
            }
        }
        return false;
    }
}
