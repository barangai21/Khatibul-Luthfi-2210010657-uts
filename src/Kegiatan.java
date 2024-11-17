public class Kegiatan {
    private String nama;
    private String hari;
    private String tanggal;
    private String jam;
    private String tempat;

    // Konstruktor untuk menginisialisasi data kegiatan
    public Kegiatan(String nama, String hari, String tanggal, String jam, String tempat) {
        this.nama = nama;
        this.hari = hari;
        this.tanggal = tanggal;
        this.jam = jam;
        this.tempat = tempat;
    }

    // Getter methods untuk mengakses data kegiatan
    public String getNama() {
        return nama;
    }

    public String getHari() {
        return hari;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getJam() {
        return jam;
    }

    public String getTempat() {
        return tempat;
    }

    // Method untuk mengembalikan representasi string kegiatan
    @Override
    public String toString() {
        return nama + " (" + hari + ", " + tanggal + " " + jam + " di " + tempat + ")";
    }
}

