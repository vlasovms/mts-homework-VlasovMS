package homework_Pets;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Map;

public class CreateAnimalServiceImpl implements CreateAnimalService {

    public Map<String, List<Animal>> createAnimals(int n) {
        return AbstractAnimal.createRandomAnimalsMap();
    }

    @Override
    public Map<String, List<Animal>> createAnimals() {
        Map<String, List<Animal>> animalMap = AbstractAnimal.createRandomAnimalsMap();
        try (RandomAccessFile accessFile = new RandomAccessFile("resources/animals/logData.txt", "rw")) {
            accessFile.setLength(0);
            FileChannel fileChannel = accessFile.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1000000);
            int animalCounter = 0;

            for (Map.Entry<String, List<Animal>> str : animalMap.entrySet()) {
                List<Animal> animalList = str.getValue();
                for (Animal animal : animalList) {
                    animalCounter++;
                    String animalStr = animalCounter + " " + animal.getClass().getSimpleName() + " " + animal.getName() + " " + animal.getCost() + " " + animal.getBirthDate() + "\n";
                    buffer.clear();
                    buffer.put(animalStr.getBytes());
                    buffer.flip();

                    while (buffer.hasRemaining()) {
                        fileChannel.write(buffer);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return animalMap;
    }

    public AbstractAnimal createRandomCarp() {
        return (AbstractAnimal) AnimalFactory.createAnimal(AnimalTypes.CARP);
    }

    public AbstractAnimal createRandomEagle() {
        return (AbstractAnimal) AnimalFactory.createAnimal(AnimalTypes.EAGLE);
    }

    public void createAnimalOnCondition(int counter) {
        if (counter % 2 == 0) {   //Для чётного значения счётчика создаём карпа, иначе орла
            System.out.println(createRandomCarp());
        } else {
            System.out.println(createRandomEagle());
        }
    }
}
