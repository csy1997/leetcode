package 动态规划.L1012至少有1位重复的数字;

import java.util.*;

/**
 * 以45357为例
 * 第一种情况：先分别考虑个十百千位数的位不重复个数，9 * A(i, 9),i=0,1,2,3;
 *      个：9*1 = 9
 *      十：9*9 = 81
 *      百：9*9*8 = 648
 *      千：9*9*8*7 = 4536
 * i没到9，考虑第二种情况：
 *      第一位：选1,2,3三个数，后面为9个数在4个位置上排列，3 * A(4, 9)；选4，记录，到下一步；
 *      第二位：选0,1,2,3四个数，后面为8个数在3个位置上排列，4 * A(3, 8)；选5，记录，到下一步；
 *      第三位：选0,1,2三个数，后面为7个数在2个位置上排列，3 * A(2, 7)；选3，记录，到下一步；
 *      第四位：选0,1,2三个数，后面为6个数在1个位置上排列，3 * A(1, 6)；选5，冲突，终止。
 * res = N-sum = 29523
 */
public class Solution {
    public int numDupDigitsAtMostN(int N) {
        int temp = N;
        List<Integer> nums = new ArrayList<>();
        while(temp != 0) {
            nums.add(temp%10);
            temp /= 10;
        }
        Collections.reverse(nums);
        int sum = 0;//没有位重复的数个数
        //当前面连续位都是0时（总位数比N小），实际数不包含这些0，不构成重复，因此该类情况单独考虑
        for(int i = 0; i < nums.size()-1; i++) {//i+1最长比N长度少1，从1开始，代表去除前面的0后数的个数
            sum += 9 * A(i, 9);//最高位不为0，可能性为9个，剩下的位对i个数排列组合
            if(i == 9) {//这类情况i最高只能到9（>9在9个数里选不可能没有重复），且此时N长度>=11，首位不为0则后面一定有重复，第二类情况不用考虑直接返回
                return N - sum;
            }
        }
        HashSet<Integer> memo = new HashSet<>();//记录高位已出现的数字
        //第二类情况为首位不为0，依次考虑每位
        for(int i = 0; i <= nums.size(); i++) {
            if(i == nums.size()) {//直到最后一位都没有位的数重复，代表当前数值对应的最后一个数选上，结束
                sum++;
                break;
            }
            int x = nums.get(i);//对每位先考虑小于当前数的所有可行数个数（比如4对应的0、1、2、3一共4个数）
            if(i == 0) {//第一位少个0
                x--;
            }
            for (int j = 0; j < nums.get(i); j++) {
                if(memo.contains(j)) {
                    x--;//可行数不能和前面已选数重复，筛选掉
                }
            }
            //由于选的x个数小于当前位的数，所以后面的数无论多大都小于N，可能情况是对除去当前和前面的一共10-(i+1)个数在剩余nums.size()-1-i个位置上排列组合
            sum += x * A(nums.size()-1-i, 9-i);
            if(memo.contains(nums.get(i))) {//再对当前数数值考虑，如果已记录了该数字，那么选了会重复，后面的循环是基于选了该数基础上的，因此终止循环结束
                break;
            }
            memo.add(nums.get(i));
        }
        return N - sum;
    }

    public int A(int i, int j) {
        int res = 1;
        for (int k = 0; k < i; k++) {
            res *= j;
            j--;
        }
        return res;
    }

    public static void main(String[] args) {
        int N = 20;
        Solution sol = new Solution();
        System.out.println(sol.numDupDigitsAtMostN(N));
    }
}
