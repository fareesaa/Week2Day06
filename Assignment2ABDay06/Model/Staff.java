package Comp.Model;

public class Staff {

    //Essential
    int id;
    String nama;
    int gapok;

    int absensi = 20;

    public Staff(int id, String nama, int gapok) {
        this.id = id;
        this.nama = nama;
        this.gapok = gapok;
    }

    //Calculated
    int tunjMakan=2000;
    int tunjTransport=3000;
    int totalGaji;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getGapok() {
        return gapok;
    }

    public void setGapok(int gapok) {
        this.gapok = gapok;
    }

    public int getAbsensi() {
        return absensi;
    }

    public void setAbsensi(int absensi) {
        this.absensi = absensi;
    }

    public int getTunjMakan() {
        return tunjMakan;
    }

    public void setTunjMakan(int tunjMakan) {
        this.tunjMakan = tunjMakan;
    }

    public int getTunjTransport() {
        return tunjTransport;
    }

    public void setTunjTransport(int tunjTransport) {
        this.tunjTransport = tunjTransport;
    }

    public int getTotalGaji() {
        return totalGaji;
    }

    public void setTotalGaji(int totalGaji) {
        this.totalGaji = totalGaji;
    }
}
