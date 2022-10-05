package Comp;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;

public class IOTask {
        public static void main(String args[]){

            try{
                FileOutputStream fout = new FileOutputStream("C:\\Users\\BTPNSSHIFTED\\Task\\subtask\\faris11.txt");
                String s = "faris";

                byte b[]=s.getBytes();
                fout.write(b);

                fout.close();
                System.out.println("success...");

                FileInputStream fin = new FileInputStream("C:\\Users\\BTPNSSHIFTED\\Task\\subtask\\faris11.txt");
                BufferedInputStream bin = new BufferedInputStream(fin);
                int i = 0;
                while ((i=bin.read())!= -1){
                    System.out.println((char)i);

                }

                bin.close();
                fin.close();
            }catch(Exception e){System.out.println(e);}

        }


}
