package test.lesson_5_4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import study.java_lessons.lesson_5_4.Animal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static study.java_lessons.lesson_5_4.Main.deserializeAnimalArray;

public class TestAnimal {

    private static <T> byte[] ArrayConvert(T[] objects) throws IOException {
        var bytes = new ByteArrayOutputStream();
        try (ObjectOutputStream out = new ObjectOutputStream(bytes)) {
            out.writeInt(objects.length);
            for (T obj : objects) {
                out.writeObject(obj);
            }
        }
        return bytes.toByteArray();
    }

    @Test
    public void test1() throws IOException {
        Animal[] animals = {
                new Animal("Cat"), new Animal("Dog"), new Animal("Elephant"),
                new Animal("Cock"), new Animal("Bull"), new Animal("Ant"),
                new Animal("Tentecles"), new Animal("Worm")
        };

        Animal[] animalsRes = deserializeAnimalArray(ArrayConvert(animals));

        Assertions.assertArrayEquals(animals, animalsRes);
    }

    @Test
    public void test2() {
        String[] animals = {
                "werwr", "qweqwe"
        };

//        Animal[] animalsRes = deserializeAnimalArray(ArrayConvert(animals));
//        Assertions.assertArrayEquals(animals, animalsRes);

        Assertions.assertThrows(IllegalArgumentException.class, () -> deserializeAnimalArray(ArrayConvert(animals)));
    }
}
