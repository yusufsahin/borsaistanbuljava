import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bir sayi giriniz ");
        int input = scanner.nextInt();
        System.out.println("Girdiginiz sayi "+input );

        if(input > 0){
            System.out.println("Sayi pozitif");
        } else if (input==0) {
            System.out.println("Sayi O' a eşittir");

        } else {
            System.out.println("Sayi negatif");
        }
        System.out.println("Hafta günü için bir sayi giriniz");
        int gun= scanner.nextInt();
        //Switch Case
        switch (gun)
        {
            case 1:
                System.out.println("Pazartesi");
                break;
            case 2:
                System.out.println("Salı");
                break;
            case 3:
                System.out.println("Çarşamba");
                break;
            case 4:
                System.out.println("Perşembe");
                break;
            case 5:
                System.out.println("Cuma");
                break;
            case 6:
                System.out.println("Cumartesi");
                break;
            case 7:
                System.out.println("Pazar");
                break;
            default:
                System.out.println("Geçersiz Gün");
        }
        System.out.println("2 'de 20 kadar 2 er 2 er saydıralım");
        for (int i=0;i<=20;i+=2){
            System.out.println("i = "+i);
        }
        System.out.println("While Döngüsü için bir sayı giriniz");

        System.out.println("While Döngüsü");
        int whiledongu= scanner.nextInt();

        while (whiledongu<=5)
        {
            System.out.println("Sayı : "+whiledongu);
            whiledongu++;
        }

        System.out.println("Do - While Döngüsü");
        int dowhiledongu= scanner.nextInt();

        do
        {
            System.out.println("Sayı : "+dowhiledongu);
            dowhiledongu++;
        }while(dowhiledongu<=5);


    }
}