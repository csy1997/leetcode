public class T65有效数字 {
    public boolean isNumber(String s) {
        int i = 0;
        int pointNum = 0;
        if(s.charAt(i) == ' '){
            for(; i < s.length(); i++){
                if(s.charAt(i) != ' '){
                    break;
                }
            }
        }
        if(i == s.length()){
            return false;
        }
        for(; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == 'e'){
                pointNum = 0;
                if(i == 0 || i == s.length()-1 || !isNum(s.charAt(i-1)) || (!isNum(s.charAt(i+1)) && !isOperator(s.charAt(i+1)))){
                    return false;
                }
            }else if(c == '.'){
                pointNum++;
                if(pointNum == 2){
                    return false;
                }
                if(i == 0 || s.charAt(i-1) == ' '){
                    if(i == s.length()-1 || !isNum(s.charAt(i+1))){
                        return false;
                    }
                }else if(i == s.length()-1 || s.charAt(i+1) == ' '){
                    if(i == 0 || !isNum(s.charAt(i-1))){
                        return false;
                    }
                }else if(!isNum(s.charAt(i-1)) || !isNum(s.charAt(i+1))){
                    return false;
                }
            }else if(isOperator(c)){
                pointNum = 0;
                if(!isNum(s.charAt(i+1))){
                    return false;
                }
            }else if(c == ' '){
                break;
            }else if(!isNum(c)){
                return false;
            }
        }
        for(; i < s.length(); i++){
            if(s.charAt(i) != ' '){
                return false;
            }
        }
        return true;
    }

    public boolean isNum(char c){
        if(c >= 48 && c <= 57){
            return true;
        }
        return false;
    }

    public boolean isOperator(char c){
        if(c == 43 || c == 45){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        T65有效数字 sol = new T65有效数字();
        String s = " 99e2.5 ";
        System.out.println(sol.isNumber(s));
    }
}
