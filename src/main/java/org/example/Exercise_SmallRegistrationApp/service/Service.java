package org.example.Exercise_SmallRegistrationApp.service;

import org.example.Exercise_SmallRegistrationApp.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Service {
    public void insertIntoToPerson(String name, String surname, String fatherName, int age, String gender) throws SQLException, ClassNotFoundException {
        Connection con = Database.getConnection();

        String sql = "INSERT INTO person (name, surname, father_name, age, gender) VALUES(?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, surname);
        ps.setString(3, fatherName);
        ps.setInt(4, age);
        ps.setString(5, gender);

        int result = ps.executeUpdate();
        ps.close();
        con.close();
    }

    public void insertIntoToUser(int personId, String userName, String password) throws SQLException, ClassNotFoundException {
        Connection con = Database.getConnection();

        String sql = "INSERT INTO \"user\" (person_id, user_name, password) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, personId);
        ps.setString(2, userName);
        ps.setString(3, password);

        int result = ps.executeUpdate();
        ps.close();
        con.close();
    }

    public boolean checkUserName(String userName) throws SQLException, ClassNotFoundException {
        Connection con = Database.getConnection();

        String sql = "SELECT user_name FROM \"user\" ";
        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        boolean b = false;
        while (rs.next()){
            String userNameInDB = rs.getString("user_name");
            if (userNameInDB.toLowerCase().equals(userName.toLowerCase()))
                b = true;
        }
        return b;
    }

    public List<Person> getPeople() throws SQLException, ClassNotFoundException {
        Connection con = Database.getConnection();

        String sql = "SELECT * FROM person";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<Person> people = new ArrayList<>();
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String fatherName = rs.getString("father_name");
            int age = rs.getInt("age");
            String gender = rs.getString("gender");
            people.add(new Person(id, name, surname, fatherName, age, gender));
        }
        return people;
    }
}
