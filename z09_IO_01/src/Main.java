import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try{
            File myFile= new File("/Users/yusufsahin/Projects/borsaistanbul/z09_IO_01/src/dosya.txt");
            FileWriter writer= new FileWriter(myFile,true);
            writer.write("\nMerhaba Dünya,Java!");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try{
            File myfile=new File("/Users/yusufsahin/Projects/borsaistanbul/z09_IO_01/src/dosya.txt");
            FileReader reader= new FileReader(myfile);
            BufferedReader br= new BufferedReader(reader);
            String line= null;
            while ((line=br.readLine())!=null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}