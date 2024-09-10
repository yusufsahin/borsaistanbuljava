import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Person p1= new Person("John",25);
        Person p2 = new Person("Jane" ,25);
        Person p3= new Person("Frank",27);
        Person p4= new Person("Bill",33);
        Person p5= new Person("David",35);

        List<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);
        people.add(p5);

        for (Person p : people) {
            System.out.println(p.toString());
        }

        p1.setAge(40);

        for (Person p : people) {
            System.out.println(p.toString());
        }

    }
}