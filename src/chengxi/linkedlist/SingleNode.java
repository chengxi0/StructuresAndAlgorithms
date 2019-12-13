package chengxi.linkedlist;

/**
 * @author 承夕
 * @date 2019/12/11 0011 - 23:27
 */
public class SingleNode {

        private String name ;           //数据域
        private int number ;               //数据域
        private chengxi.linkedlist.SingleNode next ;       //指向下一个节点

        //构造器
        public SingleNode(String name, int age) {
            this.name = name ;
            this.number = age ;
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

        public void setAge(int age) {
            this.number = age;
        }

        public chengxi.linkedlist.SingleNode getNext() {
            return next;
        }

        public void setNext(chengxi.linkedlist.SingleNode next) {
            this.next = next;
        }

        //记得重写ToString方法
        @Override
        public String toString() {
            return "SingleNode{" +
                    "name='" + name + '\'' +
                    ", age=" + number +
                    '}';
        }
    }




