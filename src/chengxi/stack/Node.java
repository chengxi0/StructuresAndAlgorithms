package chengxi.stack;


/**
 * @author 承夕
 * @date 2019/12/12 0012 - 18:15
 */
public class Node<E> {
    private E e ;
    private Node next ;

    //构造器
    public Node(E e) {
        this.e = e ;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
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
                "e=" + e +
                '}';
    }
}


