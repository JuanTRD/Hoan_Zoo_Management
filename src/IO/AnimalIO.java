package IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Module.Animal;

public class AnimalIO {
    static File animalFile = new File("animal.csv");

    public static void writeAnimal(List<Animal> animals) {
        try {
            FileWriter fileWriter = new FileWriter(animalFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Animal a : animals) {
                bufferedWriter.write(a.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<Animal> readAnimal() {
        ArrayList<Animal> animals = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(animalFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = "";
            while ((str = bufferedReader.readLine()) != null) {
                String[] arr = str.split(",");
                Animal animal = new Animal(Integer.parseInt(arr[0]), arr[1],arr[2],Integer.parseInt(arr[3]));
                animals.add(animal);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
        return animals;
    }
}
