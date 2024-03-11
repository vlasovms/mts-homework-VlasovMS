package homework_Pets;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {
    public static Double generateRandomDouble(double min, double max) {
        return ThreadLocalRandom.current().nextDouble(min, max);
    }

    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }
}
