package view;

import java.util.List;
import java.util.Scanner;

public class ParkirView {
    private Scanner scanner;

    public ParkirView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void tampilkanMenu() {
        System.out.println("Selamat datang di sistem parkir mobil tasyaa");
        System.out.println("1. Login Admin");
        System.out.println("2. Check-in Kendaraan");
        System.out.println("3. Check-out Kendaraan");
        System.out.println("4. Lihat daftar kendaraan yang sedang parkir");
        System.out.println("5. Lihat daftar kendaraan yang pernah parkir");
        System.out.println("0. Keluar");
    }


    public int getInputMenu() {
        System.out.print("Masukkan pilihan menu: ");
        return scanner.nextInt();
    }

    public String getInputUsername() {
        System.out.print("Masukkan username admin: ");
        return scanner.next();
    }

    public String getInputPassword() {
        System.out.print("Masukkan password admin: ");
        return scanner.next();
    }

    public void tampilkanMenuCheckIn() {

        System.out.println("Masukkan informasi kendaraan :");
    }
    public void tampilkanFormCheckOut()
    {
        System.out.println("Masukkan informasi kendaraan:");
    }

    public void tampilkanLoginStatus(boolean loginStatus) {
        if (loginStatus) {
            System.out.println("Admin sudah login.");
        } else {
            System.out.println("Login Admin Gagal. Coba lagi.");
        }
    }

    public void tampilkanDaftarKendaraan(List<String> daftarKendaraan) {
        if (daftarKendaraan.isEmpty()) {
            System.out.println("Tidak ada kendaraan yang sedang parkir.");
        } else {
            System.out.println("Daftar kendaraan yang sedang parkir:");
            for (String platNomor : daftarKendaraan) {
                System.out.println(platNomor);
            }
        }
    }

    public void tampilkanDaftarSebelumnya(List<String> daftarStruk) {
        System.out.println("Daftar kendaraan yang pernah parkir:");
        for (String struk : daftarStruk) {
            System.out.println(struk);
        }
    }

    public String masukkanPlatNomor() {
        System.out.print("Masukkan plat Nomor: ");
        return scanner.next();
    }
}
