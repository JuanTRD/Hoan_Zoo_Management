package Manager;

import IO.AccountIO;
import IO.AnimalIO;
import Module.Animal;
import Validate.ValidateAnimal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalManager {
    List<Animal> animals = new ArrayList<Animal>();
    Scanner scanner = new Scanner(System.in);

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }
    public void readAnimal(){
        animals = AnimalIO.readAnimal();
    }
    public void writeAnimal(){
        AnimalIO.writeAnimal(animals);
    }
    public void removeAnimal() {
        System.out.println("Nhap ten Animal muon xoa");
        String name = scanner.nextLine();
        int index = getIndexbyName(name);
        if (index != -1) {
            animals.remove(index);
        } else {
            System.out.println("Khong co Animal can tim");
        }
    }

    public int getIndexbyName(String name) {
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public int getIndexbyId(int id) {
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void editAnimal() {
        try {
            System.out.println("Nhap id Animal muon sua");
            int id = Integer.parseInt(scanner.nextLine());
            int index = getIndexbyId(id);
            if (index != -1) {
                animals.set(index, createAnimal());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Animal createAnimal(){
        int id = ValidateAnimal.ValidateAnimalId(animals);
        String name = ValidateAnimal.ValidateAnimalName(animals);
        System.out.println("Nhap chung loai");
        String type = scanner.nextLine();
        int area = ValidateAnimal.ValidateAnimalArea();
        return new Animal(id,name, type, area);
    }
    public void displayAnimal(){
        for (Animal animal : animals){
            System.out.println(animal.toString());
        }
    }
}
