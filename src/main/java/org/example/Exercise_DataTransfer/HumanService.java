package org.example.Exercise_DataTransfer;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HumanService {

    public List<Integer> getPeopleId() throws SQLException, ClassNotFoundException {
        List<Integer> peopleId = new ArrayList<>();
        Connection con = Database.getConnection();
        String sql = "SELECT id FROM people";

        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            peopleId.add(id);
        }
        return peopleId;
    }

    public Human getHumanById(int humanId) throws SQLException, ClassNotFoundException {
        Connection con = Database.getConnection();
        Human human = null;

        String sql = "SELECT * FROM people Where id = ?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, humanId);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            int age = rs.getInt("age");
            int fatherId = rs.getInt("father_id");
            int motherId = rs.getInt("mother_id");

            human = new Human(id, name, surname, age);
            human.setFatherId(fatherId);
            human.setMotherId(motherId);
        }
        return human;
    }

    public int insert(Human human) throws SQLException, ClassNotFoundException {
        Connection con = Database.getConnection();

        String sql = "INSERT INTO people (id, name, surname, age, father_id, mother_id) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, human.getId());
        ps.setString(2, human.getName());
        ps.setString(3, human.getSurname());
        ps.setInt(4, human.getAge());
        ps.setInt(5, human.getFather().getId());
        ps.setInt(6, human.getMother().getId());

        int result = ps.executeUpdate();
        ps.close();
        con.close();

        return result;
    }

    public int update(Human human) throws SQLException, ClassNotFoundException {
        Connection con = Database.getConnection();
        String sql = "UPDATE people SET  name = ?, surname = ?, age = ?, father_id = ?, mother_id = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, human.getName());
        ps.setString(2, human.getSurname());
        ps.setInt(3, human.getAge());
        ps.setInt(4, human.getFather().getId());
        ps.setInt(5, human.getMother().getId());
        ps.setInt(6, human.getId());

        int result = ps.executeUpdate();
        ps.close();
        con.close();

        return result;
    }

    public void updateName() throws SQLException, ClassNotFoundException {
        Connection con = Database.getConnection();
        String sql = "SELECT name FROM people WHERE age > 50";

        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String name = rs.getString("name");
            PreparedStatement prs = con.prepareStatement("UPDATE people SET name = ? WHERE name = ?");
            prs.setString(1, name + "50");
            prs.setString(2, name);
            prs.executeUpdate();
        }
    }

    public int delete(String statement) throws SQLException, ClassNotFoundException {
        Connection con = Database.getConnection();
        String sql = statement;

        PreparedStatement ps = con.prepareStatement(sql);

        int result = ps.executeUpdate();
        ps.close();
        con.close();
        return result;
    }

    public List<Human> orderByAge() throws SQLException, ClassNotFoundException {
        List<Human> orderedPeople = new LinkedList<>();
        Connection con = Database.getConnection();
        String sql = "SELECT * FROM people ORDER BY age";

        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Human human = null;
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            int age = rs.getInt("age");
            int fatherId = rs.getInt("father_id");
            int motherId = rs.getInt("mother_id");

            human = new Human(id, name, surname, age);
            human.setFatherId(fatherId);
            human.setMotherId(motherId);
            orderedPeople.add(human);
        }
        return orderedPeople;
    }


}
