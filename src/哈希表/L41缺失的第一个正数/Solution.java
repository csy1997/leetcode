package 哈希表.L41缺失的第一个正数;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        int l = nums.length;
        int[] res = new int[l+1];//新数组下标代表对应的数字，除第0个之外，后面用-1代表是否在nums中出现
        for(int i = 0; i < l; i++){
            int k = nums[i];
            if(k > 0 && k <= l){//结果最大为l+1，当1~l正整数全部在nums中出现时
                res[k] = -1;//k数出现，记录为-1
            }
        }
        for(int i = 1; i < l+1; i++){
            if(res[i] != -1){
                return i;//遇到第一个没有记录到的则为缺失的第一个正数
            }
        }
        return l+1;
    }
}
