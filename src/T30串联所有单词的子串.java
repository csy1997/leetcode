import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class T30串联所有单词的子串 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) return res;
        int wordLength = words[0].length();
        if(words.length * wordLength > s.length()) return res;
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for(int j = 0; j < wordLength; j++){
            HashMap<String, Integer> temp = new HashMap<>();
            int count = 0;
            int i = j;
            while(i <= s.length()-wordLength){
                String sub = s.substring(i, i+wordLength);
                if(!map.containsKey(sub)){
                    count = 0;
                    temp.clear();
                }else{
                    count++;
                    temp.put(sub, temp.getOrDefault(sub, 0) + 1);
                    while(temp.get(sub) > map.get(sub)){
                        int beg = i - (count-1) * wordLength;
                        String sub2 = s.substring(beg, beg+wordLength);
//                        if(temp.equals(map)){
//                            res.add(beg);
//                        }
                        count--;
                        temp.put(sub2, temp.getOrDefault(sub2, 0) - 1);
                    }
                    if(count == words.length){
                        res.add(i - (count-1) * wordLength);
                    }
                }
                i+=wordLength;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        T30串联所有单词的子串 sol = new T30串联所有单词的子串();
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar","foo","the"};
        List<Integer> res = sol.findSubstring(s, words);
        for(int x : res){
            System.out.println(x+" ");
        }
    }
}
