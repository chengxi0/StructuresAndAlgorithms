package chengxi.sort;

import java.util.Arrays;

/**
 * 希尔排序(缩小增量排序)
 * 是直接插入排序算法的一种更加高效的改进版本
 * @author 承夕
 * @date 2020/1/12 0012 - 22:19
 * @contact:https://github.com/chengxi0
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] array = {2, 1, 45, 23, -3, 44, 23, 4, 26, 12};
        //其实写的时候，记住类比于插入排序就行，只是多一个分组步骤
        for (int step = array.length / 2; step > 0; step /= 2) {
            //以下的两个for循环就是与插入排序一模一样
            for (int i = step; i < array.length; i ++) {
                int temp = array[i];
                int k = i ;
                for (int j = i - step; j >= 0; j -= step) {
                    if (array[j] < temp) {
                        break ;
                    } else {
                        k = j ;
                        array[j + step] = array[j];
                    }
                }
                array[k] = temp ;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
/*
希尔排序的速度还是比较快的，算法思想也不难理解，只要理解好
插入排序，那么理解这个希尔排序而只是一点点功夫的问题。注意点就是
步长的问题。
 */