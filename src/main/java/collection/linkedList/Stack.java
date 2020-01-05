package collection.linkedList;

interface Stack<E>{
    //压入栈
    public void push(E element);

    //出栈
    public E poll();

    //查看栈顶元素，但不删除
    public E peek();
}