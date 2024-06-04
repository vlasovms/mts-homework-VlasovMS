package homeworks_main;

import config.StarterAnimalProperties;
import jakarta.annotation.PostConstruct;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CreateAnimalServiceImpl implements CreateAnimalService {
    private final StarterAnimalProperties props;
    private Map<String, List<Animal>> animalMap;

    public CreateAnimalServiceImpl(StarterAnimalProperties props) {
        this.props = props;

    }

    @PostConstruct
    @Override
    public Map<String, List<Animal>> createAnimals() {

        Map<String, List<Animal>> animalMap = AbstractAnimal.createRandomAnimalsMap();
        String[] animalNames = props.getAnimalNames();
        Random rnd = new Random();

        try (RandomAccessFile accessFile = new RandomAccessFile("resources/animals/logData.txt", "rw")) {
            accessFile.setLength(0);
            FileChannel fileChannel = accessFile.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1000000);
            int animalCounter = 0;

            for (Map.Entry<String, List<Animal>> str : animalMap.entrySet()) {
                List<Animal> animalList = str.getValue();
                for (Animal animal : animalList) {
                    animalCounter++;
                    int index = rnd.nextInt(animalNames.length);
                    String animalStr = animalCounter + " " + animal.getClass().getSimpleName() + " " + animalNames[index] + " " + animal.getCost() + " " + animal.getBirthDate() + "\n";
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
        this.animalMap = animalMap;
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

    public Map<String, List<Animal>> getAnimalMap() {
        return animalMap;
    }
}
