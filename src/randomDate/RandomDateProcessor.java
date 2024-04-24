package randomDate;

import java.lang.reflect.Field;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDateProcessor {
    public static void processRandomDate(Object obj) {
        for (Field declaredField : obj.getClass().getDeclaredFields()) {
            RandomDate annotation = declaredField.getAnnotation(RandomDate.class);
            if (annotation != null) {
                long min = annotation.min();
                long max = annotation.max();
                declaredField.setAccessible(true);

                if (declaredField.getType().isAssignableFrom(LocalDate.class)) {
                    setRandomDate(obj, declaredField, min, max, RandomDateProcessor::convertToLocalDate);
                } else if (declaredField.getType().isAssignableFrom(LocalDateTime.class)) {
                    setRandomDate(obj, declaredField, min, max, RandomDateProcessor::convertToLocalDateTime);
                } else if (declaredField.getType().isAssignableFrom(Date.class)) {
                    setRandomDate(obj, declaredField, min, max, RandomDateProcessor::convertToDate);
                }
            }
        }
    }

    private static <T> void setRandomDate(Object obj, Field field, long min, long max, DateConverter<T> converter) {
        try {
            field.set(obj, converter.convert(ThreadLocalRandom.current().nextLong(min, max)));
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error setting random date: " + e.getMessage());
        }
    }

    public static LocalDate convertToLocalDate(long randomEpochDay) {
        ZoneId myZone = ZoneId.systemDefault();
        return LocalDate.ofInstant(Instant.ofEpochSecond(randomEpochDay), myZone);
    }

    public static LocalDateTime convertToLocalDateTime(long randomEpochDay) {
        ZoneId myZone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(randomEpochDay), myZone);
    }

    public static Date convertToDate(long randomEpochDay) {
        return Date.from(Instant.ofEpochSecond(randomEpochDay));
    }
}

