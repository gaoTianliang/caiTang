package com.code.core.base.file;

import lombok.Data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@Data
public class User extends UserParent implements Serializable {
    private String id;
    private String name;
    private int age;
    private String itemId;

    private void readObjectNoData() {
        System.out.println("============readObjectNoData=============");
    }


    private Object writeReplace() {
        System.out.println("============writeReplace================");
        return this;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        System.out.println("============writeObject================");
        objectOutputStream.writeObject(this.id);
        objectOutputStream.writeObject(this.name);
        //可以指定规则
        objectOutputStream.writeInt(this.age + 1);
        objectOutputStream.writeObject(this.itemId);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        System.out.println("============readObject================");
        this.id = (String) objectInputStream.readObject();
        this.name = (String) objectInputStream.readObject();
        //按照写的方法
        this.age = objectInputStream.readInt() - 1;
        this.itemId = (String) objectInputStream.readObject();
    }

    private Object readResolve() {
        System.out.println("============readResolve================");
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
