package model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {

    private int categoryID;
    private String categoryName;
    private int priority;

    public Category(int categoryID, String categoryName, int priority) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return categoryID + "\n" +
                "Name Category: " + categoryName + "\n" +
                "Priority: " + priority + "\n";
    }

}
