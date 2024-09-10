//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        selamla();
        selamla("John Doe");
        System.out.println(selam("test"));
        System.out.println(Topla(5,3));

        System.out.println(Carp(2,7));
    }

    public static void  selamla()
    {
        System.out.println("Hello World!");
    }
    public static void  selamla(String isim)
    {
        System.out.println("Hello World! , "+isim);
    }

    public static String selam()
    {
        return "Hello World! - return";
    }

    public  static String selam(String isim)
    {
        String msg= "Hello World! , "+isim;
        return  msg;
    }

    public  static  int Topla(int a,int b)
    {
        return  a+b;
    }
    public static int Carp(int a,int b)
    {
        return  a*b;
    }
}