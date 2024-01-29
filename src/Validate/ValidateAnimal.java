package Validate;

import Module.Animal;

import java.util.List;
import java.util.Scanner;

public class ValidateAnimal {
    static Scanner scanner = new Scanner(System.in);

    public static String ValidateAnimalName(List<Animal> animals) {
        while (true) {
            System.out.println("Nhap ten Animal");
            String name = scanner.nextLine();
            boolean check = true;
            for (Animal a : animals) {
                if (a.getName().equals(name)) {
                    check = false;
                    break;
                }
            }
            if (check) {
                return name;
            }
        }
    }

    public static int ValidateAnimalId(List<Animal> animals) {
        int max = 0;
        for (Animal a : animals) {
            if (a.getId() > max) {
                max = a.getId();
            }
        }
        return max+1;
    }
    public static int ValidateAnimalArea(){
        while (true) {
            try{
                System.out.println("Nhap khu vuc trong so thu (1 hoac 2)");
                return Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Nhap lai");
            }
        }

    }
}
