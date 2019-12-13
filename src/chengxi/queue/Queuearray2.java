package chengxi.queue;

import java.util.Scanner;

/**
 * @author 承夕
 * @date 2019/12/5 0005 - 16:26
 */
public class Queuearray2 {
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
class AQueue2<E>{
    private int front ;     //头指针
    private int rear ;      //尾指针
    private int maxsize ;   //队列容量
    private int validKey ;  //队列有效数据个数
    private Object[] arr ;

    //构造器
    public AQueue2(int maxsize) {
        this.maxsize = maxsize ;
        arr = new Object[maxsize];
    }

    //判断队列是否空
    public boolean isEmpty() {
        return validKey == 0 ;
    }

    //判断队列是否满
    public boolean isFull() {
        return validKey == maxsize ;
    }

    //入队
    public void enterQueue(E e) throws Exception {
        if (isFull()) {
            throw new Exception("队列已经满了");
        }
        rear ++ ;
        validKey ++ ;
        arr[rear  % maxsize] = e ;
    }

    //出队
    public E deleteQueue() throws Exception {
        if(isEmpty()){
            throw new Exception("队列已经空了");
        }
        front ++ ;
        Object obj = arr[front  % maxsize];
        arr[front  % maxsize] = null ;
        validKey -- ;
        return (E) obj;
    }

    //获取队列头数据
    public E getHead() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列已经是空的了");
        }
        return (E) arr[(front + 1) % maxsize];
    }

    //队列有效数据个数
    public int getValidKey() {
        return validKey;
    }

    //打印队列
    public void show() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列已经是空的了");
        }
        for (int i = 1; i <= getValidKey(); i++) {
            System.out.println(arr[(front + i) % maxsize]);
        }
    }
}
