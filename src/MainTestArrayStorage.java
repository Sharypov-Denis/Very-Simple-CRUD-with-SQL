import model.Dog;
import storage.ArraysStorage;

public class MainTestArrayStorage {

    static final ArraysStorage ARRAYS_STORAGE = new ArraysStorage();

    public static void main(String[] args) {
        Dog one = new Dog(001, "Name 1", 1);
        Dog two = new Dog(002,"Name 2", 2);
        Dog three = new Dog(003,"Name 3", 3);

        ARRAYS_STORAGE.create(one);
        ARRAYS_STORAGE.create(two);
        ARRAYS_STORAGE.create(three);

        System.out.println(ARRAYS_STORAGE.get(0));

        ARRAYS_STORAGE.update(1, three);

        ARRAYS_STORAGE.delete(2);
        three.setName("Marfa");
        ARRAYS_STORAGE.getAll();

        System.out.println(ARRAYS_STORAGE.getSize());
        ARRAYS_STORAGE.clear();
        System.out.println(ARRAYS_STORAGE.getSize());

    }
}
