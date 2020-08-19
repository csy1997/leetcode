package 贪心法.哈夫曼算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 应用：文件归并
 */
public class Solution {
    public double getMinWeight(int[] arr) {
        if(arr.length < 2) {
            return -1;
        }
        int sum = 0;
        int res = 0;
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        for(int a : arr) {
            list.add(a);
            sum += a;
        }
        while(list.size() != 1) {
            int temp = list.remove(0) +list.remove(0);
            res += temp;
            addMergedElement(list, temp);
        }
        return (double)res/sum;
    }

    public void addMergedElement(List<Integer> list, int x) {
        int l = 0;
        int r = list.size()-1;
        while(l != r+1) {
            int mid = (l+r)/2;
            if(x > list.get(mid)) {
                l = mid+1;
            } else if(x < list.get(mid)) {
                r = mid-1;
            } else {
                list.add(mid, x);
//                System.out.println(list);
                return;
            }
        }
        list.add(l, x);
//        System.out.println(list);
    }

    public static void main(String[] args) {
//        int[] arr = {5,5,10,15,25,10,10,20};
        int[] arr = {5,9,16,12,13,45};
        Solution sol = new Solution();
        System.out.println(sol.getMinWeight(arr));
    }
}
