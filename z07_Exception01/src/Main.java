//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try{
        int result= divede(10,0);
        System.out.println(result);
        }catch (ArithmeticException e)
        {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("---Finally block executed---");
        }
    }

    public static int divede(int devident, int devisor) {

        return devident/devisor;
    }
}