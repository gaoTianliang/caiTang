package com.code.core.base.file;

import lombok.Data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@Data
public class User implements Serializable {
    private String id;
    private String name;
    private int age;
    private String itemId;

    private Object writeReplace() {
        return this;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        System.out.println("============write================");
        objectOutputStream.writeObject(this.id);
        objectOutputStream.writeObject(this.name);
        objectOutputStream.writeInt(this.age);
        objectOutputStream.writeObject(this.itemId);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        System.out.println("============read================");
        this.id = (String) objectInputStream.readObject();
        this.name = (String) objectInputStream.readObject();
        this.age = objectInputStream.readInt();
        this.itemId = (String) objectInputStream.readObject();
    }

    private Object readResolve() {
        return this;
    }

    public User() {
    }

    public User(String id, String itemId) {
        this.id = id;
        this.itemId = itemId;
    }

    public User(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
