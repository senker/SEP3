import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UnitTest {

    @Test
    public void testEvaluateExpression(){
        ArrayList<Token> myInt = new ArrayList<Token>();
        Calculator calculator = new Calculator();
        myInt.add(new Operand(4));
        myInt.add(new Operand(7));
        myInt.add(new Operator("*"));
        myInt.add(new Operand(18));
        myInt.add(new Operator("-"));
        int result = calculator.evaluateExpression(myInt);
        assertEquals(10, result);
    }
    @Test
    public void testGetResult(){
        ArrayList<Token> myInt = new ArrayList<Token>();
        Calculator calculator = new Calculator();
        myInt.add(new Operand(4));
        myInt.add(new Operand(7));
        myInt.add(new Operator("*"));
        myInt.add(new Operand(23));
        myInt.add(new Operator("-"));
        calculator.evaluateExpression(myInt);
        int result = (int) calculator.getResult();
        assertEquals(5, result);
    }
    @Test
    public void testPush(){
        Stack stack = new Stack<>();
        stack.push(23);
        stack.push(42);
        assertEquals(42, stack.peek());
    }
    @Test
    public void testPop(){
        Stack stack = new Stack<>();
        stack.push(23);
        stack.push(42);
        stack.pop();
        assertEquals(23, stack.peek());
    }
    @Test
    public void testPeek(){
        Stack stack = new Stack<>();
        stack.push(12);
        int result = (int) stack.peek();
        assertEquals(12, result);
    }
    @Test
    public void testOperatorGet(){
        Operator operator = new Operator("+");
        String result = operator.get();
        assertEquals("+", result);
    }
    @Test
    public void testOperandGet(){
        Operand operand = new Operand(5);
        String result = operand.get();
        assertEquals("5", result);
    }
    @Test
    public void testGetElmNode(){
        Node node = new Node(123);
        int result = (int) node.getElm();
        assertEquals(123, result);
    }
    @Test
    public void testSetElmNode(){
        Node node = new Node(123);
        node.setElm(111);
        int result = (int) node.getElm();
        assertEquals(111, result);
    }
    @Test
    public void testGetNextNode(){
        Node node = new Node(123);
        node.setNext(new Node(222));
        int result = (int) node.getNext().getElm();
        assertEquals(222, result);
    }
    @Test
    public void testSetNextNode(){
        Node node = new Node(123);
        node.setNext(new Node(333));
        int result = (int) node.getNext().getElm();
        assertEquals(333, result);
    }

}
