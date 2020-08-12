import model.Dog;
import storage.ArraysStorage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StartClass {

    private final static ArraysStorage STORAGE = new ArraysStorage();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Dog dog;
        while (true) {
            System.out.println("Введите одну из команд - (create newDogName | size | exit): ");
            String[] params = reader.readLine().trim().toLowerCase().split(" ");
            if (params.length < 1 || params.length > 3) {
                System.out.println("Неверная команда.");
                continue;
            }
            String param = null;
            if (params.length == 2) {
                param = params[1].intern();
            }
            switch (params[0]) {
                case "size":
                    System.out.println(STORAGE.getSize());
                    break;
                case "create":
                    System.out.println("Укажите возраст");
                    int age = Integer.parseInt(reader.readLine());
                    dog = new Dog(param, age);
                    STORAGE.create(dog);
                    STORAGE.getAll();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Неверная команда.");
                    break;
            }
        }

    }
}
