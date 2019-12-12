package chengxi.stack;

/**
 * @author 承夕
 * 数组实现栈结构的基本操作
 * @date 2019/12/11 0011 - 22:41
 */
public class MyArrayStack<E> {
    private int maxsize ;
    private Object[] arr;
    private int front ;

    //构造器
    public MyArrayStack(int maxsize) {
        this.maxsize = maxsize;
        arr = new Object[maxsize];
        front = -1 ;
    }

    //判断空
    public boolean isEmpty() {
        return front == -1 ;
    }

    //判断满
    public boolean isFull() {
        return front == maxsize-1 ;
    }

    //入栈
    public void push(E e) throws Exception {
        if (isFull()) {
            throw new Exception("栈已经满");
        }
        front ++ ;
        arr[front] = e;
    }

    //出栈
    public E pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("栈已经空");
        }
        Object obj = arr[front];
        arr[front] = null ;
        front -- ;
        return (E) obj;
    }

    //查看栈顶对象
    public E peek() {
        return (E) arr[front];
    }

    //返回对象在堆栈基于上面1的位置
    public int search(Object o) {
        for (int i = front; i >= 0; i--) {
            if(arr[i] == o){
                return front - i ;
            }
        }
        return -1 ;
    }

    //返回元素个数
    public int getNumber() {
        return front + 1 ;
    }

    //遍历栈
    public void show() throws Exception {
        if (isEmpty()) {
            throw new Exception("栈空");
        }
        for (int i = front; i >= 0 ; i--) {
            System.out.println(arr[i]);
        }
    }

}
