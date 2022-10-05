package Comp;
import java.io.FileOutputStream;
public class FileOutputStreamExample {

    public static void main(String args[]){

        try{
            FileOutputStream fout = new FileOutputStream("C:\\Users\\BTPNSSHIFTED\\Task\\subtask\\Latihan\\faris.txt");

            fout.write(70);fout.write(65);fout.write(82);fout.write(73);fout.write(83);
            fout.close();
            System.out.println("success...");
        }catch(Exception e){System.out.println(e);}

    }

}
