package 数数组和字符串.L71简化路径;

import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] arr = path.split("/");
        for (String a : arr) {
            if ("..".equals(a)) {//退回上一级
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else if (!".".equals(a) && !"".equals(a)) {//新的一级
                st.push(a);
            }
        }
        if (st.empty()) {
            return "/";
        }
        StringBuilder res = new StringBuilder();
        while (!st.empty()) {
            res.insert(0, "/" + st.pop());//从右往左加各级
        }
        return res.toString();
    }
}
