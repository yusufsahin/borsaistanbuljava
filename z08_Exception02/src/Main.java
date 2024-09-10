import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the dividend");
        int dividend = scanner.nextInt();
        System.out.println("Enter the divisor");
        int divisor = scanner.nextInt();
        try {
            int result = devide(dividend, divisor);
            System.out.println("Result :"+result);
        }catch(ArithmeticException e)
        {
            System.out.println("Error occured : "+e.getMessage());
        }
        finally {
            System.out.println("End");
        }
        }

    public static  int devide(int dividend, int divisor) throws ArithmeticException{
        if(divisor == 0){
            throw new ArithmeticException("Divisor is zero");
        }
        return dividend/divisor;
    }
}