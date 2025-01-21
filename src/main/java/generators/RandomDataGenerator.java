package generators;

import com.github.javafaker.Faker;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Random;

public class RandomDataGenerator {

    private static final Faker faker = new Faker();
    private static final Random random = new Random();

    public static <T> T generateRandomData(Class<T> clazz) {
        try {
            T instance = clazz.getDeclaredConstructor().newInstance();

            for (Field field : clazz.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers())) {
                    continue;
                }
                field.setAccessible(true);
                field.set(instance, getRandomValueForField(field));
            }
            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate random data for class: " + clazz.getName(), e);
        }
    }

    private static Object getRandomValueForField(Field field) {
        Class<?> fieldType = field.getType();

        if (fieldType == String.class) {
            return faker.lorem().sentence();
        } else if (fieldType == int.class || fieldType == Integer.class) {
            return random.nextInt(1000);
        } else if (fieldType == long.class || fieldType == Long.class) {
            return random.nextLong();
        } else if (fieldType == double.class || fieldType == Double.class) {
            return random.nextDouble();
        } else if (fieldType == boolean.class || fieldType == Boolean.class) {
            return random.nextBoolean();
        } else if (fieldType == float.class || fieldType == Float.class) {
            return random.nextFloat();
        } else if (fieldType.isEnum()) {
            Object[] constants = fieldType.getEnumConstants();
            return constants[random.nextInt(constants.length)];
        }
        return null;
    }
}
