package 分治法.选择算法.选最大元素;

/**
 * 找最大最小最快的算法也需要o(n)，因此直接顺序遍历
 */
public class Solution {
    public int getMaxNum(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
