package storage;

import model.Dog;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArraysStorageTest {
    protected ArraysStorage arraysStorage = new ArraysStorage();
    private static final Dog DOG_1 = new Dog(1,"Name 1" , 1);
    private static final Dog DOG_2 = new Dog(2,"Name 2" , 2);
    private static final Dog DOG_3 = new Dog(3,"Name 3" , 3);

    private static final Dog DOG_4 = new Dog(4,"Name 4" , 4);
    private static final Dog DOG_5 = new Dog(5,"Name 5" , 5);

    @Before
    public void setUp() {
        arraysStorage.clear();
        arraysStorage.create(DOG_1);
        arraysStorage.create(DOG_2);
        arraysStorage.create(DOG_3);
    }

    @Test
    public void create() {
        arraysStorage.create(DOG_4);
        arraysStorage.create(DOG_5);
        assertEquals(5, arraysStorage.getSize());
        //при помощи метода отдельного
        assertSize(5);
    }

    @Test
    public void get() {
    }

    @Test
    public void update() {

    }

    @Test
    public void delete() {
        arraysStorage.delete(1);
        assertSize(2);
    }

    @Test
    public void getAll() {

    }

    @Test
    public void clear() {
        arraysStorage.clear();
        assertEquals(0, arraysStorage.getSize());
    }

    @Test
    public void getSize() {
        assertEquals(2 ,2);
    }

    private void assertSize(int size) {
        assertEquals(size, arraysStorage.getSize());
    }

    private void assertGet(Dog dog) {
        assertEquals(dog, arraysStorage.get(dog.getUuid()));
    }

}