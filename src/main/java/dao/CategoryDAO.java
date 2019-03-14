package dao;

import model.Category;
import utils.UserInput;

import java.util.Comparator;
import java.util.List;

public class CategoryDAO {

    private DataFromFiles dataFromFiles = DataFromFiles.getInstance();
    private UserInput userInput = new UserInput();


    public void addCategoryToList(int id, String name, int priority) {
        Category category = new Category(id, name, priority);
        dataFromFiles.getListFromCategoryFile().add(category);
        System.out.println("Succesfully added new category");
    }

    public void getDataFromUserAboutNewCategory() {
        String categoryName = getCategoryName();
        int categoryPriority = getCategoryPriority();
        int id = generateCategoryID();
        addCategoryToList(id, categoryName, categoryPriority);
    }

    private int generateCategoryID() {
        Category categoryOfMaxID = dataFromFiles.getListFromCategoryFile().stream().max(Comparator.comparingInt(Category::getCategoryID)).get();
        return categoryOfMaxID.getCategoryID() + 1;

    }

    private int getCategoryPriority() {
        int priority = userInput.getNumberFromUser("Please enter category priority from 1 to 5");
        while (priority < 1 || priority > 5) {
            priority = userInput.getNumberFromUser("Priority has to be from 1 to 5");
        }
        return priority;
    }

    private String getCategoryName() {
        String categoryName = userInput.getStringFormUser("Please enter category name");
        for (Category category : dataFromFiles.getListFromCategoryFile()) {
            while (category.getCategoryName().equalsIgnoreCase(categoryName)) {
                System.out.println("This category exist please enter another");
                categoryName = userInput.getStringFormUser("");
            }
        }
        return categoryName;
    }

    public void getCategoryIdFromUser() {
        int categoryByUserID = userInput.getNumberFromUser("Chose ID Category to edit");
        for (Category category : dataFromFiles.getListFromCategoryFile()) {
            while (categoryByUserID != category.getCategoryID()) {
                System.out.print("Category ID invalid, please chose another ID");
                categoryByUserID = userInput.getNumberFromUser("");
            }
        }

        editCategoryByUser(categoryByUserID, getCategoryName());
    }


    private List<Category> editCategoryByUser(int categoryIdByUser, String nameCategoryByUser) {
        for (Category category : dataFromFiles.getListFromCategoryFile()) {
            if (category.getCategoryID() == categoryIdByUser) {
                int i = dataFromFiles.getListFromCategoryFile().indexOf(category);
                dataFromFiles.getListFromCategoryFile().get(i).setCategoryName(nameCategoryByUser);
            }
        }
        return dataFromFiles.getListFromCategoryFile();
    }
}
