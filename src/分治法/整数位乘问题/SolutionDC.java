package 分治法.整数位乘问题;

import java.util.ArrayList;
import java.util.List;

public class SolutionDC {
    /**
     * 适用于x,y都是n位二进制数，其中n=2^k，在分治中减少了子问题数（4变3）
     * @param x
     * @param y
     * @return
     */
    public static String multiplyBinary1(String x, String y) {
        int len1 = x.length();
        int len2 = y.length();
        if(len1 != len2) {
            System.out.println("不满足要求");
            return "";
        }
        if(len1 == 1) {
            if(x.equals("0")) {
                return "0";
            }
            return y;
        }
        String x1 = x.substring(0, len1/2);
        String x2 = x.substring(len1/2);
        String y1 = y.substring(0, len2/2);
        String y2 = y.substring(len2/2);

        // x * y = x1*y1*2^(len1-len1/2+len2-len2/2) + x1*y2*2^(len1-len1/2) + x2*y1*(len2-len2/2) + x2*y2;
        // 由于本函数需满足len1 = len2 = n=2^k, 故
        // x * y = x1*y1*2^len1 + (x1*y2+x2*y1)*2^(len1/2) + x2*y2
        //       = x1*y1*2^len1 + ((x1-x2)*(y2-y1)+x1*y1+x2*y2)*2^(len1/2) + x2*y2
        //       = x1*y1*(2^len1+2^(len1/2)) + x2*y2*(2^(len1/2)+1) + (x1-x2)*(y2-y1)*2^(len1/2)
        // 变成了3项，从而减少复杂度
        long x1y1 = Long.valueOf(multiplyBinary1(x1, y1), 2);
        long x2y2 = Long.valueOf(multiplyBinary1(x2, y2), 2);
        long xy = Long.valueOf(multiplyBinary1(Long.toBinaryString(Long.valueOf(x1, 2)-Long.valueOf(x2, 2)),
                Long.toBinaryString(Long.valueOf(y2, 2)-Long.valueOf(y1, 2))), 2);
        long temp = (long) Math.pow(2, len1/2);
        long res = x1y1*temp*(temp+1) + x2y2*(temp+1) + xy*temp;

        return Long.toBinaryString(res);
    }

    public static String multiplyBinary2(String x, String y) {
        int len1 = x.length();
        int len2 = y.length();
        if (len1 == 1) {
            if (x.equals("0")) {
                return "0";
            }
            return y;
        }
        if (len2 == 1) {
            if (y.equals("0")) {
                return "0";
            }
            return x;
        }
        String x1 = x.substring(0, len1/2);
        String x2 = x.substring(len1/2);
        String y1 = y.substring(0, len2/2);
        String y2 = y.substring(len2/2);

        // x * y = x1*y1*2^(len1-len1/2+len2-len2/2) + x1*y2*2^(len1-len1/2) + x2*y1*(len2-len2/2) + x2*y2
        String x1y1 = multiplyBinaryString(x1, y1);
        String x1y2 = multiplyBinaryString(x1, y2);
        String x2y1 = multiplyBinaryString(x2, y1);
        String x2y2 = multiplyBinaryString(x2, y2);

        x1y1 += "0".repeat(len1 - len1 / 2 + len2 - len2 / 2);
        x1y2 += "0".repeat(len1 - len1 / 2);
        x2y1 += "0".repeat(len2 - len2 / 2);

        long res = Long.valueOf(x1y1, 2)+Long.valueOf(x1y2, 2)+Long.valueOf(x2y1, 2)+Long.valueOf(x2y2, 2);
        return Long.toBinaryString(res);
    }

    /**
     * 本函数加法部分没有转化为数而是直接操作字符串，效率较低
     * @param x
     * @param y
     * @return
     */
    public static String multiplyBinaryString(String x, String y) {
        int len1 = x.length();
        int len2 = y.length();
        if(len1 == 1) {
            if(x.equals("0")) {
                return "0";
            }
            return y;
        }
        if(len2 == 1) {
            if(y.equals("0")) {
                return "0";
            }
            return x;
        }
        String x1 = x.substring(0, len1/2);
        String x2 = x.substring(len1/2);
        String y1 = y.substring(0, len2/2);
        String y2 = y.substring(len2/2);

        // x * y = x1*y1*2^(len1-len1/2+len2-len2/2) + x1*y2*2^(len1-len1/2) + x2*y1*(len2-len2/2) + x2*y2
        String x1y1 = multiplyBinaryString(x1, y1);
        String x1y2 = multiplyBinaryString(x1, y2);
        String x2y1 = multiplyBinaryString(x2, y1);
        String x2y2 = multiplyBinaryString(x2, y2);

        x1y1 += "0".repeat(len1 - len1 / 2 + len2 - len2 / 2);
        x1y2 += "0".repeat(len1 - len1 / 2);
        x2y1 += "0".repeat(len2 - len2 / 2);

        List<String> binaries = new ArrayList<>();
        binaries.add(x1y1);
        binaries.add(x1y2);
        binaries.add(x2y1);
        binaries.add(x2y2);

        return SumBinary(binaries);
    }

    public static String SumBinary(List<String> binaries) {
        int maxLen = 0;
        for (String binary : binaries) {
            if (binary.length() > maxLen) {
                maxLen = binary.length();
            }
        }
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = maxLen-1; i >= 0; i--) {
            for (int j = 0; j < binaries.size(); j++) {
                int index = i + binaries.get(j).length() - maxLen;
                if(index != -1) {
                    if(binaries.get(j).charAt(index) == '1') {
                        sum++;
                    }
                } else {
                    binaries.remove(j);
                    j--;
                }
            }
            sb.append(sum%2);
            sum /= 2;
        }
        while(sum != 0) {
            sb.append(sum%2);
            sum /= 2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a ="1";
        String b = "1";
        long res1 = Long.valueOf(a, 2) * Long.valueOf(b, 2);
        long res2 = Long.valueOf(multiplyBinary1(a, b), 2);
        System.out.println(res1);
        System.out.println(res2);
    }
}
