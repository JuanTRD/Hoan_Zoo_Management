package Menu;

import Manager.AccountManager;
import Manager.AnimalManager;
import Manager.TicketManager;
import Module.Account;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    static AccountManager accountManager = new AccountManager();
    static AnimalManager animalManager = new AnimalManager();
    static TicketManager ticketManager = new TicketManager();

    public static void Menu() {
        while (true) {
            System.out.println("----DANG NHAP----");
            System.out.println("Nhap username");
            String username = scanner.nextLine();
            System.out.println("Nhap password");
            String password = scanner.nextLine();
            Account account = accountManager.checkLogin(username, password);
            if (account != null) {
                System.out.println("Xin chao " + account.getUsername() + " " + account.getRole().getName());
                if (account.getRole().getName().equals("Admin")) {
                    Admin_Menu();
                } else if (account.getRole().getName().equals("User")) {
                    if (account.getStaff().getName().equals("CaringAnimal")) {
                        CaringAnimal_User_Menu(username);
                    } else {
                        TicketSeller_User_Menu(username);
                    }

                }
            } else {
                System.out.println("Dang nhap loi");

            }
        }
    }

    public static void FrontMenu() {
        while (true) {
            try {
                System.out.println("1. Dang nhap");
                System.out.println("2. Thoat");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        Menu();
                    case 2:
                        return;
                    default:
                        System.out.println("Nhap lai");
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static void Admin_Menu() {
        while (true) {
            System.out.println("1. Hien thi danh sach con con vat");
            System.out.println("2. Hien thi danh sach nhan vien theo Account");
            System.out.println("3. Hien thi danh sach ve da ban");
            System.out.println("4. Them nhan vien");
            System.out.println("5. Sua nhan vien");
            System.out.println("6. Xoa nhan vien");
            System.out.println("7. Them Dong vat");
            System.out.println("8. Sua Dong vat");
            System.out.println("9. Xoa Dong vat");
            System.out.println("10. Tinh doanh thu tu ve da ban");
            System.out.println("11. Tinh so ve da ban");
            System.out.println("12. Ghi data");
            System.out.println("13. Doc data");
            System.out.println("14. Thoat");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    animalManager.displayAnimal();
                    break;
                case 2:
                    accountManager.displayAccount();
                    break;
                case 3:
                    ticketManager.displayTicket();
                    break;
                case 4:
                    accountManager.addAccount(accountManager.createAccount());
                    break;
                case 5:
                    break;
                case 6:
                    accountManager.removeAccount();

                    break;
                case 7:
                    animalManager.addAnimal(animalManager.createAnimal());
                    break;
                case 8:
                    animalManager.editAnimal();
                    break;
                case 9:
                    animalManager.removeAnimal();
                    break;
                case 10:
                    System.out.println(ticketManager.getProfitTicket());
                    break;
                case 11:
                    System.out.println(ticketManager.getTicketCount());
                    break;
                case 12:
                    accountManager.writeAccount();
                    animalManager.writeAnimal();
                    ticketManager.writeTicket();
                    accountManager.writeStaff();
                    break;
                case 13:
                    accountManager.readAccount();
                    animalManager.readAnimal();
                    ticketManager.readTicket();
                    accountManager.readStaff();
                    break;
                case 14:
                    return;

            }
        }
    }

    public static void CaringAnimal_User_Menu(String username) {
        while (true) {
            System.out.println("1. Hien thi danh sach con con vat");

            System.out.println("2. Doi password");
            System.out.println("3. Ghi data");
            System.out.println("4. Thoat");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    animalManager.displayAnimal();
                    break;

                case 2:
                    accountManager.setPassword(username);
                    break;

                case 3:
                    accountManager.readAccount();
                    break;
                case 4:
                    return;
            }
        }
    }

    public static void TicketSeller_User_Menu(String username) {
        while (true) {
            System.out.println("1. Hien thi danh sach cac ve da ban");
            System.out.println("2. Ban ve");
            System.out.println("3. So ve da ban");
            System.out.println("4. Doi password");
            System.out.println("5. Ghi data");
            System.out.println("6. Thoat");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    ticketManager.displayTicket();
                    break;
                case 2:
                    ticketManager.addTicket(ticketManager.createTicket());
                    break;
                case 3:
                    System.out.println(ticketManager.getTicketCount());
                    break;
                case 4:
                    accountManager.setPassword(username);
                    break;
                case 5:
                    accountManager.readAccount();

                    ticketManager.readTicket();
                    break;
                case 6:
                    return;

            }
        }
    }
}
