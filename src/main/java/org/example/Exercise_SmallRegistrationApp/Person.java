package org.example.Exercise_SmallRegistrationApp;

public class Person {
    int id;
    String name;
    String surname;
    String fatherName;
    int age;
    Gender gender;

    public Person(int id, String name, String surname, String fatherName, int age, String gender) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
        this.age = age;
        if (gender.equals("MALE"))
            this.gender = Gender.MALE;
        else this.gender = Gender.FEMALE;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
