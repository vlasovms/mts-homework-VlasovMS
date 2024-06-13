package homeworks_main;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {
    public static Double generateRandomDouble(double min, double max) {
        return ThreadLocalRandom.current().nextDouble(min, max);
    }

    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public static LocalDate generateRandomBirthDate() {
        Date startDate = new Date(0);
        Date endDate = new Date();
        long random = ThreadLocalRandom.current().nextLong(startDate.getTime(), endDate.getTime());
        return Instant.ofEpochMilli(random).atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
