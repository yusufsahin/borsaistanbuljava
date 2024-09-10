import domain.Araba;
import domain.Motosiklet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       /* Araba araba = new Araba();
        araba.setMarka("Mercedes");
        araba.setModel("c300");
        araba.setRenk("Beyaz");
        araba.setHiz(10);
        System.out.println(araba.toString());

        Araba araba2 = new Araba("BMW","320","Gece Mavisi",30);
        System.out.println(araba2.toString());
*/
        System.out.println("Araba 1");

        Araba araba1= new Araba("Mercedes","C190","Siyah",200);

        araba1.yavasla(90);

        araba1.bilgileriGoster();

        araba1.YorgunlukAlgi();;

        araba1.LastikHavaBasinci();

        Motosiklet motosiklet1= new Motosiklet("BMW","R60","Gece Mavisi",70);

        motosiklet1.bilgileriGoster();
        motosiklet1.hizlan(10);
        motosiklet1.bilgileriGoster();
        motosiklet1.LastikHavaBasinci();
    }
}