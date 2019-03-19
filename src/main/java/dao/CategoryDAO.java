package dao;

import model.Category;
import utils.UserInput;

import java.util.Comparator;
import java.util.Optional;

public class CategoryDAO {

    private DataFromFiles dataFromFiles = DataFromFiles.getInstance();
    private UserInput userInput = new UserInput();


    public void addCategoryToList(int id, String name, int priority) {
        Category category = new Category(id, name, priority);
        dataFromFiles.getListFromCategoryFile().add(category);
        System.out.println("Successfully added new category");
    }

    public void getDataFromUserAboutNewCategory() {
        String categoryName = getCategoryName();
        int categoryPriority = getCategoryPriority();
        int id = generateCategoryID();
        addCategoryToList(id, categoryName, categoryPriority);
    }

    private int generateCategoryID() {
        if (dataFromFiles.getListFromCategoryFile().isEmpty()) {
            return 1;
        }
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
                System.out.print("This category exist please enter another");
                categoryName = userInput.getStringFormUser("");
            }
        }
        return categoryName;
    }

    public void getCategoryIdFromUser() {
        while (true) {
            int chosenCategoryId = userInput.getNumberFromUser("Choose category ID to edit");
            Optional<Category> foundCategory = dataFromFiles.getListFromCategoryFile()
                    .stream().filter(x -> x.getCategoryID() == chosenCategoryId).findFirst();
            if (foundCategory.isPresent()) {
                foundCategory.get().setCategoryName(getCategoryName());
                break;
            }
        }
    }
}

