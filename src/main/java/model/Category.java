package model;


import lombok.Getter;

@Getter
public class Category {
    private static int counter = 1;

    int categoryID;
    String categoryName;
    int showPriority;

    public Category(int categoryID, String categoryName, int showPriority) {
        this.categoryID = counter++;
        this.categoryName = categoryName;
        this.showPriority = showPriority;
    }

    @Override
    public String toString() {
        return categoryID + "\n" +
//                "Id: " + id +
                "Name Category: " + categoryName + "\n" +
                "Priority: " + showPriority + "\n";
    }
}
