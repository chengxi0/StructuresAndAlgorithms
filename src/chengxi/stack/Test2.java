package chengxi.stack;

import java.util.Scanner;

/**
 * @author 承夕
 * 测试用链表实现的栈结构
 * @date 2019/12/12 0012 - 18:32
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
//        MyLinkedListStack<String> stack = new MyLinkedListStack<>(4);
//        Node<String> n1 = new Node<>("shibushi");
//        Node<String> n2 = new Node<>("shibi");
//        Node<String> n3 = new Node<>("sh");
////        Node<Integer> n4 = new Node<>(32);
//
//        stack.push(n1);
//        stack.push(n2);
//        stack.push(n3);
////        stack.push(n4);
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println("-------------------");
//        stack.show();

        MyLinkedListStack<String> stack = new MyLinkedListStack<>(3);
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        char key = ' ';
        while (loop) {
            System.out.println("入栈p");
            System.out.println("出栈c");
            System.out.println("元素个数n");
            System.out.println("返回栈顶元素k");
            System.out.println("遍历栈s");

            key = sc.nextLine().charAt(0);
            switch (key) {
                case 'p' :
                    System.out.println("请输入添加的元素");
                    String str =sc.nextLine();
                    Node<String> n = new Node<>(str);
                    stack.push(n);
                    break ;
                case 'c' :
                    System.out.println(stack.pop());
                    break ;
                case 'n' :
                    System.out.println(stack.getNumber());

                    break ;
                case 'k' :
                    System.out.println(stack.peek());
                    break ;
                case 's' :
                    stack.show();
                    break ;
                case 'e' :
                    loop =false ;
                    sc.close();
                    break ;
                default :
                    break ;
            }
        }
    }
}
