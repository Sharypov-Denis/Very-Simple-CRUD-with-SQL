package storage;

import model.Dog;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlStorage {

    String dbUrl = "jdbc:postgresql://localhost:5432/SimpleCRUD";
    String dbUser = "postgres";
    String dbPassword = "password";

    public static void main(String[] args) {
        SqlStorage sqlStorage = new SqlStorage();
        sqlStorage.create(1, "DOG1", 11);
        sqlStorage.create(2, "DOG2", 22);
        sqlStorage.create(3, "DOG3", 33);
        sqlStorage.getSize();
        sqlStorage.createDog(new Dog(4, "DOG4", 44));
        sqlStorage.createDog(new Dog(5, "DOG5", 55));
        sqlStorage.createDog(new Dog(6, "DOG6", 66));
        System.out.println(sqlStorage.getAllSorted());
        System.out.println(sqlStorage.get(5));
        sqlStorage.delete(4);
        sqlStorage.update(3, "DOG33", 333);
        sqlStorage.clear();
        sqlStorage.getSize();

    }

    public void clear() {
        try (Connection connect = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            PreparedStatement ps = connect.prepareStatement("DELETE FROM dogs");
            ps.execute();
            System.out.println("Operation 'clear' completed!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void create(int uuid, String name, int age) {
        try (Connection connect = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            PreparedStatement ps = connect.prepareStatement("INSERT INTO dogs (uuid, name, age) VALUES (?, ?,?)");
            ps.setInt(1, uuid);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.execute();
            System.out.println("Operation 'clear' completed!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void createDog(Dog dog) {
        try (Connection connect = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            PreparedStatement ps = connect.prepareStatement("INSERT INTO dogs (uuid, name, age) VALUES (?, ?,?)");
            ps.setInt(1, dog.getUuid());
            ps.setString(2, dog.setName());
            ps.setInt(3, dog.setAge());
            ps.execute();
            System.out.println("Operation 'clearDog' completed!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Dog get(int uuid) {
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM dogs WHERE uuid=?");
            ps.setInt(1, uuid);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println("Operation 'get' completed!");
            return new Dog(uuid, name, age);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void update(int uuid, String name, int age) {
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            PreparedStatement ps = connection.prepareStatement("UPDATE dogs SET name=?, age=? WHERE uuid=?");
            ps.setInt(3, uuid);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.execute();
            if (ps.executeUpdate() == 0) {
                System.out.println("error!!");
            } else {
                System.out.println("Operation 'update' completed!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(int uuid) {
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM dogs WHERE uuid=?");
            ps.setInt(1, uuid);
            ps.execute();
            System.out.println("Operation 'delete' completed!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Dog> getAllSorted() {
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM dogs ORDER BY name,age");
            ResultSet resultSet = ps.executeQuery();
            List<Dog> dogs = new ArrayList<>();
            while (resultSet.next()) {
                dogs.add(new Dog(resultSet.getInt("uuid"), resultSet.getString("name"), resultSet.getInt("age")));
            }

            System.out.println("Operation 'getAllSorted' completed!");
            return dogs;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void getSize() {
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select count(*) from dogs");
            int size = resultSet.next() ? resultSet.getInt(1) : 0;
            System.out.println(size);
            System.out.println("Operation 'getSize' completed!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
