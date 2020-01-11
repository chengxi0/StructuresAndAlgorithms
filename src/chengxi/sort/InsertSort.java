package chengxi.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 基本思想:
 * 把数组的第一个位置作为最初的有序表的第一个元素，然后逐个遍历原数组
 * 剩下的，插入到有序的数组中去。（可以类比于两个有序链表的合并操作）
 * @author 承夕
 * @date 2020/1/11 0011 - 9:57
 * @contact:https://github.com/chengxi0
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = {2, 1, 45, 23, -3, 44, 23};
        //从数组的第二个数开始进行插入到数组中
        for (int i = 1; i < array.length; i++) {
            //记录好这个待插入的元素的值和下标
            int temp = array[i];
            int k = i ;
            //在遍历前面的有序元素时边遍历便移动而且是从右向左
            for (int j = i - 1; j >= 0; j--) {
                if (temp > array[j]) {
                    //如果发现了合适的插入位置则跳出循环
                    break;
                }else{
                    //如果还没发现合适的插入位置
                    //记录好当前这个位置，元素移动一位
                    k = j;
                    array[j + 1] = array[j];
                }
            }
            //每一次作最后的插入
            array[k] = temp ;
        }
        System.out.println(Arrays.toString(array));
    }
}
/*
插入排序的注意事项:
a 在刚刚开始知道插入排序的原理时候，尝试自己动手根据原理去写，产生了一种错误的思路，
比如我们在进行插入的时候，我们是先找到那个位置再插入还是边找边移动插入。我开始想的是前者，
后来又迫于时间复杂度的问题，觉得这样想是不够准确的，最后看了很多人写的都是边找那个位置边移动，而不是找到那个位置
再统一移动。
b 个人的算法代码里面还是很多没有简洁起来，而且有一个小地方可以优化一点点，在进行相同数的比较的时候，我们可以把相同数只植入到
后面，这样可以减少一次移动元素
 */