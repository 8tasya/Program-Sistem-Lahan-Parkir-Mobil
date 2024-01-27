import entity.Admin;
import model.LahanParkirModel;
import view.ParkirView;
import controller.ParkirController;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin("admin", "123");
        LahanParkirModel lahanParkirModel = new LahanParkirModel(admin);
        ParkirView parkirView = new ParkirView(scanner);

        ParkirController parkirController = new ParkirController(parkirView, lahanParkirModel);
        parkirController.Pilihan();
    }
}


