import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Token> myInts = new ArrayList<Token>();
        Calculator calculator = new Calculator();
        Scanner sc= new Scanner(System.in);
        boolean quit = false;
        String str;

        System.out.println("In order to finish type the letter q.");
        System.out.print("Enter an operand: ");
        str = sc.nextLine();    // gets the first number
        myInts.add(new Operand(Integer.parseInt(str)));
        while(!quit) {   //continues the loop until q is pressed

            System.out.print("Enter an operand: ");
            str = sc.nextLine();        //gets the second number

            if(str.equals("q"))
            {
                quit = true;
            }else{
                myInts.add(new Operand(Integer.parseInt(str)));
                System.out.print("Enter an operator: ");
                str = sc.nextLine();    //gets the operator
                if(str.equals("q"))
                {
                    quit = true;}
                else{
                    myInts.add(new Operator(str));
                }
            }
        }
        System.out.println( "Calculator evaluate expression: " + calculator.evaluateExpression(myInts));
        System.out.println( "Calculator Result: " + calculator.getResult());
    }
}