package chengxi.queue;

import java.util.Scanner;

/**
 * @author 承夕
 * @date 2019/12/5 0005 - 22:34
 */
public class Linkedqueue {
    public static void main(String[] args) throws Exception {
        LQueue lq = new LQueue();
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
                case 's' :
                    try {
                        lq.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break ;
                case 'a' :
                    System.out.println("请输入你要添加的数据(int)");
                    int a = Integer.parseInt(sc.nextLine());
                    lq.enterQueue(new Node(a));
                    break ;
                case 'd' :
                    try{
                        lq.deleteQueue();
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break ;
                case 'g' :
                    try{
                        System.out.println(lq.getHead());;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break ;
                case 'v' :
                    System.out.println(lq.validKey());
                    break ;
                case 'e' :
                    loop = false ;
                    break ;
                default :
                    break ;
            }
        }


    }

    
}

//主要就是对链表的操作熟不熟悉而已
class LQueue {
    private Node head ;
   // private  int maxsize ;

    //构造链表
//    public LQueue(int maxzise) {
//        this.maxsize = maxzise ;
//        head = new Node(0);
//    }
    public LQueue() {
        head = new Node(0);
    }

    //判断队列是否空
    public boolean isEmpty() {
        return head.getNext() == null ;
    }

    //    //判断队列是否满
//    因为这个是链表实现的队列，链表的元素的个数可以无限增长
//    无需要验满
    //但是你如果需要处理好长度可以判断一个数值
//    public boolean isFull() {
//        return validKey() == maxsize ;
//    }

    //入队操作
    public void enterQueue(Node node) {
        //本质上就是带头链表的尾添加操作
        if (isEmpty()) {
            head.setNext(node);
            return ;
        }
        Node temp = head.getNext() ;
        while (true) {
            if (temp.getNext() == null) {
                break ;
            }
            temp = temp.getNext();
        }
        temp.setNext(node);
    }

    //退队
    public Node deleteQueue() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列空了");
        }
        Node temp = head.getNext();
        head.setNext(head.getNext().getNext());
        return temp ;
    }

    //队列有效数据个数
    public int validKey() {
        int k = 0 ;
        if (isEmpty()) {
            return k ;
        }
        Node temp = head.getNext() ;
        while (true) {
            if (temp == null) {
                break ;
            }
            k ++ ;
            temp = temp.getNext();
        }
        return k ;
    }

    //获取头队列
    public Node getHead() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列空了");
        }
        return head.getNext();
    }

    //打印队列
    public void showQueue() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列空了");
        }
        Node temp = head.getNext() ;
        while (true) {
            if (temp == null) {
                break ;
            }
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

}

//链表实现队列
class Node {
    private int data ;      //数据
    private Node next ;     //指向下一个数据

    //构造器
    public Node(int data) {
        this.data = data ;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}

