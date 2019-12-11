package chengxi.linkedlist;

import java.util.Stack;

/**
 * @author 承夕
 * @date 2019/12/11 0011 - 23:25
 */
public class SingleList {

        private SingleNode head ;       //带头节点的链表

        //构造器
        public SingleList() {
            head = new SingleNode("", 0);
        }

        //判断空
        public boolean isEmpty() {
            return head.getNext() == null ;
        }

        //添加到链表尾
        public void addBytail(SingleNode node) {
            if (isEmpty()) {
                head.setNext(node);
                return ;
            }
            SingleNode temp = head.getNext() ;
            while (true) {
                if(temp.getNext() == null){
                    break;
                }
                temp = temp.getNext() ;
            }
            temp.setNext(node);
        }

        //按指定顺序添加(由大到小)
        public void addByOrder(SingleNode node) {
            if (isEmpty()) {
                head.setNext(node);
                return ;            //注意使用的是return语句，这里实际就是讨论添加尾的情况
            }
            SingleNode temp = head;
            while (true) {
                if (temp.getNext() == null) {
                    temp.setNext(node);
                    return ;
                }
                //所有利用到getNext再使用其属性都需要注意空指针异常如temp.getNext().getNumber()
                if(node.getNumber() >= temp.getNext().getNumber()){
                    break ;
                }
                temp = temp.getNext();
            }
            //在连接是时候，先考虑连接后面，再连接前面
            node.setNext(temp.getNext());
            temp.setNext(node);
        }

        //查找某个节点的前一个节点
        private SingleNode checkPreNode(int number) throws Exception {
            if (isEmpty()) {
                throw new Exception("链表是空的无法查询和删除");
            }
            SingleNode temp = head ;
            while (true) {
                if (temp.getNext() == null) {
                    throw new Exception("指定点不存在无法查询和删除");
                }
                //所以这里也有空指针异常注意一下
                if (temp.getNext().getNumber() == number) {
                    break ;
                }
                temp = temp.getNext() ;
            }
            return temp;
        }

        //删除某个节点
        public SingleNode deleteNode(int number) throws Exception {
            SingleNode temp = checkPreNode(number).getNext();
            checkPreNode(number).setNext(temp.getNext());
            return temp ;
        }

        //求单链表的有效个数
        public int validKey() {
            int k = 0 ;
            if (isEmpty()) {
                return k ;
            }
            SingleNode temp = head.getNext() ;
            while (true) {
                if (temp == null) {
                    break ;
                }
                k ++ ;
                temp = temp.getNext() ;
            }
            return k ;
        }

        //返回单链表倒数第k个节点
        public SingleNode LastIndexPoint(int k) throws Exception {
            int valid = validKey() ;
            if (k <= 0 || k > valid) {
                throw new Exception("输入的k值无效");
            }
            SingleNode temp = head.getNext() ;
            for (int i = 0; i < valid - k; i++) {
                temp = temp.getNext() ;
            }
            return temp ;
        }

        //获取头
        public SingleNode getHead() throws Exception {
            if (isEmpty()) {
                throw new Exception("链表为空");
            }
            return head.getNext() ;
        }

        //链表反转（使用递归实现）
        public void reverseListRecursive(SingleNode hnode) {
            if (hnode.getNext() == null) {
                this.head.setNext(hnode);
            }else{
                reverseListRecursive(hnode.getNext());
                //注意下面两个步骤
                hnode.getNext().setNext(hnode);
                hnode.setNext(null);
            }

        }
        //链表反转（迭代实现）
        public void reverseListIterate() {
            if (isEmpty() || head.getNext().getNext() == null) {
                return;
            }
            SingleNode temp = head.getNext() ;
            SingleNode newhead = new SingleNode("", 0);
            while (true) {
                if (temp == null) {
                    break ;
                }
                SingleNode t = temp.getNext() ;
                temp.setNext(newhead.getNext());
                newhead.setNext(temp);
                temp = t ;
            }
            head = newhead ;        //别忘记这个就ok了
        }

        //链表合并（迭代实现）
        public void combineList1(chengxi.linkedlist.SingleList list) throws Exception {
            if(list.isEmpty()){
                return ;
            }
            SingleNode temp = list.getHead() ;
            while (true) {
                if(temp == null){
                    break ;
                }
                SingleNode t = temp.getNext() ;
                //注意这里也是把其后面的指向设置为空
                temp.setNext(null);
                addByOrder(temp);
                temp = t ;
            }
        }

//    //链表合并（递归实现）
//    private SingleNode combineNode(SingleNode head1, SingleNode head2) {
//        if (head1 == null) {
//            return head2 ;
//        }
//        if (head2 == null) {
//            return head1 ;
//        }
//        if (head1.getNumber() > head2.getNumber()) {
//            head1.setNext(combineNode(head1.getNext(),head2));
//            return head1 ;
//        }else{
//            head2.setNext(combineNode(head2.getNext(),head1));
//            return head2 ;
//        }
//    }
//
//    public void combineList2(SingleList list1, SingleList list2) throws Exception {
//        head.setNext(combineNode(list1.getHead(), list2.getHead()));
//    }

        //链表合并（递归实现）
        private SingleNode combineNode(SingleNode nhead1, SingleNode nhead2) {
            if (nhead1 == null) {
                return nhead2 ;
            }
            if (nhead2 == null) {
                return nhead1 ;
            }
            if(nhead1.getNumber() > nhead2.getNumber()){
                nhead1.setNext(combineNode(nhead1.getNext(),nhead2));
                return nhead1 ;
            }else{
                nhead2.setNext(combineNode(nhead2.getNext(), nhead1));
                return nhead2 ;
            }
        }

        public void combineList(chengxi.linkedlist.SingleList list1, chengxi.linkedlist.SingleList list2) throws Exception {
            head.setNext(combineNode(list1.getHead(), list2.getHead()));
        }

        //逆序打印(利用的递归实现）
        public void showReverse(SingleNode head) throws Exception {
            if (isEmpty()) {
                throw new Exception("链表已经空了");
            }
            if(head.getNext() == null){
                System.out.println(head);
            }else {
                showReverse(head.getNext());
                System.out.println(head);
            }
        }

        //逆序打印（栈结构实现）
        public void showByStack() throws Exception {
            if (isEmpty()) {
                throw new Exception("链表已经空了");
            }
            Stack<SingleNode> stack = new Stack<>() ;
            SingleNode temp = head.getNext() ;
            while (true) {
                if(temp == null){
                    break ;
                }
                stack.push(temp );
                temp = temp.getNext() ;
            }
            while (!stack.isEmpty()) {
                System.out.println(stack.pop());
            }
        }

        //打印链表
        public void show() {
            if (isEmpty()) {
                return ;
            }
            SingleNode temp = head.getNext() ;
            while (true) {
                if (temp == null) {
                    break ;
                }
                System.out.println(temp);
                temp = temp.getNext();
            }
        }
    }
