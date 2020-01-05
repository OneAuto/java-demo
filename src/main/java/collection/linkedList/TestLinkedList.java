package collection.linkedList;

import org.slf4j.Logger;
import utils.LoggerUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TestLinkedList {

    public static final Logger LOG= LoggerUtils.getLoggerEntity(TestLinkedList.class);
    public static void main(String[] args) {

        /*
        LinkedList是一个双向链表
        LinkedList除了实现List接口之外还实现链双向链表结构的Deque（也实现了Queue接口），可以很方便的在头尾插入数据
         */
        LinkedList<Integer> linkedList=new LinkedList<Integer>();

        //在头部插入数据
        linkedList.addFirst(1);

        //在尾部插入数据
        linkedList.addLast(2);

        //查看头部数据
        LOG.info("头部数据：{}",linkedList.getFirst());

        //查看尾部数据
        LOG.info("尾部数据：{}",linkedList.getLast());

        //取出头部数据
        linkedList.removeFirst();

        //取出尾部数据
        linkedList.removeLast();



        /*
        创建一个队列
         */

        Queue<Integer> queue=new LinkedList<Integer>();

        //初始化队列
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        LOG.info("取出头部元素：{}",queue.poll());
        LOG.info("取出队头元素后的队列：{}",queue);

        //把元素拿出来，但不会删除
        Integer index= queue.peek();
        LOG.info("拿出来的元素：{}",index);

    }
}
