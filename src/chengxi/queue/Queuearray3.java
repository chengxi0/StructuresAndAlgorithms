package chengxi.queue;

import java.util.Scanner;

/**
 * @author 承夕
 * @date 2019/12/7 0007 - 8:34
 */
public class Queuearray3 {
    public static void main(String[] args) {
        AQueue2<String> queue = new AQueue2<>(3);
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
                    System.out.println(queue.getValidKey());
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
class AQueue3<E>{
    private int front ;         //头
    private int rear ;          //尾
    private int maxsize ;       //队列最大容量
    private boolean flag ;      //标志
    private Object[] arr ;      //数组实现

    //构造器
    public AQueue3(int maxsize) {
        this.maxsize = maxsize ;
        front = -1 ;
        rear = -1 ;
        flag = false ;
        arr = new Object[maxsize];
    }

    //判断空
    public boolean isEmpty() {
        return front  == rear && flag == false ;
    }

    //判断满
    public boolean isFull() {
        return rear == front && flag == true ;
    }

    //入队
    public void enterQueue(E e) throws Exception {
        if (isFull()) {
            throw new Exception("队列已经满了");
        }
        rear = (rear + 1 ) % maxsize;
        arr[rear] = e ;
        flag = true ;
    }

    //出队
    public E deleteQueue() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列已经空了");
        }
        front = (front + 1 ) % maxsize ;
        Object obj = arr[front];
        arr[front ] = null ;
        flag = false ;
        return (E)obj ;
    }

    //队列有效数据个数
    public int validKey() {
        int k = 0 ;
        if (isEmpty()) {
            return k ;
        }
        for(int i = front ;i != rear ; i = (++ i) % maxsize){
            k++ ;
        }
        return k ;
    }

    //获取头
    public E getHead() {
        return (E) arr[(front + 1) % maxsize];
    }

    //打印队列
    public void show() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列已经满了");
        }
        for (int i = 1; i <= validKey(); i++) {
            System.out.println(arr[front + i]);
        }
    }

}