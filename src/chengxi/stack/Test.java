package chengxi.stack;

import java.util.Scanner;

/**
 * 测试数组实现的栈结构
 * @author 承夕
 * @date 2019/12/11 0011 - 23:15
 */
public class Test {
    public static void main(String[] args) throws Exception {
        MyArrayStack<String> stack = new MyArrayStack<>(3);
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
                    stack.push(str);
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
