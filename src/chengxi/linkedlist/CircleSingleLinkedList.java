package chengxi.linkedlist;

/**
 * @author 承夕
 * @date 2019/12/11 0011 - 9:56
 */
public class CircleSingleLinkedList {
    public static void main(String[] args) throws Exception {
        CircleNode n1 = new CircleNode("张三", 23);
        CircleNode n2 = new CircleNode("李四", 24);
        CircleNode n3 = new CircleNode("王五", 25);
        CircleNode n4 = new CircleNode("赵六", 26);
        CircleNode n5 = new CircleNode("小七", 27);
//
        CircleSingleList list = new CircleSingleList();

        list.addBytail(n1);
        list.addBytail(n2);
        list.addBytail(n3);
        list.addBytail(n4);
        list.addBytail(n5);

        list.deleteNode(24);
        list.deleteNode(26);
        list.deleteNode(27);


        list.show();
//
//        list.show();

        //约瑟夫环问题求解
//        for (int i = 1; i <= 5; i++) {
//            list.addBytail(new CircleNode("", i));
//        }
//        list.delete(3);
//        list.show();

    }
}

//链表类
class CircleSingleList{
    private CircleNode head ;

    //构造器
    public CircleSingleList() {
    }

    //循环链表添加操作
    public void addBytail(CircleNode node) {
        if (head == null) {
            head = node ;
            node.setNext(head);
            return ;
        }
        CircleNode temp = head ;
        while (true) {
            if(temp.getNext() == head ){
                break ;
            }
            temp = temp.getNext() ;
        }
        temp.setNext(node);
        node.setNext(head);
    }

    //    //删除节点
//    public void deleteNode(int number) throws Exception {
//        if (head == null) {
//            throw new Exception("链表空");
//        }
//        //删除头
//        if (head.getNumber() == number) {
//            CircleNode temp = head.getNext() ;
//            while (true) {
//                if (temp.getNext() == head) {
//                    break ;
//                }
//                temp = temp.getNext() ;
//            }
//            temp.setNext(temp.getNext().getNext());
//            head = temp.getNext() ;
//            return ;
//        }
//        CircleNode temp = head ;
//        while(true){
//            if (temp.getNext().getNumber() == number) {
//                break ;
//            }
//            if (temp.getNext() == head) {
//                System.out.println("输入错误，，没有找到对应节点");
//                return ;
//            }
//            temp = temp.getNext() ;
//        }
//        temp.setNext(temp.getNext().getNext());
//    }
    //删除节点
    public void deleteNode(int number) throws Exception {
        if (head.getNext() == head) {
            throw new Exception("链表是空");
        }
        CircleNode temp = head;
        while (true) {
            if (temp.getNext() == head) {
                if (head.getNumber() == number) {
                    temp.setNext(temp.getNext().getNext());
                    head = temp.getNext();
                    return ;
                }else{
                    System.out.println("输入错误，没有找到节点");
                    return ;
                }
            }
            if (temp.getNext().getNumber() == number) {
                break;
            }
            temp = temp.getNext() ;
        }
        temp.setNext(temp.getNext().getNext());
    }

    //约瑟夫环问题
    public CircleNode delete(int n){
        while (true) {
            if (head.getNext() == head) {
                return head;
            }
            CircleNode temp = head;
            for (int i = 1; i < n -1; i++) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
            head = temp.getNext();
        }
    }

    //打印链表
    public void show() throws Exception {
        if (head == null) {
            throw new Exception("链表是空了");
        }
        CircleNode temp = head ;
        while (true) {
            System.out.println(temp);
            if(temp.getNext() == head ){
                break ;
            }
            temp =temp.getNext() ;
        }
    }
}
//节点类
class CircleNode{
    private String name;
    private int number ;
    private CircleNode next ;

    //构造器
    public CircleNode(String name, int number) {
        this.name = name ;
        this.number = number ;
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

    public CircleNode getNext() {
        return next;
    }

    public void setNext(CircleNode next) {
        this.next = next;
    }

    //重写toString方法

    @Override
    public String toString() {
        return "CircleNode{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}