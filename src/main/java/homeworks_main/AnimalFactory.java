package homeworks_main;

import config.ApplicationPropertiesHolder;
import config.StarterAnimalProperties;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

public class AnimalFactory {


    public static Animal createAnimal(AnimalTypes type) {
        Animal animal;
        String secretInfo = "";
        StarterAnimalProperties props = ApplicationPropertiesHolder.getApplicationProperties();
        String[] animalNames = props.getAnimalNames(); //props.getAnimalNames();
        Random rnd = new Random();
        try (RandomAccessFile accessFile = new RandomAccessFile("resources/secretStore/secretInformation.txt", "rw")) {  //Вычитываем secretInformation о животном из файла для передачи в конструктор
            FileChannel fileChannel = accessFile.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(48);
            int bytesRead = fileChannel.read(buffer);
            while (bytesRead != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    secretInfo = secretInfo + (char) buffer.get();
                }
                buffer.clear();
                bytesRead = fileChannel.read(buffer);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        int index = rnd.nextInt(animalNames.length);
        switch (type) {
            case CARP:
                animal = new Carp(Randomizer.generateUUID(), animalNames[index], Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateUUID(), Randomizer.generateRandomDouble(0.0, 11.0), Randomizer.generateUUID(), Randomizer.generateRandomBirthDate(), secretInfo, "Carp");
                break;
            case EAGLE:
                animal = new Eagle(Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateUUID(), Randomizer.generateUUID(), animalNames[index], Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateUUID(), Randomizer.generateRandomBirthDate(), secretInfo, "Eagle");
                break;
            default:
                throw new IllegalArgumentException("Wrong animal type:" + type);
        }
        return animal;
    }
}
