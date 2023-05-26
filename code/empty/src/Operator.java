public class Operator implements Token{

    String operator;
    public Operator(String operator){
        this.operator = operator;
    }

    @Override
    public String get() {
        return operator;
    }
}
