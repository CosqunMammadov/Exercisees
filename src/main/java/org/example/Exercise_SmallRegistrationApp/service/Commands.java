package org.example.Exercise_SmallRegistrationApp.service;

import org.example.Exercise_SmallRegistrationApp.Person;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Commands {

    public void savePerson() throws SQLException, ClassNotFoundException {          // sp
        Scanner scan = new Scanner(System.in);
        System.out.println("Write and press ENTER");

        System.out.println("Name: ");
        String name = scan.next();

        System.out.println("Surname: ");
        String surname = scan.next();

        System.out.println("Father name: ");
        String fatherName = scan.next();

        System.out.println("Age: ");
        int age = scan.nextInt();

        System.out.println("Gender: ");
        String gender = scan.next();
        if (gender.toLowerCase().equals("male"))
            gender = "MALE";
        else gender = "FEMALE";

        Service service = new Service();
        service.insertIntoToPerson(name, surname, fatherName, age, gender);
        System.out.println("Insertion is successful.");
    }

    public void registerUser() throws SQLException, ClassNotFoundException {          // ru
        Scanner scan = new Scanner(System.in);
        Service service = new Service();

        System.out.println("Write and press ENTER");
        System.out.println("Person Id: ");
        int personId = scan.nextInt();

        String userName;
        while (true) {
            System.out.println("Username: ");
            userName = scan.next();
            if (service.checkUserName(userName))
                System.out.println("Please change username.");
            else break;
        }

        System.out.println("Password: ");
        String password = scan.next();

        service.insertIntoToUser(personId, userName, password);
        System.out.println("Registration is successful.");
    }

    public List<Person> showPeople() throws SQLException, ClassNotFoundException {     // shp
        Service service = new Service();
        System.out.println(service.getPeople());
        return service.getPeople();
    }
}
