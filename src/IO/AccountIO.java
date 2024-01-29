package IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Manager.AccountManager;
import Module.Account;
public class AccountIO {
    static File accountFile = new File("account.csv");
    static AccountManager accountManager = new AccountManager();
    public static void writeAccount(List<Account> accounts) {
        try {
            FileWriter fileWriter = new FileWriter(accountFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Account a : accounts) {
                bufferedWriter.write(a.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<Account> readAccount() {
        ArrayList<Account> accounts = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(accountFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = "";
            while ((str = bufferedReader.readLine()) != null) {
                String[] arr = str.split(",");
                AccountManager accountManager = new AccountManager();
                Account account = new Account(arr[0], arr[1], accountManager.getRoleByName(arr[2]), accountManager.getStaffByName(arr[4]));
                accounts.add(account);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }
}
