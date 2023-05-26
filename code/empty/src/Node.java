public class Node<T> {
    private T elm;
    private Node<T> next;

    public Node(T elm){
        this.elm = elm;
        this.next = null;
    }


    public T getElm() {
        return elm;
    }

    public void setElm(T elm) {
        this.elm = elm;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
