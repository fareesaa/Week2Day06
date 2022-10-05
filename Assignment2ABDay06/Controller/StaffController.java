package Comp.Controller;

import Comp.Model.Staff;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StaffController {

    ArrayList<Staff> arrStaff = new ArrayList<>();

    ArrayList<Staff> arrStaffView = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public void createDummy(){
        System.out.println("Creating Dummy Data");
        this.arrStaff.add(new Staff(2,"PETER",3000));
        this.arrStaff.add(new Staff(1,"JOHN",2000));
    }

    public void addStaff(){

        System.out.print("Input ID : ");
        int id = this.input.nextInt();
        System.out.print("Input Nama : ");
        String nama = this.input.next();
        System.out.print("Input Gaji Pokok : ");
        int gapok = this.input.nextInt();

        Staff st = new Staff(id, nama, gapok);

        this.arrStaff.add(st);

    }

    public void viewStaff(){

        for (Staff st:this.arrStaff) {
            System.out.println("ID : "+st.getId());
            System.out.println("Nama : "+st.getNama());
            System.out.println("Gaji Pokok : "+st.getGapok());
            System.out.println("Absensi : "+st.getAbsensi());
            System.out.println("Total Gaji : "+st.getTotalGaji());
        }

    }

    public void prosesGaji(){
        int i = 0;

        for (Staff st:this.arrStaff) {
            int tunjMakan = st.getAbsensi() * 20000;
            int tunjTransport = st.getAbsensi() * 50000;

            int totalGaji = (tunjTransport+tunjMakan) + st.getGapok();

            this.arrStaff.get(i).setTunjMakan(tunjMakan);
            this.arrStaff.get(i).setTunjTransport(tunjTransport);
            this.arrStaff.get(i).setTotalGaji(totalGaji);

            i++;
        }
    }
    public void viewStaffFile(){

        for (Staff st:this.arrStaffView) {
            System.out.println("===========================");
            System.out.println("ID : "+st.getId());
            System.out.println("Nama : "+st.getNama());
            System.out.println("Total Gaji : "+st.getGapok());
            String terbilang = angkaToTerbilang((long)st.getGapok());
            System.out.println("Terbilang : " + terbilang);
        }

    }
    public void writeStaffToFile(){
        try{

            System.out.println("Masukkan dir: ");
            String dir  = input.next();
            System.out.println("Masukkan file: ");
            String file  = input.next();

            FileWriter fw = new FileWriter(dir+"\\"+file+".txt");

            Collections.sort(this.arrStaff, Comparator.comparingLong(Staff::getId));

            fw.write("ID,NAMA,TOTALGAJI\n");
            for (Staff st:this.arrStaff) {
                fw.write(st.getId()+","+st.getNama()+","+st.getTotalGaji()+"\n");
            }

            fw.close();
        }catch(Exception e){System.out.println(e);}
        System.out.println("Success...");

    }

    public void loadDataStaff(){

        try{
            System.out.println("Masukkan dir: ");
            String dir  = input.next();
            System.out.println("Masukkan file: ");
            String file  = input.next();
            FileReader fr = new FileReader(dir+"\\"+file+".txt");
            int x=0;
            String s = "";
            while(( x=fr.read())!=-1){
                s = s + (char)x;
            }
            String [] parsedNl = s.split("\n");
            System.out.println(parsedNl.length);
            //Longkap 1 untuk melewati head
            for(int i = 1; i<parsedNl.length; i++){

                String [] parseComma = parsedNl[i].split(",");

                int getId = Integer.parseInt(parseComma[0]);
                String getNama = parseComma[1];
                int getTotGaji = Integer.parseInt(parseComma[2]);

                Staff st = new Staff(getId,getNama,getTotGaji);
                arrStaffView.add(st);
            }


            System.out.println(s);
            fr.close();
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("load success...");

    }

    public void viewStaffSort(){
        System.out.println("id\tNama\t\tAbsensi\tGapok\t\tTerbilang");

        Collections.sort(this.arrStaff, Comparator.comparingLong(Staff::getId));

        for (Staff st:this.arrStaff) {
            String terbilang = angkaToTerbilang((long)st.getGapok());
            System.out.println(st.getId()+"\t"+st.getNama()+"\t\t"+st.getAbsensi()+"\t"+st.getGapok()+"\t\t"+terbilang);
        }

    }

    public void editStaff(){

        int i = 0;

        System.out.print("Masukan ID yang akan di Edit : ");
        int id = this.input.nextInt();

        for (Staff st:this.arrStaff) {

            if(id == st.getId()){
                System.out.println("ID Found at index "+i); // Dapet index nya, index ke i

                System.out.print("Ganti nama menjadi : ");
                this.arrStaff.get(i).setNama(this.input.next());

                break;
            }

            i++;
        }

    }

    public void deleteStaff(){

        int i = 0;

        System.out.print("Masukan ID yang akan di Delete : ");
        int id = this.input.nextInt();

        for (Staff st:this.arrStaff) {

            if(id == st.getId()){
                System.out.println("ID Found at index "+i); // Dapet index nya, index ke i

                this.arrStaff.remove(i);

                break;
            }

            i++;
        }

    }

    public void absenStaff(){

        int i = 0;

        System.out.print("Masukan ID Absensi : ");
        int id = this.input.nextInt();

        for (Staff st:this.arrStaff) {

            if(id == st.getId()){
                System.out.println("ID Found at index "+i); // Dapet index nya, index ke i

                int absenCounter = this.arrStaff.get(i).getAbsensi();
                System.out.println("Absensi "+st.getNama()+" = "+absenCounter);

                absenCounter = absenCounter + 1;

                this.arrStaff.get(i).setAbsensi(absenCounter);
                System.out.println("Absensi "+st.getNama()+" bertambah menjadi = "+absenCounter);
                break;
            }

            i++;
        }

    }

    static String[] huruf={"","Satu","Dua","Tiga","Empat","Lima","Enam","Tujuh","Delapan","Sembilan","Sepuluh","Sebelas"};

    public String angkaToTerbilang(Long angka){
        if(angka < 12)
            return huruf[angka.intValue()];
        if(angka >=12 && angka <= 19)
            return huruf[angka.intValue() % 10] + " Belas";
        if(angka >= 20 && angka <= 99)
            return angkaToTerbilang(angka / 10) + " Puluh " + huruf[angka.intValue() % 10];
        if(angka >= 100 && angka <= 199)
            return "Seratus " + angkaToTerbilang(angka % 100);
        if(angka >= 200 && angka <= 999)
            return angkaToTerbilang(angka / 100) + " Ratus " + angkaToTerbilang(angka % 100);
        if(angka >= 1000 && angka <= 1999)
            return "Seribu " + angkaToTerbilang(angka % 1000);
        if(angka >= 2000 && angka <= 999999)
            return angkaToTerbilang(angka / 1000) + " Ribu " + angkaToTerbilang(angka % 1000);
        if(angka >= 1000000 && angka <= 999999999)
            return angkaToTerbilang(angka / 1000000) + " Juta " + angkaToTerbilang(angka % 1000000);
        if(angka >= 1000000000 && angka <= 999999999999L)
            return angkaToTerbilang(angka / 1000000000) + " Milyar " + angkaToTerbilang(angka % 1000000000);
        if(angka >= 1000000000000L && angka <= 999999999999999L)
            return angkaToTerbilang(angka / 1000000000000L) + " Triliun " + angkaToTerbilang(angka % 1000000000000L);
        if(angka >= 1000000000000000L && angka <= 999999999999999999L)
            return angkaToTerbilang(angka / 1000000000000000L) + " Quadrilyun " + angkaToTerbilang(angka % 1000000000000000L);
        return "";
    }

    public void hitungTunjangan(){
        int i = 0;
        for(Staff st:this.arrStaff){
            int absen = this.arrStaff.get(i).getAbsensi();
            int makan = this.arrStaff.get(i).getTunjMakan();
            int transport = this.arrStaff.get(i).getTunjTransport();
            int tnjMakan = absen*makan;
            int tnjTransport = absen*transport;
            int tnjTotal = tnjMakan + tnjTransport;
            this.arrStaff.get(i).setTotalGaji(tnjTotal);
            i++;
        }
        System.out.println("Tunjangan semua karyawan telah terhitung!");
    }
    public void hitungTotalGaji(){
        int i = 0;
        for(Staff st:this.arrStaff){
            int tnjTotal = this.arrStaff.get(i).getTotalGaji();
            int gapok = this.arrStaff.get(i).getGapok();
            int Gatot = tnjTotal + gapok;
            this.arrStaff.get(i).setTotalGaji(Gatot);
            i++;
        }
        System.out.println("Total gaji semua karyawan telah terhitung!");

    }

}
