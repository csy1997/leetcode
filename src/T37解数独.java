import java.util.ArrayList;
import java.util.List;

public class T37解数独 {
    NumsList[][] tab;
    boolean bool = true;

    class NumsList{
        public List<Character> nums;
        public NumsList(){
            this.nums = new ArrayList<>();
            for(int i = 1; i <= 9; i++){
                this.nums.add((char) (i+48));
            }
        }
        public NumsList(char c){
            this.nums = new ArrayList<>();
            this.nums.add(c);
        }
        public boolean isSingle(){
            return this.nums.size() == 1;
        }
        public boolean isEmpty() { return this.nums.size() == 0; }
        public void delete(char c){
            if(this.nums.contains(c)){
                this.nums.remove(Character.valueOf(c));
            }
        }
    }

    public void solveSudoku(char[][] board) {
        this.tab = new NumsList[9][9];
//        boolean b = false;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char temp = board[i][j];
                if(temp != '.'){
                    this.tab[i][j] = new NumsList(temp);
                }else{
                    this.tab[i][j] = new NumsList();
                }
            }
        }
        fill1();
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(tab[i][j].nums+" ");
            }
            System.out.println();
        }
        fill2();

        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(tab[i][j].nums+" ");
            }
            System.out.println();
        }
//        while(!b){
//            b = true;
//            for(int i = 0; i < 9; i++) {
//                for (int j = 0; j < 9; j++) {
//                    fill(i, j);
//                    b = b && tab[i][j].isSingle();
//                }
//            }
//            System.out.println("第"+t+"次：");
//            for(int i = 0; i < 9; i++) {
//                for (int j = 0; j < 9; j++) {
//                    System.out.print(tab[i][j].nums+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//            t++;
//        }
//        for(int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                board[i][j] = tab[i][j].nums.get(0);
//                System.out.print(board[i][j]+" ");
//            }
//            System.out.println();
//        }
    }

    public void fill1(){
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                fill1(i, j);
//                b = b && tab[i][j].isSingle();
            }
        }
    }

    public void fill1(int i, int j){
        if(!bool){
            return;
        }
        if(tab[i][j].isEmpty()){
            bool = false;
            return;
        }
        if(!tab[i][j].isSingle()){
            return;
        }
        char c = tab[i][j].nums.get(0);
        for(int k = 0; k < 9; k++){
            if(!tab[k][j].isSingle()){
                tab[k][j].delete(c);
                fill1(k, j);
            }
        }
        for(int k = 0; k < 9; k++){
            if(!tab[i][k].isSingle()){
                tab[i][k].delete(c);
                fill1(i, k);
            }
        }
        for(int k = (i/3)*3; k < (i/3+1)*3; k++){
            for(int l = (j/3)*3; l < (j/3+1)*3; l++){
                if(!tab[k][l].isSingle()){
                    tab[k][l].delete(c);
                    fill1(k, l);
                }
            }
        }
    }

    public boolean fill2(){
        int m = 0;
        int n = 0;
        int minL = Integer.MAX_VALUE;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (tab[i][j].nums.size() > 1 && tab[i][j].nums.size() < minL) {
                    m = i;
                    n = j;
                    minL = tab[i][j].nums.size();
                }
            }
        }
        System.out.println(m+" "+n);
        if(minL == Integer.MAX_VALUE){
            return true;
        }
        NumsList[][] newTab = tab;
        List<Character> mn = newTab[m][n].nums;
        for(int i = 0; i < mn.size(); i++){
            for(int k = 0; k < 9; k++){
                for(int j = 0; j < 9; j++){
                    tab[k][j] = new NumsList();
                    tab[k][j].nums = (List)((ArrayList)newTab[k][j].nums).clone();
                }
            }
            System.out.println(mn);
            tab[m][n].nums.clear();
            System.out.println(mn);
            System.out.println(i);
            tab[m][n].nums.add(mn.get(i));
            bool = true;
            fill1(m, n);
            if(!bool){
                continue;
            }
            if(fill2()){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        T37解数独 sol = new T37解数独();
        char[][] board = {{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}};
        for(char[] ch : board){
            for(char c : ch){
                System.out.print(c+" ");
            }
            System.out.println();
        }
        System.out.println();
        sol.solveSudoku(board);
//        List<Character> list = new ArrayList<>();
//        list.add('1');
//        list.add('2');
//        list.add('3');
//        list.add('4');
//        list.remove(Character.valueOf('1'));
//        System.out.println(list);
//        List<Integer> a = new ArrayList<>();
//        List<Integer> b = new ArrayList<>();
//        a.add(1);
//        a.add(2);
//        b.add(1);
//        b.add(2);
//        System.out.println(a.equals(b));
    }
}
