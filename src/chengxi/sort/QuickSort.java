package chengxi.sort;

import java.util.Arrays;

/**
 * 快速排序
 * @author 承夕
 * @date 2020/1/13 0013 - 21:08
 * @contact:https://github.com/chengxi0
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {2, 1, 45, 23, -3, 44, 23};
        quicksort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quicksort(int[] array, int left, int right) {
        //快速排序依赖于递归实现，因此必须要有递归返回的条件
        if (left >= right ) {
            return ;
        }
        int head = left ;
        int tail = right ;
        int key = array[left];

        while(head != tail){
            //移动的顺序十分重要，先移动右边的找到一个比key小的数
            while (array[tail] > key && head < tail) {
                tail --;
            }
            //注意这里有一个 = 因为我们是把做左边第一个作为key
            //因此这里必须需要 = ，不然无法左边向右边移动
            while (array[head] <= key && head < tail) {
                head ++ ;
            }
            //只要 head < tail 前面已经找到交换的位置了，在这里交换
            if (head < tail) {
                int temp = array[head];
                array[head] =array[tail];
                array[tail] = temp ;
            }
        }
        //调换循环后的key值到中间
        array[left] = array[tail];
        array[tail] = key ;
        //递归的时候注意要用原参数,head tail 在开始到这里已经发生变化
        quicksort(array, left, tail - 1);
        quicksort(array, tail + 1, right);
    }

}
