package com_yuanfudao;

/**
 * 猿辅导一面
 * 算法题：int [] arr = {1,2,2,3,3,3,3,4,4,4,5,5,10,10}. k = 2. 如果次数大于2就删除。返回{1,2,2,5,5,10}
 */

public class interview01 {
    public static void main(String [] args) {
        int [] arr = {1,2,2,3,3,3,3,4,4,4,5,5,10,10};
        int k = 2;
        interview01 solution = new interview01();
        System.out.print(solution.arrDel(arr, k));
    }

    public int arrDel(int [] arr, int k) {
        int res = 0;
        int count = 1;
        int len = arr.length;


        for (int i = 0; i < len-1; ++i) {
            if (arr[i] == arr[i+1]) {
                count++;
            } else {
                // ok
                if (count <= k) {
                    for (int j = 0; j < count; j++) {
                        arr[res+j] = arr[i];
                    }
                    res = res + count;
                }
                count = 1;
            }
        }

        // 判断最后一个是否满足条件
        if (count <= k) {
            for (int j = 0; j < count; j++) {
                arr[res+j] = arr[len-1];
            }
            res = res+count;
        }

        for (int i = 0; i < len; ++i) {
            System.out.print(arr[i] + " ");
        }

        return res;

    }
}
