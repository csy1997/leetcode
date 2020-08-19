package 分治法.选择算法.选第二大元素;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    /**
     * 在比较中第二大数只会被最大数淘汰，因此可以记录被淘汰的数，找到最大后再找被它淘汰数里的最大
     * @param arr
     * @return
     */
    private HashMap<Integer, List<Integer>> map = new HashMap<>();
    public int getSecondMaxNum(int[] arr) {
        int x = getMaxNum(arr, arr.length);
//        System.out.println(map);
        int SecondMax = Integer.MIN_VALUE;
        for(int y : map.get(x)) {
            if(y > SecondMax) {
                SecondMax = y;
            }
        }
        return SecondMax;
    }

    public int getMaxNum(int[] arr, int len) {
        if(len == 1) {
            return arr[0];
        }
        int i;
        for(i = 0; i < len/2; i++) {
            int x = arr[2*i];
            int y = arr[2*i+1];
            if(x < y) {
                int temp = x;
                x = y;
                y = temp;
            }
            if(!map.containsKey(x)) {
                map.put(x, new ArrayList<>());
            }
            map.get(x).add(y);
            arr[i] = x;
        }
        if(len%2 == 1) {
            arr[i] = arr[2*i];
            map.put(arr[i], new ArrayList<>());
            i++;
        }
        return getMaxNum(arr, i);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {2,1,5,7,3,6,4};
        System.out.println(sol.getSecondMaxNum(arr));
    }
}
