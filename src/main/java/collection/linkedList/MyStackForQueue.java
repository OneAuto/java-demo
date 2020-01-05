package collection.linkedList;

import java.util.LinkedList;
import java.util.Queue;

        /*
          使用队列实现栈，过程较复杂
         */
public class MyStackForQueue<E> implements Stack{

    private Queue<E> queue=new LinkedList<E>();
    @Override
    public void push(Object element) {
        queue.offer((E)element);
    }

    @Override
    public Object poll() {
        return null;
    }

    @Override
    public Object peek() {
        return null;
    }
}
