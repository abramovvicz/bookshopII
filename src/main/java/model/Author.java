package model;


import lombok.Getter;

@Getter
public class Author {

    int id;
    String fullName;
    int age;

    public Author(int id, String fullName, int age) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Author ID: " + id + "\n" +
                "FULL NAME: " + fullName + "\n" +
                "AGE: " + age + "\n" + "\n";
    }
}
