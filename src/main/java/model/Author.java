package model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Author {

    private int id;
    private String fullName;
    private int age;

    @Override
    public String toString() {
        return "Author ID: " + id + "\n" +
                "FULL NAME: " + fullName + "\n" +
                "AGE: " + age + "\n" + "\n";
    }
}
