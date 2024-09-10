import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)  {

        try {
            Person person = new Person("John Doe", 25);
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("person.ser"));
            outputStream.writeObject(person);
            outputStream.close();

            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("person.ser"));
            Person restoredPerson= (Person) inputStream.readObject();
            System.out.println("Name : " + person.getName());
            System.out.println("Age : " + person.getAge());
            inputStream.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}