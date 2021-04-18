package com.aarya.javapractice.employees;

import java.io.*;

public class SerializationDemo {

    public static void main(String[] args) {
        Employee e = new Employee("Rajesh Singh", 12178504644L);
        serializeEmployee(e);
        Employee e2 = deserializeEmployee(e.getId());
        System.out.println(e2);
        assert e.getName() == e2.getName();
    }

    private static File getEmployeeFile(long id) {
        File dir = new File("employees");
        if(!dir.exists()) {
            if(!dir.mkdir()) {
                throw new RuntimeException("Error while creating file");
            }
        }
        File f = new File(dir, id + ".ser");
        return f;
    }

    private static void serializeEmployee(Employee e) {
        try(FileOutputStream fOut = new FileOutputStream(getEmployeeFile(e.getId()))) {
           try(ObjectOutputStream out = new ObjectOutputStream(fOut)) {
              out.writeObject(e);
           }
        } catch (IOException | RuntimeException ex) {
            ex.printStackTrace();
        }
    }

    private static Employee deserializeEmployee(long id) {
        Employee e = null;
        try(FileInputStream fIn = new FileInputStream(getEmployeeFile(id))) {
           try(ObjectInputStream in = new ObjectInputStream(fIn)) {
               Object object = in.readObject();
               e = (Employee) object;
           }
        }
        catch(IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return e;
    }
}
