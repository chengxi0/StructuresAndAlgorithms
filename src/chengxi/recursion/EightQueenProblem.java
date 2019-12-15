package chengxi.recursion;

/**
 * @author 承夕
 * 步骤分析：
 * a 对一维数组的解读 : 共有八个元素，每个元素的下标表示行，对应的每个值就是列数
 * b 每次每行放一次棋子，都必须判断是否冲突（即是否在同行同列，或者在同一个斜线上）
 * c 因此需要写一个判断的方法
 * d 在最后的时候需要打印数组和统计多少种 ，因此声明一个count变量
 * @date 2019/12/15 0015 - 21:44
 * @contact:https://github.com/chengxi0
 */
public class EightQueenProblem {
    private int max  = 8 ;
    int[] arr = new int[max];   //定义一个一维数组
    private static int count = 0 ;  //计数种数
    public static void main(String[] args) {

        EightQueenProblem e = new EightQueenProblem();
        //参数0 表示从第一行开始放起
        e.check(0);
        //多少种可能打印
        System.out.println(count);             // 92种

    }

    /**
     * 这是一个判断是否冲突的方法
      * @param n 表示放置第几个皇后
     * @return 布尔返回类型
     */
    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //先判断是否在同一列（不需要再讨论同一行）因为这是一维数组
            //再判断是否在同一个斜线上（利用行差等于列差，注意绝对值）
            if (arr[i] == arr[n] || Math.abs(i - n) == Math.abs(arr[i] - arr[n])) {
                return false ;
            }
        }
        return true ;
    }

    /**
    *@Author:承夕
    *@Description:
     * 展示可能的情况
     * @param: null
     *@return : void
     */
    public void show() {
        //因为每打印一次就说明成功一次，那么就记录一种可能
        count ++ ;
        for (int i : arr) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    /**
    *@Author:承夕
    *@Description:
     * 利用递归实现解决八皇后问题
     * @param: int n 说明在放置第几个皇后
     *@return : null
     */
    public void check(int n) {
        if (n == max) {
            show();
            return ;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i ;
            if (judge(n)) {
                check(n + 1 );
            }
        }
    }


}
