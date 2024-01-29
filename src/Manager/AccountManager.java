package Manager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Module.Account;
import Module.Role;
import Module.Staff;
import IO.AccountIO;
public class AccountManager {
    List<Account> accounts = new ArrayList<Account>();
    List<Role> roles = new ArrayList<Role>();
    List<Staff> staffs = new ArrayList<Staff>();

    Scanner scanner = new Scanner(System.in);

    public AccountManager() {
        roles.add(new Role("Admin", "1"));
        roles.add(new Role("User", "2"));
        staffs.add(new Staff("admin", 1000,1));
        staffs.add(new Staff("CaringAnimal",500,2));
        staffs.add(new Staff("TicketSeller",300,3));
        accounts.add(new Account("admin", "admin", roles.get(0),staffs.get(0)));
        writeStaff();
    }


    public void writeStaff() {
        try {
            File staffFile = new File("staff.csv");
            FileWriter fileWriter = new FileWriter(staffFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Staff s : this.staffs) {
                bufferedWriter.write(s.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void readStaff() {
        try {
            File staffFile = new File("staff.csv");
            FileReader fileReader = new FileReader(staffFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = "";
            while ((str = bufferedReader.readLine()) != null) {
                String[] arr = str.split(",");
                Staff staff = new Staff(arr[0],Double.parseDouble(arr[1]),Integer.parseInt(arr[2]));
                staffs.add(staff);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public Account getAccount(int index) {
        return accounts.get(index);
    }
    public void setPassword(String username){
        int index = getIndexByUsername(username);
        if (index!=-1) {
            System.out.println("nhap password moi");
            String newPassword = scanner.nextLine();
            accounts.get(index).setPassword(newPassword);
        }
    }
    public void readAccount(){
        accounts = AccountIO.readAccount();
    }
    public void writeAccount(){
        AccountIO.writeAccount(accounts);
    }
    public void displayAccount(){
        for(Account account : accounts){
            System.out.println("Username,Password,Role,Id Role,Staff,Salary,id");
            System.out.println(account.toString());
        }
    }
    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount() {
        System.out.println("Nhap ten username can tim");
        String username = scanner.nextLine();
        int index = getIndexByUsername(username);
        if (index!=-1) {
            accounts.remove(index);
        } else{
            System.out.println("Khong tim thay");
        }

    }
    public int getIndexByUsername(String username) {
        for(int i = 0; i < accounts.size(); i++) {
            if(accounts.get(i).getUsername().equals(username)){
                return i;
            }
        }
        return -1;
    }
    public Account createAccount() {
        String username = validateUsername();
        String password = validatePassword();
        Role role = chooseRole();
        Staff staff = null;
        if(role.getName().equals("User")){
            staff = chooseStaffUser();
        } else {
            staff = staffs.get(0);
        }

        return new Account(username,password,role,staff);
    }

    public Account checkLogin(String username, String password) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(username) && accounts.get(i).getPassword().equals(password)) {
                return accounts.get(i);
            }
        }
        return null;
    }

    private String validateUsername() {
        while (true) {
            System.out.println("Nhap username");
            String username = scanner.nextLine();
            if (checkUsername(username)) {
                System.err.println("Trung username");
            } else {
                return username;
            }
        }
    }

    public boolean checkUsername(String username) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private String validatePassword() {
        while (true) {
            System.out.println("Nhap password");
            String password = scanner.nextLine();
            System.out.println("Nhap lai password");
            String rePassword = scanner.nextLine();
            if (password.equals(rePassword)) {
                return password;
            } else {
                System.err.println("Password khong trung nhau");
            }
        }
    }
    private Role chooseRole(){
        System.out.println("Danh sach quyen trong he thong");
        for(int i = 0; i <roles.size(); i++){
            System.out.println(i + " " +roles.get(i).getName());
        }
        int choice = Integer.parseInt(scanner.nextLine());
        return roles.get(choice);
    }
    private Staff chooseStaffUser(){
        System.out.println("Danh sach vi tri lam viec");
        for(int i = 1; i <staffs.size(); i++){
            System.out.println(i + " " + staffs.get(i).getName());
        }
        int choice = -1;
        try{
            System.out.println("chon");
            choice = Integer.parseInt(scanner.nextLine());

        }catch (Exception e){
            System.out.println("Chon lai");
        }

        return staffs.get(choice);

    }
    public Role getRoleByName(String name){
        for(Role r : roles){
            if(r.getName().equals(name)){
                return r;
            }
        }
        return null;
    }
    public Staff getStaffByName(String name){
        for(Staff s : staffs){
            if(s.getName().equals(name)){
                return s;
            }
        }
        return null;
    }


}
