import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class T47全排列II {
    List<Integer> list = new ArrayList<>();
    int l;
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        for(int n : nums){
            list.add(n);
        }
        l = list.size();
//        quickSort(0, l-1);
        addToList(0);
        return res;
    }

    public void addToList(int beg){
        if(beg == l-1){
            res.add((List)((ArrayList)list).clone());
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = beg; i < l; i++){
            if(i == beg){
                set.add(list.get(i));
                addToList(beg+1);
            }else if(!set.contains(list.get(i))){
                set.add(list.get(i));
                swap(i, beg);
                addToList(beg+1);
                swap(i, beg);
            }
        }
    }

    public void swap(int i, int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public void quickSort(int left, int right) {
        if(left >= right) {
            return;
        }
        int p = left;
        int mid = list.get(right);
        for(int i = left; i <= right; i++) {
            if(list.get(i) <= mid) {
                swap(i, p);
                p++;
            }
        }
        quickSort(left, p-2);
        quickSort(p, right);
    }
}
