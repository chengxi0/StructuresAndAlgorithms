package chengxi.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * a 每趟两两比较交换，找出最小或者最大的
 * b 数组有n个数就比较n -1 趟
 * 算法优化：
 * 如果出现了一趟中没有比较交换，那么就已经完成了排序
 * 就可以结束了
 *c 平均时间复杂度O(n^2)
 * @author 承夕
 * @date 2019/12/24 0024 - 19:44
 * @contact:https://github.com/chengxi0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {3 , 9 , -1 ,10 ,20};
        
        for (int i = 0; i < array.length - 1; i++) {
            //设置一个标志
            boolean flag = false ;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    //符合交换条件就改变flag
                    flag = true ;
                    int max = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = max;
                }
            }
            //一趟比较过后看看标志是否变化了
            if (!flag ) {
                break ;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
/*
在冒泡排序里面的最基本的思想就是每一趟就找一个剩下的最大或者最小的数，进行了array.length() - 1 趟数
而每趟里面有渐减的比较次数。因此整个冒泡排序的核心在于 趟数 和 比较次数
假设array有array.length() = 5个数据待排序：
第  1（0）   趟：从左向右，要找最大的数，必须比较        array.length() - 1 次
第  2（1）   趟：从左向右，要找次大的数，必须比较        array.length() - 2 次
第  3（2）  趟：从左向右，要找次次大的数，必须比较       array.length() - 3 次
第  4（3）  趟：从左向右，要找次次次大的数，必须比较      array.length() - 4 次
趟数：i  比较次数：array.length() - i （再 - 1）
因此：趟数和比较次数的关系就不言而喻了，也就是嵌套for循环的条件就搞定了
算法优化层面：
如果发现一趟中，没有进行交换，那么就说明这一趟的数据都符合顺序了，那么就没有必要
再继续下一趟了。因此用flag标记即可解决。
 */