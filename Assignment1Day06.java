package Comp;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Scanner;

public class Assignment1Day06 {
    public static void main(String args[]) {
        try{

            Scanner inputInt = new Scanner(System.in);
            Scanner inputStr = new Scanner(System.in);
            int menu;
            do {
                System.out.println("1.Input file: " );
                System.out.println("2.Read file: " );
                menu = inputInt.nextInt();

                switch (menu){
                    case 1:
                        System.out.println("Masukkan tujuan direktori" );
                        String dir = inputStr.nextLine();
                        System.out.println("Masukkan nama file" );
                        String file = inputStr.nextLine();
                        System.out.println("Masukkan isi" );
                        String isi = inputStr.nextLine();

                        FileOutputStream fout = new FileOutputStream(dir+"\\"+file+".txt");
                        BufferedOutputStream bout = new BufferedOutputStream(fout);

                        byte b[]=isi.getBytes();
                        bout.write(b);

                        bout.close();
                        fout.close();
                        System.out.println("success...");
                        break;

                    case 2:
                        String dir1 = inputStr.nextLine();
                        String file1 = inputStr.nextLine();
                        int x=0;
                        FileReader fr=new FileReader(dir1+"\\"+file1+".txt");

                        while(( x=fr.read())!=-1){
                            System.out.print((char) x);
                        }
                        fr.close();


/*                        FileInputStream fin = new FileInputStream(dir+"\\"+file+".txt");
                        BufferedInputStream bin = new BufferedInputStream(fin);
                        int i = 0;
                          while ((i=bin.read())!= -1){
                            System.out.println((char)i);
                            System.out.println(bin.read());


                        bin.close();
                        fin.close();*/
                        break;
                }
            }while(menu<2);
        }catch(Exception e){System.out.println(e);}
    }
}

