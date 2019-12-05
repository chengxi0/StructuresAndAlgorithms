package chengxi.queue;

import java.util.Scanner;

/**
 * @author 承夕
 * @date 2019/12/5 0005 - 12:36
 */
public class Queuearray {
    public static void main(String[] args) {
        AQueue<String> queue = new AQueue<>(3);
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
                    System.out.println(queue.validKey());
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
class AQueue<E>{
    private int front ;     //头指针
    private int rear ;      //尾指针
    private int maxsize ;   //队列容量
    private Object[] arr ;  //数组实现

    //构造器 ，为队列分配储存空间
    public AQueue(int maxsize) {
        this.maxsize = maxsize + 1 ;
        arr = new Object[maxsize + 1];      //留空一个位置
    }

    //判断是否为空
    public boolean isEmpty() {
        return rear == front ;
    }

    //判断是否满
    public boolean isFull() {
        return (rear + 1) % maxsize == front ;
    }

    //计算队列有效数据个数
    public int validKey() {
        return ( rear - front + maxsize) % maxsize ;
    }

    //入队
    public void enterQueue(E e) throws Exception {
        if (isFull()) {
            throw new Exception("队列已经满了");
        }
        rear ++ ;
        arr[rear % maxsize] = e ;
    }

    //出队
    public E deleteQueue() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列已经空了");
        }
        front ++ ;
        Object obj = arr[front % maxsize];
        arr[front % maxsize] = null ;
        return (E)obj ;
    }

    //获取头节点数据
    public E getHead() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列已经空了");
        }
        return (E) arr[(front + 1) % maxsize];
    }

    //打印队列
    public void show() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列已经空了");
        }
        for(int i = 1 ; i <= validKey()  ; i++ )
        {
            System.out.println(arr[(front + i) % maxsize]);
        }
    }
}