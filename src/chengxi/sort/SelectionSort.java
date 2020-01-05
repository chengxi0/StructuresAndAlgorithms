package chengxi.sort;

import java.util.Arrays;

/**
 * 选择排序
 * a 与冒泡排序有异曲同工之妙，就是每一趟用当前这个数与后面的数进行比较
 * 如果不符合顺序就进行交换
 * b 时间复杂度 O(n^2)
 * @author 承夕
 * @date 2020/1/5 0005 - 16:29
 * @contact:https://github.com/chengxi0
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {2, 1, 45, 23, -3, 44, 23};
        for (int i = 0; i < array.length - 1 ; i++) {
            //j = i + 1 从当前个的下一个开始比较
            for (int j = i + 1; j < array.length ; j++) {
                if (array[i] > array[j]) {
                    int max = array[j];
                    array[j] = array[i];
                    array[i] = max ;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
/*
选择排序：基本思想和冒泡排序差不多，每趟比较把外循环的当前元素作为基准，一遍结束后
把基准后移一位
假设array有array.length() = 5个数据待排序：
第 0 趟 把array[0] 作为基准，把array[0 + 1]作为与之比较的第一个数，遍历后面的，找出后面最小的
第 1 趟 把array[1] 作为基准，把array[1 + 1]作为与之比较的第一个数，遍历后面的，找出后面最小的
第 2 趟 把array[2] 作为基准，把array[2 + 1]作为与之比较的第一个数，遍历后面的，找出后面最小的
第 3 趟 把array[3] 作为基准，把array[3 + 1]作为与之比较的第一个数，遍历后面的，找出后面最小的
.。。。
内外循环的规律就显示出来了
第 i 趟 ---> 从 i + 1 开始比较 直到 array.length()
 */