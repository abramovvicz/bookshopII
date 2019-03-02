package model;

import utils.UserInput;
import utils.UtilLoadFiles;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryDAO {

    private UtilLoadFiles utilLoadFiles = UtilLoadFiles.getInstance();
    private List<Category> categoryList = UtilLoadFiles.listFromCategoryFile;
    private UserInput userInput = new UserInput();
    private Category category;
    private String cagtegoryName = "";
    private int priority = 0;

    public CategoryDAO() {
        utilLoadFiles.readFiles(FileTypes.CATEGORIES);

    }

    public void getDataFromUserAboutNewCategory() {
        String categoryName = getCategoryName();
        getCategoryPriority();
        int id = generateCategoryID();
        category = new Category(id, categoryName, priority);
        categoryList.add(category);
        System.out.println("Succesfully added new category");
        //TODO: add exceptions

    }

    private int generateCategoryID() {
        List<Integer> collect = categoryList.stream().map(x -> x.getCategoryID()).collect(Collectors.toList());
        int generatedID = 0;
        for (int i : collect) {
            if (i == collect.get(collect.size() -1)) {
                generatedID = +i;
            }
        }
        System.out.println("id category is: " + generatedID);
        return generatedID;
    }

    private int getCategoryPriority() {
        System.out.println("Please enter category priority");
        priority = userInput.getNumberFromUser(); //todo: add some exceptions
        return priority;
    }

    private String getCategoryName() {
        System.out.println("Plaese enter category name");
        String categoryName = userInput.getStringFormUser();
        //todo: check if category exist

        return categoryName;
    }


}
