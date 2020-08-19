package 分治法.mi乘问题.fibonacci数列;

/**
 * 利用数列的矩阵幂通项，对其进行加速
 */
public class SolutionDC {
    // 第一个数0，第二个1，第三个1
    private final int[][] firstMatrix = {{1,1},{1,0}};

    public int getFibonacciN(int n) {
        if(n == 1) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }
        int[][] res = powMatrix(firstMatrix, n-2);
        return res[0][0];
    }

    // 矩阵快速幂
    private int[][] powMatrix(int[][] matrix, int n) {
        if(n == 1) {
            return matrix;
        }
        int remain = n%2;
        int[][] temp = powMatrix(matrix, n/2);
        temp = multiplyMatrix(temp, temp);
        if(remain == 1) {
            temp = multiplyMatrix(temp, matrix);
        }
        return temp;
    }

    // 矩阵乘法
    private int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] res = new int[2][2];
        res[0][0] = matrix1[0][0]*matrix2[0][0] + matrix1[0][1]*matrix2[1][0];
        res[0][1] = matrix1[0][0]*matrix2[0][1] + matrix1[0][1]*matrix2[1][1];
        res[1][0] = matrix1[1][0]*matrix2[0][0] + matrix1[1][1]*matrix2[1][0];
        res[1][1] = matrix1[1][0]*matrix2[0][1] + matrix1[1][1]*matrix2[1][1];
        return res;
    }

    public static void main(String[] args) {
        SolutionDC sol = new SolutionDC();
        System.out.println(sol.getFibonacciN(6));
    }
}
