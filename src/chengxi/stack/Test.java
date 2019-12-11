package chengxi.stack;

/**
 * @author 承夕
 * @date 2019/12/11 0011 - 23:15
 */
public class Test {
    public static void main(String[] args) throws Exception {
        MyArrayStack<String> stack = new MyArrayStack<>(3);
        stack.push("我喜欢你");
        stack.push("我欢你");
        stack.push("我喜你");

        stack.show();

    }
}
