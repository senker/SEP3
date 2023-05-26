public class Operand implements Token{

    private int numb;

    public Operand(int numb){
        this.numb = numb;
    }

    @Override
    public String get() {
        return Integer.toString(numb);
    }
}
