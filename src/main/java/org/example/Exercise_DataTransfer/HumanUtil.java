package org.example.Exercise_DataTransfer;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class HumanUtil {
    public static List<Human> loadPeople() {
        List<Human> people = new LinkedList<>();

        Human person1 = new Human(1,"John", "Smith", 30);
        Human person2 = new Human(2,"Jane", "Doe", 28);
        Human person3 = new Human(3,"Michael", "Johnson", 25);
        Human person4 = new Human(4,"Emily", "Williams", 22);
        Human person5 = new Human(5,"William", "Brown", 40);
        Human person6 = new Human(6,"Emma", "Miller", 35);
        Human person7 = new Human(7,"James", "Davis", 18);
        Human person8 = new Human(8,"Olivia", "Garcia", 54);
        Human person9 = new Human(9,"Robert", "Jones", 48);
        Human person10 = new Human(10,"Shia", "Rodriguez", 28);
        Human person11 = new Human(11,"ivia", "Garcia", 50);
        Human person12 = new Human(12,"Rert", "Jones", 48);
        Human person13 = new Human(13,"Ovia", "Garcia", 64);
        Human person14 = new Human(14,"Robt", "Jones", 48);
        Human person15 = new Human(15,"Olia", "Garcia", 55);



        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);
        people.add(person6);
        people.add(person7);
        people.add(person8);
        people.add(person9);
        people.add(person10);
        people.add(person11);
        people.add(person12);
        people.add(person13);
        people.add(person14);
        people.add(person15);

        person1.setFather(person4);
        person1.setMother(person5);
        person2.setFather(person8);
        person2.setMother(person9);
        person3.setFather(person6);
        person3.setMother(person7);
        person4.setFather(person10);
        person4.setMother(person11);
        person5.setFather(person12);
        person5.setMother(person13);
        person6.setFather(person14);
        person6.setMother(person15);
        person7.setFather(person4);
        person7.setMother(person5);
        person8.setFather(person4);
        person8.setMother(person7);
        person9.setFather(person8);
        person9.setMother(person11);
        person10.setFather(person4);
        person10.setMother(person13);
        person11.setFather(person3);
        person11.setMother(person9);
        person12.setFather(person6);
        person12.setMother(person15);
        person13.setFather(person6);
        person13.setMother(person9);
        person14.setFather(person10);
        person14.setMother(person7);
        person15.setFather(person6);
        person15.setMother(person11);

        return people;
    }

    public static void showPeopleByNameSortedDesc(List<Human> people) {
        people.stream()
                .sorted(Comparator.comparing(Human::getName, Comparator.reverseOrder()))
                .toList()
                .forEach(System.out::println);
    }

    public static void showPeopleByNameSortedAsc(List<Human> people) {
        people.stream()
                .sorted(Comparator.comparing(Human::getName))
                .toList()
                .forEach(System.out::println);
    }

    public static void showPeopleBySurnameSortedDesc(List<Human> people) {
        people.stream()
                .sorted(Comparator.comparing(Human::getSurname, Comparator.reverseOrder()))
                .toList()
                .forEach(System.out::println);
    }

    public static void showPeopleBySurnameSortedAsc(List<Human> people) {
        people.stream()
                .sorted(Comparator.comparing(Human::getSurname))
                .toList()
                .forEach(System.out::println);
    }

    public static void showPeopleByAgeSortedDesc(List<Human> people) {
        people.stream()
                .sorted(Comparator.comparing(Human::getAge, Comparator.reverseOrder()))
                .toList()
                .forEach(System.out::println);
    }

    public static void showPeopleByAgeSortedAsc(List<Human> people) {
        people.stream()
                .sorted(Comparator.comparing(Human::getAge))
                .toList()
                .forEach(System.out::println);
    }

    public static int findAvgAge(List<Human> people) {
        return (int) people.stream()
                .mapToInt(Human::getAge)
                .average()
                .orElse(0);
    }

    public static Human findOlderPerson(List<Human> people) {

        return people.stream()
                .max(Comparator.comparing(Human::getAge))
                .orElse(null);
    }

    public static Human findYoungerPerson(List<Human> people) {

        return people.stream()
                .min(Comparator.comparing(Human::getAge))
                .orElse(null);
    }
}