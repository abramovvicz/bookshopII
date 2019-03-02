package model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Author {

    private static int counter = 1;
    int id;
    String fullName;
    int age;

    public Author(int id, String fullName, int age) {
        this.id = counter++;
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
