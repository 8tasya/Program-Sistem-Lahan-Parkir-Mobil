package model;
import entity.Admin;
import entity.Kendaraan;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LahanParkirModel {
    private List<Kendaraan> daftarKendaraan;
    private List<Kendaraan> daftarKendaraanPernahParkir;
    private Admin admin;

    public LahanParkirModel(Admin admin) {
        this.daftarKendaraan = new ArrayList<>();
        this.daftarKendaraanPernahParkir = new ArrayList<>();
        this.admin = admin;
    }

    public boolean login(String username, String password) {
        return admin.getUsername().equals(username) && admin.getPassword().equals(password);
    }


    public void Checkin(Kendaraan kendaraan) {
        daftarKendaraan.add(kendaraan);
        System.out.println("Kendaraan berhasil check-in.");
    }

    public int CheckOut(String platNomor) {
        for (int i = 0; i < daftarKendaraan.size(); i++) {
            Kendaraan kendaraan = daftarKendaraan.get(i);
            if (kendaraan.getPlatNomor().equals(platNomor)) {
                kendaraan.setJamKeluar(LocalDateTime.now());
                int biayaParkir = kendaraan.hitungBiayaParkir();
                System.out.println(kendaraan.cetakStruk());
                daftarKendaraan.remove(i);
                daftarKendaraanPernahParkir.add(kendaraan);
                return biayaParkir;
            }
        }
        System.out.println("Kendaraan dengan plat nomor " + platNomor + " tidak ditemukan.");
        return 0;
    }

    public List<String> daftarKendaraanParkir() {
        List<String> daftarPlatNomor = new ArrayList<>();
        for (Kendaraan kendaraan : daftarKendaraan) {
            daftarPlatNomor.add(kendaraan.getPlatNomor());
        }
        return daftarPlatNomor;
    }

    public List<String> daftarKendaraanSebelumnya() {
        List<String> daftarStruk = new ArrayList<>();
        for (Kendaraan kendaraan : daftarKendaraanPernahParkir) {
            daftarStruk.add(kendaraan.cetakStruk());
        }
        return daftarStruk;
    }
}
