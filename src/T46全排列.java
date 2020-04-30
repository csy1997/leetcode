import java.util.ArrayList;
import java.util.List;

public class T46全排列 {
    List<Integer> list = new ArrayList<>();
    int l;
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        for(int n : nums){
            list.add(n);
        }
        l = list.size();
        addToList(0);
        return res;
    }

    public void addToList(int beg){
        if(beg == l-1){
            res.add((List)((ArrayList)list).clone());
            return;
        }
        for(int i = beg; i < l; i++){
            swap(i, beg);
            addToList(beg+1);
            swap(i, beg);
        }
    }

    public void swap(int i, int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void main(String[] args) {
        T46全排列 ob = new T46全排列();
        int[] nums = {1,2,3,4,5};
        System.out.println(ob.permute(nums));
    }
}
