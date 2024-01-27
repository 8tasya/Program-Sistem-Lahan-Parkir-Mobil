package entity;

import java.time.LocalDateTime;
public abstract class Kendaraan {
    private String platNomor;
    private LocalDateTime jamMasuk;
    private LocalDateTime jamKeluar;

    public Kendaraan(String platNomor, LocalDateTime jamMasuk) {
        this.platNomor = platNomor;
        this.jamMasuk = jamMasuk;
        this.jamKeluar = null;
    }

    public abstract int hitungBiayaParkir();

    public abstract String cetakStruk();

    public String getPlatNomor() {
        return platNomor;
    }

    public LocalDateTime getJamMasuk() {

        return jamMasuk;
    }

    public LocalDateTime getJamKeluar() {

        return jamKeluar;
    }

    public void setJamKeluar(LocalDateTime jamKeluar) {
        this.jamKeluar = jamKeluar;
    }
}
