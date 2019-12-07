package chengxi.queue;

import java.util.Stack;

/**需求：
 * Q是一个队列，S是一个空栈，实现将队列中的元素逆置的算法
 * (直接调用Stack)
 * @author 承夕
 * @date 2019/12/7 0007 - 10:16
 */
public class ReverseQueue {
    public static void main(String[] args) throws Exception {
        //1.创建一个空栈和一个带数据的队列
        Stack<String > stack = new Stack<>();
        AQueue<String> queue = new AQueue<>(4);
        queue.enterQueue("国");
        queue.enterQueue("家");
        queue.enterQueue("富");
        queue.enterQueue("裕");

        //2.把队列的每个元素分别放进栈
        while (!queue.isEmpty()) {
            stack.push(queue.deleteQueue());
        }

        //再把栈里面的元素添加到队列
        while (!stack.isEmpty()) {
            queue.enterQueue(stack.pop());
        }
        queue.show();

    }
}
