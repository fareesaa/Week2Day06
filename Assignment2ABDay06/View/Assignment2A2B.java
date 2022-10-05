package Comp.View;

import Comp.Controller.StaffController;

import java.util.Scanner;

public class Assignment2A2B {

    public static void main(String args[]) {

        StaffController sc = new StaffController();

        Scanner input = new Scanner(System.in);
        int pil=0;

        do {
            System.out.println("MENU");
            System.out.println("0. Buat Dummy Data");
            //-------------------2A-------------------------
            System.out.println("1. Buat Staff");
            System.out.println("2. Absen Staff");
            System.out.println("3. Proses Gaji Staff");
            System.out.println("4. Write Staff To File");
            //-------------------2B-------------------------
            System.out.println("5. Load Staff From File");
            System.out.println("6. Printout Data Staff");

            System.out.println("99. EXIT");

            System.out.print("Input nomor : ");
            pil = input.nextInt();

            switch (pil) {
                case 1:
                    sc.addStaff();
                    break;
                case 2:
                    sc.absenStaff();
                    break;
                case 3:
                    sc.hitungTunjangan();
                    sc.hitungTotalGaji();
                    sc.viewStaff();
                    break;
                case 4:
                    sc.writeStaffToFile();
                    break;
                case 5:
                    sc.loadDataStaff();
                    break;
                case 6:
                    sc.viewStaffFile();
                    break;
                case 0:
                    sc.createDummy();
                    break;
            }
            System.out.println();

        } while(pil != 99);

        // closing the scanner object
        input.close();

    }
}
