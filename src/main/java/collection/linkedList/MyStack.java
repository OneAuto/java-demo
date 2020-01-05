package collection.linkedList;

import org.slf4j.Logger;
import utils.LoggerUtils;

import java.util.Deque;
import java.util.LinkedList;




        /*
        使用LinkedList实现栈
         */


public class MyStack<E> implements Stack {

    public static final Logger LOG= LoggerUtils.getLoggerEntity(MyStack.class);

    private Deque<E> deque=new LinkedList<E>();

    public void push(Object element) {
        //原理是使用双向链表在尾部插入元素
        deque.addFirst((E) element);
    }

    public E poll() {
        //原理是使用双向链表删除尾部元素
        return deque.removeFirst();
    }

    public E peek() {
        //获取栈顶元素，但不删除
        return deque.getFirst();
    }

    public static void main(String[] args) {
        MyStack<Integer> myStack=new MyStack<Integer>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);

        //后进先出，出栈元素为：5
        LOG.info("出栈元素：{}",myStack.poll());
        LOG.info("栈顶元素：{}",myStack.peek());

    }
}
