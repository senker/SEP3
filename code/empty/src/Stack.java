
public class Stack<T> implements StackADT<T>{
    private Node<T> top;
    public Stack(){
        this.top = null;
    }

    public void push(T elm) {
        Node<T> newNode = new Node<T>(elm);
        newNode.setNext(top);
        top = newNode;
    }

    public T pop() {
        T elm = top.getElm();
        top = top.getNext();
        return elm;
    }

    public T peek() {
        return top.getElm();
    }

}
