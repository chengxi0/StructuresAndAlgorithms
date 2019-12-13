package chengxi.stack;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 承夕
 *需求： 实现中缀表达式转换成后缀表达式
 *      在后面在实现利用后缀表达式进行数学运算
 *步骤分析：
 * 中缀表达式：2 * 3 ( 4 -2) + 6 / ( 2 + 1) -2(便于人看，但是不适合计算机计算）
 * 因此我们需要把他变成后缀表达式，这也是栈的一个典型应用
 * 1 遍历中缀表达式 ，逐个字符的遍历
 * 2 判断每个字符 ：
 *      A 如果是数字 ,还需要判断下一个字符是不是数字，再输出（保证式多位数）
 *              那么怎么判断是数字，独自写一个方法，利用正则表达式（[0-9])
 *              对应于String的split方法及pattern类和matcher类
 *      B 如果是运算符 那么进行如下讨论：
 *              a  此时先判断栈空与否，栈空就直接进栈，
 *
 *              b   如果栈不空，再查看栈顶元素，看看栈顶元素的优先级，如果当前字符
 *                  的优先级比栈顶的优先级高 或者 当前字符是左括号那么直接进栈。
 *                  （特别说明：进栈前（ 左括号  的优先级最高，但是进栈后便是最低）
 *                  也就是只要有左括号就一定进栈，右括号就出栈。
 *                          如果当前字符的优先级小于等于栈顶元素，那么就把栈里面的符号
 *                          逐个弹出，直到当前元素优先级大于栈顶元素，再进栈
 *                  如果是右括号，那么右括号不进栈，把栈中元素输出，直到左括号（，
 *                  但是注意左括号不做输出
 *最后：实现后缀表达式进行计算
 *
 *
 *步骤分析：
 *  a 对字符串进行遍历
 *          遇到数字就直接进栈
 *          遇到运算符就不进栈，但是需要从栈里面弹出两个元素进行运算，把结果再进栈
 *  b 最后把栈最后一个元素输出即可
 *
 * @date 2019/12/12 0012 - 22:49
 */
public class NifixToPostfixExpression {
    public static void main(String[] args) {
        String str = "20*3*(4-2)+6/(2+1)-2";     //运算式（中缀表达式）
        //上一个答案： 20 3  * 4 2   -  * 6 2 1   +  /  + 2  -
//        String str = "5+2*(3*(3-1*2+1))";                       //5 2 3 3 1 2  * -1   +  * * +
        Stack<String> stack = new Stack<>();
        String new_str = "";

        //遍历中缀表达式
        for (int i = 0; i < str.length(); i++) {
            //遍历时发现是数字
            if (isNumber(str.charAt(i) + "")) {
                for (int k = i; k < str.length(); k++) {
                    if (!isNumber(str.charAt(k) + "")) {
                        i = k - 1;      //可能错的点
                        break;
                    }
                    new_str = new_str + str.charAt(k) ;
                }
                new_str = new_str + " ";        //这个拿来格式化输出的
            } else {  //如果是运算符
                //对栈而言如果空
                if (stack.isEmpty()) {
                    stack.push((str.charAt(i) + ""));
                }else{
                    //如果栈不是空的我们再讨论自身问题
                    //如果自身是左括号
                    if ((str.charAt(i) + "").equals("(")) {
                        stack.push((str.charAt(i) + ""));
                    } else if ((str.charAt(i) + "").equals(")")) {
                        //如果是右括号 ， 不进栈 ，出栈直到左括号
                        while (true) {
                            if (stack.peek().equals("(")) {
                                stack.pop() ;       //弹栈但是不输出
                                break ;
                            }
                            new_str = new_str + "  "+ stack.pop() + " ";
                        }
                    }else{
                        //自身是运算符(加减乘除)
                        if (pority((str.charAt(i) + ""), stack.peek())) {
                            //如果优先级比栈顶的高，那么直接进栈
                            stack.push((str.charAt(i) + ""));
                        }else{
                            //如果优先级比栈顶的小或者和栈顶的一样
                            while (true) {
                                if( stack.isEmpty() || pority((str.charAt(i) + ""), stack.peek()) ){
                                    stack.push((str.charAt(i) + ""));
                                    break ;         //直到优先级比栈顶的高, 或者是栈空(而且需要优先讨论栈空）了 才进栈
                                }
                                //不然就一直输出
                                new_str = new_str + " " + stack.pop()+ " ";
                            }
                        }
                    }
                }
            }

        }
        //最后把栈最后的元素清理
        while(!stack.isEmpty()) {
            new_str = new_str + " " + stack.pop();
        }

        System.out.println(new_str);

        //对后缀表达式计算
        Stack<Integer> stackInt = new Stack<>();
        //利用正则表达式进行分割(\s)+ 表示分割中间一个或者多个空格
        String[] exeppsion = new_str.split("(\\s)+");
        for (String s : exeppsion) {
            //如果s是一个数字
            if (isNumber(s)) {
                //那么就进栈
                stackInt.push(Integer.parseInt(s));
            }else{
                Integer i = stackInt.pop();
                Integer j = stackInt.pop();
                switch (s) {
                    case "+" :
                        stackInt.push(i + j);
                        break ;
                    case "-" :
                        stackInt.push(j - i);
                        break ;
                    case "*" :
                        stackInt.push(i * j);
                        break ;
                    case "/" :
                        stackInt.push(j / i);
                        break ;
                    default :
                        break ;
                }
            }

        }
        System.out.println(stackInt.peek());





    }
    //判断数字
    public  static boolean isNumber(String ch) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher matcher = pattern.matcher(ch);
        return matcher.matches();
    }

    //判断优先级
    public static boolean pority(String s1, String s2) {
        //因为可能是数字和栈顶的左括号做比较
        if (s2.equals("(")) {
            return true;
        }
        if (s1.equals("*") || s1.equals("/")) {
            if (s2.equals("+") || s2.equals("-")) {
                return true ;
            }
        }
        return false ;
    }
    
}
