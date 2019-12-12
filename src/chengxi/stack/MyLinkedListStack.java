package chengxi.stack;


/**
 * @author 承夕
 * 链表实现栈结构的基本操作
 * @date 2019/12/11 0011 - 23:20
 */
public class MyLinkedListStack<E> {
    private Node<E> head ;
    private int size ;
    private int maxsize ;

    //构造器
    public MyLinkedListStack(int maxsize) {
        head = new Node<>(null);
        this.maxsize = maxsize ;
    }

    //入栈(应该使用头插入方式）一定要注意进栈的数据类型泛型需要统一
    public void push(Node<E> node) throws Exception {
        if (size == maxsize) {
            throw new Exception("链表已经满了");
        }
        node.setNext(head.getNext());
        head.setNext(node);
        size ++ ;
    }

    //出栈
    public Node pop() throws Exception {
        if (size == 0) {
            throw new Exception("链表已经空了");
        }
        Node node = head.getNext() ;
        head.setNext(node.getNext());
        size -- ;
        return node;
    }

    //查看栈顶对象
    public Node peek() throws Exception {
        if (size == 0) {
            throw new Exception("链表已经空了");
        }
        return head.getNext() ;
    }

    //返回元素个数
    public int getNumber() {
        return size ;
    }

    //打印链表
    public void show() throws Exception {
        if (size == 0) {
            throw new Exception("链表已经空了");
        }
        Node temp = head.getNext() ;
        while (true) {
            if (temp == null) {
                break ;
            }
            System.out.println(temp);
            temp = temp.getNext() ;
        }
    }
}
