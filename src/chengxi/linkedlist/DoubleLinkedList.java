package chengxi.linkedlist;

/**
 * @author 承夕
 * @date 2019/12/11 0011 - 21:40
 */
public class DoubleLinkedList {
    public static void main(String[] args) throws Exception {
        DoubleNode n1 = new DoubleNode("张三", 23);
        DoubleNode n2 = new DoubleNode("李四", 24);
        DoubleNode n3 = new DoubleNode("王五", 25);
        DoubleNode n4 = new DoubleNode("赵六", 26);
        DoubleNode n5 = new DoubleNode("小七", 27);

        DoubleList list = new DoubleList() ;
        list.addBrTail(n1);
        list.addBrTail(n2);
        list.addBrTail(n3);
        list.addBrTail(n4);
        list.addBrTail(n5);

//        System.out.println(list.checkNode(26));
        list.delete(27);

        list.show();

    }
}

//链表类
class DoubleList{
    private DoubleNode head ;

    //构造器
    public DoubleList() {
        head = new DoubleNode("", 0);
    }

    //判断空
    public boolean isEmpty() {
        return head.getNext() == null;
    }

    //获取尾操作
    public DoubleNode getTail() throws Exception {
        if (head.getNext() == null) {
            throw new Exception("链表空了");
        }
        DoubleNode temp = head.getNext();
        while (true) {
            if (temp.getNext() == null) {
                break ;
            }
            temp = temp.getNext() ;
        }
        return temp ;
    }

    //添加尾
    public void addBrTail(DoubleNode node) throws Exception {
        if (isEmpty()) {
            head.setNext(node);
            node.setPre(head);
            return ;
        }
        //已经写了找尾节点的方法
//        DoubleNode temp = head ;
//        while (true) {
//            if (temp.getNext() == null) {
//                break;
//            }
//            temp = temp.getNext() ;
//        }
        DoubleNode temp = getTail();
        temp.setNext(node);
        node.setPre(temp);
    }

    //查找操作
    public DoubleNode checkNode(int number) throws Exception {
        if (isEmpty()) {
            throw new Exception("链表空");
        }
        DoubleNode temp = head.getNext() ;
        while (true) {
            if (temp == null) {
                throw new Exception("没有找到相关节点");
            }
            if (temp.getNumber() == number) {
                return temp ;
            }
            temp = temp.getNext() ;
        }
    }

    //删除操作
    public void delete(int number) throws Exception {
        DoubleNode temp = checkNode(number);
        if (temp == getTail()) {
            temp.getPre().setNext(null);
            return ;
        }
        temp.getPre().setNext(temp.getNext());
        temp.getNext().setPre(temp.getPre());
    }

    //打印链表
    public void show() throws Exception {
        if (isEmpty()) {
            throw new Exception("链表已经空");
        }
        DoubleNode temp = head.getNext();
        while (true) {
            if (temp == null) {
                break ;
            }
            System.out.println(temp);
            temp = temp.getNext() ;
        }
    }

}

//节点类
class DoubleNode{
    private String name ;
    private int number ;
    private DoubleNode next ;
    private DoubleNode pre ;

    //构造器
    public DoubleNode(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }

    public DoubleNode getPre() {
        return pre;
    }

    public void setPre(DoubleNode pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
