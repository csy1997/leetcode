package 排序算法.快速排序;

import java.util.Arrays;

public class Solution {
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l == r + 1) {//最终l会比r大，即多一个时结束
            return;
        }
        int midNum = arr[r];//用最后一个数充当中间数
        int p = l;//记录分割位置
        //i记录遍历的元素，小于等于midNum就和p处元素交换，右移i和p指针；比midNum大就只移动i指针（以便下次i和p的交换）
        for (int i = l; i <= r; i++) {
            if (arr[i] <= midNum) {
                swap(arr, p, i);
                p++;
            }
        }
        //最终midNum的位置在p-1处
        quickSort(arr, l, p - 2);
        quickSort(arr, p, r);
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {7, 8, 9, 1, 3, 4, 5, 2, 6};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
