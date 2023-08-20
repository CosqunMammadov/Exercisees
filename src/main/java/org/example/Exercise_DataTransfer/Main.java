package org.example.Exercise_DataTransfer;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        List<Human> people = HumanUtil.loadPeople();

//        FileUtil.readFromFile("/Applications/idea/java-group-sip/docs/human.json")
//                .forEach(System.out::println);

        HumanServiceUtil humanServiceUtil = new HumanServiceUtil();

        humanServiceUtil.insertPeopleTo_DB(people);
//        System.out.println(humanServiceUtil.getPeople());

        HumanService humanService = new HumanService();
//        System.out.println(humanService.orderByAge());

//        humanService.delete("DELETE FROM people WHERE age > 40 AND age < 50");
        humanService.updateName();
    }
}