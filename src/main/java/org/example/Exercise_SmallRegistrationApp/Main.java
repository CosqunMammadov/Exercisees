package org.example.Exercise_SmallRegistrationApp;

import org.example.Exercise_SmallRegistrationApp.service.Commands;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        startApp();
    }

    public static void startApp() throws SQLException, ClassNotFoundException {
        Commands commands = new Commands();
        Scanner scan = new Scanner(System.in);
        while (true){
            System.out.println("Write one of the commands [ sp (Save Person), ru (Register User), shp (Show People)] and press ENTER");
            String command = scan.next();
            if (command.toLowerCase().equals("sp"))
                commands.savePerson();
            else if (command.toLowerCase().equals("ru"))
                commands.registerUser();
            else if (command.toLowerCase().equals("shp"))
                commands.showPeople();
            else if (command.toLowerCase().equals("exit"))
                break;
            else
                System.out.println("Type the command correctly!");
        }
    }
}
