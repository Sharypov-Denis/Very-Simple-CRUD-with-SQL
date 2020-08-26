import model.Dog;
import storage.ArraysStorage;
import storage.SqlStorage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StartClassSQLStorage {
    private static SqlStorage STORAGE = new SqlStorage();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Dog dog;
        while (true) {
            System.out.println("Введите одну из команд - (size | create newDogName | update | delete | clear | get | exit): ");
            String[] params = reader.readLine().trim().toLowerCase().split(" ");
            if (params.length < 1 || params.length > 3) {
                System.out.println("Неверная команда.");
                continue;
            }
            String param = null;
            if (params.length > 1) {
                param = params[1].intern();
            }
            switch (params[0]) {
                case "size":
                    System.out.println(STORAGE.getSize());
                    break;
                case "create":
                    System.out.println("Укажите новое имя собаки для обновления");
                    String name = reader.readLine();
                    System.out.println("Укажите номер");
                    int uuid = Integer.parseInt(reader.readLine());
                    System.out.println("Укажите возраст");
                    int age = Integer.parseInt(reader.readLine());
                    dog = new Dog(name, uuid, age);
                    STORAGE.createDog(dog);
                    STORAGE.getSize();
                    break;
                case "update":
                    System.out.println("Укажите номер собаки для обновления");
                    int uuidUpdate = Integer.parseInt(reader.readLine());
                    System.out.println("Укажите новое имя собаки для обновления");
                    String nameUpdate = reader.readLine();
                    System.out.println("Укажите возраст для обновления");
                    int ageUpdate = Integer.parseInt(reader.readLine());
                    STORAGE.update(uuidUpdate, nameUpdate, ageUpdate);
                    break;
                case "delete":
                    System.out.println("Укажите номер собаки для удаления");
                    int uuidDel = Integer.parseInt(reader.readLine());
                    STORAGE.delete(uuidDel);
                    break;
                case "get":
                    System.out.println("Укажите номер собаки для отображения данных");
                    int uuidGet = Integer.parseInt(reader.readLine());
                    System.out.println(STORAGE.get(uuidGet));
                    break;
                case "clear":
                    STORAGE.clear();
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