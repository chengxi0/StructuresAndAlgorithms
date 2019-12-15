package chengxi.recursion;

/**
 * @author 承夕
 * @date 2019/12/15 0015 - 18:01
 * @contact:https://github.com/chengxi0
 */
public class MazeProplem {
    private int[][] arr = new int[8][8] ;
    private int flag  = 2 ;
    public static void main(String[] args) {
        MazeProplem mp = new MazeProplem();
        mp.setWall();

        mp.find(1, 1);

        mp.show();


    }


    //显示迷宫最后结果
    public void show() {
        for (int[] i : arr) {
            for (int j : i) {
                System.out.print(j + "    ");
            }
            System.out.println();
        }
    }

    //设置迷宫路障
    public void setWall() {
        //设置边界 用数字1 表示
        for (int i = 0; i < 8; i++) {
            arr[0][i] = 1 ;
            arr[7][i] = 1 ;
            arr[i][0] = 1 ;
            arr[i][7] = 1 ;
        }

        //简单设置几座墙
        arr[3][1] = 1 ;
        arr[3][2] = 1 ;
        arr[3][3] = 1 ;

    }

    //找路
    public boolean find(int i, int j) {
        if (i == 6 && j == 6) {
            return true ;
        }
        else {
            if (arr[i][j] == 0) {
                //假定是可以走的路，其实也是后面避免继续往回无限递归
                //3 表示这个条路是死路
                //这样可以形象的直到程序怎么运行
                arr[i][j] = flag ++ ;
                System.out.println(" i = " + i + " j " + j );
                //定义走法为下左上右
                if (find(i + 1, j)) {
                    return true;
                } else if (find(i, j - 1)) {
                    return true;
                } else if (find(i - 1, j)) {
                    return true;
                } else if (find(i, j + 1)) {
                    return true;
                } else {
                    arr[i][j] = 3;
                    return false;
                }
            }else{
                return false ;
            }

        }
    }
}
