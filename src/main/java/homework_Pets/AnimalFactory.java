package homework_Pets;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class AnimalFactory {
    public static Animal createAnimal(AnimalTypes type) {
        Animal animal;
        String secretInfo = "";
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
        switch (type) {
            case CARP:
                animal = new Carp(Randomizer.generateUUID(), Randomizer.generateUUID(), Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateUUID(), Randomizer.generateRandomDouble(0.0, 11.0), Randomizer.generateUUID(), Randomizer.generateRandomBirthDate(), secretInfo, "Carp");
                break;
            case EAGLE:
                animal = new Eagle(Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateUUID(), Randomizer.generateUUID(), Randomizer.generateUUID(), Randomizer.generateRandomDouble(0.0, 111111.0), Randomizer.generateUUID(), Randomizer.generateRandomBirthDate(), secretInfo,"Eagle");
                break;
            default:
                throw new IllegalArgumentException("Wrong animal type:" + type);
        }
        return animal;
    }
}
