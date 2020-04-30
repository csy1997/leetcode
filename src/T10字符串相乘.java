import java.util.ArrayList;
import java.util.List;

public class T10字符串相乘 {
    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        List<String> list = new ArrayList<>();
        int l1 = num1.length();
        int l2 = num2.length();
        int maxL = 0;
        for(int i = l2-1; i >= 0; i--){
            int num2Ati = num2.charAt(i)-48;
            if(num2Ati == 0){
                continue;
            }
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            for(int k = 0; k < l2-i-1; k++){
                sb.append(0);
            }
            for(int j = l1-1; j >= 0; j--){
                int num1Atj = num1.charAt(j)-48;
                int mul = num1Atj * num2Ati + carry;
                sb.append(mul%10);
                carry = mul/10;
            }
            if(carry != 0){
                sb.append(carry);
            }
            if(sb.length() > maxL){
                maxL = sb.length();
            }
            list.add(sb.toString());
        }
        return add(list, maxL);
    }

    public String add(List<String> list, int maxL){
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = 0; i < maxL; i++){
            int addi = 0;
            for(String str : list){
                if(str.length() > i){
                    addi += str.charAt(i)-48;
                }
            }
            addi += carry;
            sb.append(addi%10);
            carry = addi/10;
        }
        if(carry != 0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        T10字符串相乘 ob = new T10字符串相乘();
        String num1 = "123";
        String num2 = "456";
        System.out.println(ob.multiply(num1, num2));
    }
}
