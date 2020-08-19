package 贪心法.最小延迟调度;

/**
 * 贪心策略：按截止时间顺序安排
 * 正确性可由交换论证和数学归纳得出（消除逆序不会降低最优）
 */
public class Solution {
    public int getMinDelay(int[] T, int[] D) {
        //对D即截止时间排序
        quickSort(D, T);
        int maxDelay = 0;
        int finish = 0;
        for (int i = 0; i < T.length; i++) {
            finish += T[i];
            maxDelay = Math.max(maxDelay, finish-D[i]);
        }
        return maxDelay;
    }

    public void quickSort(int[] D, int[] T) {
        quickSort(D, T, 0, D.length-1);
    }

    public void quickSort(int[] D, int[] T, int l, int r) {
        if(l == r+1) {
            return;
        }
        int midNum = D[r];
        int p = l;
        for (int i = l; i <= r; i++) {
            if(D[i] <= midNum) {
                swap(D, T, p, i);
                p++;
            }
        }
        quickSort(D, T, l, p-2);
        quickSort(D, T, p, r);
    }

    private void swap(int[] D, int[] T, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = D[i];
        D[i] = D[j];
        D[j] = temp;
        temp = T[i];
        T[i] = T[j];
        T[j] = temp;
    }

    public static void main(String[] args) {
        int[] T = {5,8,4,10,3};
        int[] D = {10,12,15,11,20};
        Solution sol = new Solution();
        System.out.println(sol.getMinDelay(T, D));
    }
}
