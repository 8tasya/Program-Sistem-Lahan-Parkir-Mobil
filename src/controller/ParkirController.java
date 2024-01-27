package controller;
import entity.Mobil;
import entity.Kendaraan;
import model.LahanParkirModel;
import view.ParkirView;

import java.time.LocalDateTime;
import java.util.List;

public class ParkirController {
    private ParkirView parkirView;
    private LahanParkirModel lahanParkirModel;

    public ParkirController(ParkirView parkirView, LahanParkirModel lahanParkirModel) {
        this.parkirView = parkirView;
        this.lahanParkirModel = lahanParkirModel;
    }

    public void Pilihan() {
        int pilihanMenu;
        do {
            parkirView.tampilkanMenu();
            pilihanMenu = parkirView.getInputMenu();

            switch (pilihanMenu) {
                case 1:
                    loginAdmin();
                    break;
                case 2:
                    checkInKendaraan();
                    break;
                case 3:
                    checkOutKendaraan();
                    break;
                case 4:
                    tampilkanDaftarKendaraan();
                    break;
                case 5:
                    tampilkanDaftarSebelumnya();
                    break;
                case 0:
                    System.out.println("Terima kasih, sampai jumpa!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihanMenu != 0);
    }

    private void loginAdmin() {
        String username = parkirView.getInputUsername();
        String password = parkirView.getInputPassword();

        if (!lahanParkirModel.login(username, password)) {
            parkirView.tampilkanLoginStatus(false);
        } else {
            parkirView.tampilkanLoginStatus(true);
        }
    }

    private void checkInKendaraan() {
        if (lahanParkirModel.login("admin", "123")) {
            parkirView.tampilkanMenuCheckIn();
            String platNomor = parkirView.masukkanPlatNomor();
            LocalDateTime jamMasuk = LocalDateTime.now();
            Kendaraan kendaraan = new Mobil(platNomor, jamMasuk);
            lahanParkirModel.Checkin(kendaraan);
        } else {
            System.out.println("Silakan login admin terlebih dahulu.");
        }
    }

    private void checkOutKendaraan() {
        if (lahanParkirModel.login("admin", "123")) {
            parkirView.tampilkanFormCheckOut();
            String platNomor = parkirView.masukkanPlatNomor();
            int biayaParkir = lahanParkirModel.CheckOut(platNomor);
        } else {
            System.out.println("Silakan login admin terlebih dahulu.");
        }
    }

    private void tampilkanDaftarKendaraan() {
        List<String> daftarKendaraan = lahanParkirModel.daftarKendaraanParkir();
        parkirView.tampilkanDaftarKendaraan(daftarKendaraan);
    }

    private void tampilkanDaftarSebelumnya() {
        if (lahanParkirModel.login("admin", "123")) {
            List<String> daftarKendaraanSebelumnya = lahanParkirModel.daftarKendaraanSebelumnya();
            if (!daftarKendaraanSebelumnya.isEmpty()) {
                parkirView.tampilkanDaftarSebelumnya(daftarKendaraanSebelumnya);
            } else {
                System.out.println("Tidak ada kendaraan yang pernah parkir.");
            }
        } else {
            System.out.println("Silakan login admin terlebih dahulu.");
        }
    }
}
