package chengxi.linkedlist;

import java.util.Stack;

/**
 * @author 承夕
 * @date 2019/12/7 0007 - 23:01
 */
public class SingleLinkedList {
    public static void main(String[] args) throws Exception {
        SingleNode n1 = new SingleNode("张三", 4);
        SingleNode n2 = new SingleNode("李四", 2);
        SingleNode n3 = new SingleNode("王五", 5);
        SingleNode n4 = new SingleNode("赵六", 1);
        SingleNode n5 = new SingleNode("小七", 6);

        SingleNode n6 = new SingleNode("三", 3);
        SingleNode n7 = new SingleNode("四", 5);
        SingleNode n8 = new SingleNode("五", 7);
        SingleNode n9 = new SingleNode("六", 9);
        SingleNode n0 = new SingleNode("七", 11);

        SingleList list = new SingleList();
        SingleList list2 = new SingleList() ;
//        list.addBytail(n1);
//        list.addBytail(n2);
//        list.addBytail(n3);
//        list.addBytail(n4);
//        list.addBytail(n5);
        

        list.addByOrder(n1);
        list.addByOrder(n2);
        list.addByOrder(n3);
        list.addByOrder(n4);
        list.addByOrder(n5);

        list2.addByOrder(n6);
        list2.addByOrder(n7);
        list2.addByOrder(n8);
        list2.addByOrder(n9);
        list2.addByOrder(n0);

        //list.deleteNode(2);
        //list.deleteNode(1);
        
//        int count = list.validKey() ;
//        System.out.println(count);
//
//        System.out.println(list.LastIndexPoint(2));
//        System.out.println("------------------------");
//
//        list2.show();
//        System.out.println("--------------");
//        list.reverseListIterate();
//        list.show();
//        System.out.println("---------------------");
//        list.reverseListRecursive(list.getHead());
//        list.show();
//        System.out.println("----------------------");
//        list.showReverse(list.getHead());
//        System.out.println("----------------------");
//        list.showByStack();
//
//        list.show();
//        System.out.println("---------------");
//        list2.show();

        //list.combineList(list2);
//        list.combineList2(list, list2);
//        list.show();
        list.combineList(list ,list2);
        list.show();



    }
}



