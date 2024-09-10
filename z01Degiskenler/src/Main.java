//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            int sayi=10;
            System.out.println(sayi);
            float pi=3.14F;
            final double PI_SAYISI= pi;
            System.out.println(pi);
            System.out.println(PI_SAYISI);
            pi=3.0F;
            System.out.println(pi);
            System.out.println(PI_SAYISI);

           // byte s1 = 129;//Hata
           // System.out.println(s1);

            short s3=-32768;
            System.out.println(s3);
            short s4= 32767;
            System.out.println(s4);
            int i1= -2147483648;
            int i2=2147483647;

            long l1 =9223372036854775807L;
            long l2 =-9223372036854775808L;

            float f1= 67.05F;
            double d1= 56677.7888888;

            final String mesaj;
            String isim="John";

            mesaj="Merhaba";

            boolean isValid=false;
            final double E_SAYISI= 2.17;

            System.out.println(sayi);

            System.out.println(i1);
            System.out.println(i2);
            System.out.println(l1);
            System.out.println(l2);
            System.out.println(f1);
            System.out.println(d1);

            System.out.println(mesaj);
            System.out.println(PI_SAYISI);
            System.out.println(E_SAYISI);
            //Hat verir - Sabit değeri atandıktan sonra değiştirilemez
            //PI_SAYISI=3.148;

            System.out.println(mesaj+","+isim);
            //Hata verir
            // mesaj="Merhaba";
            System.out.println(isValid);

            //Tekrar atama yapıldı
            isim="Jane";

            System.out.println(mesaj+","+isim);

            final  String mesaj_isim=mesaj+","+isim;
            System.out.println(mesaj_isim);
    }
}
