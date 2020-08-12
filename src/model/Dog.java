package model;

import javax.xml.bind.annotation.XmlAttribute;

public class Dog {
    private int uuid;
    private String name;
    private int age;

    public Dog(int uuid, String name, int age) {
        this.uuid = uuid;
        this.name = name;
        this.age = age;
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Dog() {
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "номер записи: " + uuid + ", Имя собаки: " + name + ", возраст собаки: " + age;
    }

    public String setName() {
        return name;
    }
    public int setAge(){
        return age;
    }
}
