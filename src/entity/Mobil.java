package entity;

import java.time.Duration;
import java.time.LocalDateTime;

public class Mobil extends Kendaraan {

    public Mobil(String platNomor, LocalDateTime jamMasuk) {
        super(platNomor, jamMasuk);
    }

    @Override
    public int hitungBiayaParkir() {
        if (getJamKeluar() == null) {
            System.out.println("Kendaraan belum check-out.");
            return 0;
        }

        Duration durasi = Duration.between(getJamMasuk(), getJamKeluar());

        if (durasi.toMinutes() <= 10) {
            return 0;
        }

        int biayaParkir = 10000;
        long durasiHari = durasi.toDays();
        biayaParkir += durasiHari * 5000;
        return biayaParkir;
    }

    @Override
    public String cetakStruk() {
        if (getJamKeluar() != null) {
            return "Struk Mobil\n" + "Plat Nomor: " + getPlatNomor() + "\nBiaya Parkir: " + hitungBiayaParkir();
        } else {
            return "Kendaraan belum check-out.";
        }
    }
}
