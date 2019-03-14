package model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Author {

    private int id;
    private String fullName;
    private int age;

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
