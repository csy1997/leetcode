package 排序算法.归并排序;

import java.util.Arrays;

public class Solution {
    public static void mergeSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    public static void mergeSort(int[] arr, int l, int r, int[] temp) {
        if (l == r) {
            return;
        }
        int mid = (l + r) / 2;
        //将数组军分成两部分，分别进行归并排序
        mergeSort(arr, l, mid, temp);
        mergeSort(arr, mid + 1, r, temp);
        System.arraycopy(arr, l, temp, l, mid + 1 - l);//将左半排好序的部分复制一份，以便在原数组进行归并
        int p1 = l;
        int p2 = mid + 1;
        int i;
        for (i = l; p1 <= mid && p2 <= r; i++) {
            if (temp[p1] < arr[p2]) {
                arr[i] = temp[p1++];
            } else {
                arr[i] = arr[p2++];
            }
        }
        if (p2 == r + 1) {
            for (; i <= r; i++) {
                arr[i] = temp[p1++];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 8, 9, 1, 3, 4, 5, 2, 6};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
