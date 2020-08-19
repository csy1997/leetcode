package 分治法.选择算法.选第K大元素;

/**
 * 类似于快速排序的分治（其中每轮中间数的选择有更好的算法）
 */
public class Solution {
    public int getKthMaxNum(int[] arr, int K) {
        return getKthMaxNum(arr, K, 0, arr.length-1);
    }

    public int getKthMaxNum(int[] arr, int K, int l, int r) {
        if(l == r+1) {
            System.out.println("没有第"+K+"大的数");
            return -1;
        }
        int midNum = arr[r];
        int p = l;
        for (int i = l; i <= r; i++) {
            if(arr[i] <= midNum) {
                swap(arr, p, i);
                p++;
            }
        }
        //最终midNum的位置在p-1处
        if(r-p+2 == K) {
            return arr[p-1];
        } else if(r-p+2 < K) {
            return getKthMaxNum(arr, K-r+p-2, l, p-2);
        } else {
            return getKthMaxNum(arr, K, p, r);
        }
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1,4,2,5,3,7,6};
        System.out.println(sol.getKthMaxNum(arr, 6));
    }
}
