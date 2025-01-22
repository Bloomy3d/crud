package generators;

import java.lang.reflect.Field;
import java.util.Random;

public class RandomDataGenerator {

    private static final Random random = new Random();

    public static <T> T generateRandomData(Class<T> clazz) {
        try {
            T instance = clazz.getDeclaredConstructor().newInstance();

            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);

                if (field.getType().equals(String.class)) {
                    field.set(instance, generateString(field));
                } else if (field.getType().equals(int.class) || field.getType().equals(Integer.class)) {
                    field.set(instance, random.nextInt(100)); // Example range
                } else if (field.getType().equals(long.class) || field.getType().equals(Long.class)) {
                    field.set(instance, random.nextLong()); // Random long value
                } else if (field.getType().isEnum()) {
                    Object[] enumConstants = field.getType().getEnumConstants();
                    field.set(instance, enumConstants[random.nextInt(enumConstants.length)]);
                } else {
                    field.set(instance, generateRandomData(field.getType()));
                }
            }
            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate instance of " + clazz.getName(), e);
        }
    }

    private static String generateString(Field field) {
        int length = 10;
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append((char) ('a' + random.nextInt(26)));
        }
        return sb.toString();
    }
}