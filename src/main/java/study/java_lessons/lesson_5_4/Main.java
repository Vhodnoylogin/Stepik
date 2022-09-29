package study.java_lessons.lesson_5_4;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main {
    public static void main(String[] args) {

    }

    public static Animal[] deserializeAnimalArray(byte[] data) throws IllegalArgumentException {
        try (ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(data))) {
            int num = in.readInt();
            Animal[] objects = new Animal[num];
            for (int i = 0; i < num; i++) {
                objects[i] = (Animal) in.readObject();
            }
            return objects;
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
