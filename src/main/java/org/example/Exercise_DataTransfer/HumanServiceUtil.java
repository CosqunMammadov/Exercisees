package org.example.Exercise_DataTransfer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HumanServiceUtil {
    public void insertPeopleTo_DB(List<Human> people) throws SQLException, ClassNotFoundException {
        HumanService humanService = new HumanService();
        for (int i = 0; i < people.size(); i++) {
            humanService.insert(people.get(i));
        }
    }

    public List<Human> getPeople() throws SQLException, ClassNotFoundException {
        HumanService humanService = new HumanService();
        List<Integer> peopleId = humanService.getPeopleId();
        List<Human> people = new LinkedList<>();
        for (int i = 0; i < peopleId.size(); i++) {
            people.add(humanService.getHumanById(peopleId.get(i)));
        }
        return people;
    }
}
