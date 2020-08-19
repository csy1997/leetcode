package 贪心法.L134加油站;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int total_tank = 0;
        int curr_tank = 0;
        int starting_station = 0;
        for (int i = 0; i < n; ++i) {
            total_tank += gas[i] - cost[i];
            curr_tank += gas[i] - cost[i];
            if (curr_tank < 0) {//如果加油减耗油小于0，说明受当前站影响不能顺利行驶，且可证明从上一个starting_station到i都不能充当出发站，因此要更新
                starting_station = i + 1;
                curr_tank = 0;
            }
        }
        return total_tank >= 0 ? starting_station : -1;//一趟遍历正好计算出总加油-总耗油，如果为负则不能完成行驶
    }
}
