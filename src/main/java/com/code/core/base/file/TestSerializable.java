package com.code.core.base.file;

import java.io.*;

public class TestSerializable {

    public static void main(String[] args) throws Exception {
        TestSerializable testSerializable = new TestSerializable();
//        testSerializable.write(testSerializable);
        System.out.println("=============================");
        testSerializable.read();
    }

    public void read() throws Exception {
        File file = new File("D:\\tmp\\aa.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object o = objectInputStream.readObject();
        User o1 = (User) o;
//        System.out.println(o1.getParent());
    }

    public void write(TestSerializable testSerializable) throws Exception {
        User user = testSerializable.getUser();
        File file = new File("D:\\tmp\\aa.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(user);
        objectOutputStream.close();
    }

    public User getUser() {
        User user = new User();
        user.setId("001");
        user.setName("name001");
        user.setAge(1);
        user.setItemId("itemId001");
        return user;
    }
}
