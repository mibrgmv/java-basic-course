package io_fs_access.advanced_capabilities;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class AdvancedCapabilities {

    public static Animal[] deserializeAnimalArray(byte[] data) {
        Animal[] animals = null;

        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            int n = ois.readInt();
            animals = new Animal[n];

            for (int i=1; i<=n; ++i) {
                Animal animal = (Animal) ois.readObject();
                animals[i-1] = animal;
            }
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            throw new IllegalArgumentException();
        }

        return animals;
    }
}
