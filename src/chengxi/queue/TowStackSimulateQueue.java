package chengxi.queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 需求：
 * 利用两个栈S1/ S2模拟一个队列
 * @author 承夕
 * @date 2019/12/7 0007 - 10:32
 */
public class TowStackSimulateQueue {
    public static void main(String[] args) {
//        //1.创建两个栈，s1 和 s2 向s1添加元素
//        Stack<String> s1 = new Stack<>();
//        Stack<String> s2 = new Stack<>();
//
//        s1.push("家");
//        s1.push("庭");
//        s1.push("美");
//        s1.push("好");
//
//        //2.把s1的元素都放进
//        while (!s1.isEmpty()) {
//            s2.push(s1.pop());
//        }
//
//        //3.再把s2的元素弹出
//        while (!s2.isEmpty()) {
//            System.out.println(s2.pop());
//        }

        TSQueue<String> queue = new TSQueue<>(3);
        Scanner sc = new Scanner(System.in);
        char key = ' ';
        boolean loop = true ;
        while (loop) {
            System.out.println("显示队列 : s");
            System.out.println("添加到队列 : a");
            System.out.println("从队列删除 : d");
            System.out.println("获取队列头数据 : g");
            System.out.println("显示队列有效数据个数 : v");

            key = sc.nextLine().charAt(0);

            switch (key) {
                case 'a' :
                    try{
                        System.out.println("请输入你要添加的：");
                        String str = sc.nextLine();
                        queue.enterQueue(str);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break ;
                case 's':
                    try {
                        queue.show();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break ;
                case 'd':
                    try {
                        queue.deleteQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break ;
                case 'g':
                    try {
                        System.out.println(queue.getHead());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break ;
                case 'v':
                    System.out.println(queue.getValideKey());
                    break ;
                case 'e':
                    loop = false ;
                    sc.close();
                    break ;
                default :
                    break ;
            }
        }
    }
}
class TSQueue<E>{
    private int maxsize ;       //队列的大小
    private int valideKey ;     //有效数据个数
    Stack<E> s1 ;               //栈1
    Stack<E> s2 ;               //栈2

    //构造器
    public TSQueue(int maxsize){
        this.maxsize = maxsize ;
        s1 = new Stack<>();
        s2 = new Stack<>() ;
    }

    //判断空
    public boolean isEmpty() {
        return valideKey == 0 ;
    }

    //判断满
    public boolean isFull() {
        return valideKey == maxsize;
    }

    //入队操作
    public void enterQueue(E e) throws Exception {
        if (isFull()) {
            throw new Exception("队列已经满了");
        }
        s1.push(e);
        valideKey ++;
    }

    //出队
    public E deleteQueue() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列已经空了");
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        E eo = s2.pop() ;
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        valideKey -- ;
        return eo;
    }

    //获取队列头部数据
    public E getHead() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        E eo = s2.peek();
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return eo ;
    }

    //获取有效数据个数
    public int getValideKey() {
        return valideKey ;
    }

    //打印队列
    public void show() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列已经满了");
        }
        //把所有s1的元素放到s2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        //然后查看s2顶部元素，再放回s1 ，直到s2为空
        while (!s2.isEmpty()) {
            System.out.println(s2.peek());
            s1.push(s2.pop());
        }
    }

}