package model;


import lombok.Getter;

@Getter
public class Category {
    int categoryID;
    String categoryName;
    int showPriority;

    public Category(int categoryID, String categoryName, int showPriority) {
        this.categoryID = categoryID;
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
