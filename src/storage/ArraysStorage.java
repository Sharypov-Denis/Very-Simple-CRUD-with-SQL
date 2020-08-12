package storage;

import model.Dog;

import java.util.ArrayList;
import java.util.List;

public class ArraysStorage {
    protected List<Dog> storage = new ArrayList<>();

    public void create(Dog dog) {
        storage.add(dog);
    }

    public Dog get(int uuid) {
        return storage.get(uuid);
    }

    public void update(int uuid, Dog newDog) {
        storage.set(uuid, newDog);
    }

    public void delete(int uuid) {
        storage.remove(uuid);
    }

    public void getAll() {
        for (int i = 0; i < storage.size(); i++) {
            System.out.println(storage.get(i));
        }
    }

    public void clear() {
        storage.clear();
    }

    public int getSize() {
        return storage.size();
    }
}
