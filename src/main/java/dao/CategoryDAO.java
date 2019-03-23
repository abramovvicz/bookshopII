package dao;

import enums.FileTypes;
import model.Category;
import utils.Status;
import utils.UserInput;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CategoryDAO {

    private DataFromFiles dataFromFiles = DataFromFiles.getInstance();
    private UserInput userInput = new UserInput();
    private Status status = Status.getInstance();


    public void addCategoryToList(int id, String name, int priority) {
        status.setStatus(true);

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


    public void deleteCategoryByID(List<Category> categoryList) {
        System.out.println("Enter category ID to delete");
        List<Category> copyAuthorsList = new ArrayList<>(categoryList);
        boolean flag = true;
        while (flag) {
            int idEnteredByUser = getCategoryIdFromUser();
            for (Category category : copyAuthorsList) {
                if (category.getCategoryID() == idEnteredByUser) {
                    categoryList.remove(category);
                    status.setStatus(true);

                    flag = false;
                }
            }
            System.out.println("Did`nt find author with entered ID");
            System.out.println("Please enter another ID");
        }
    }

    private int getCategoryPriority() {
        System.out.println("Please enter category priority from 1 to 5");
        int priority = userInput.getNumberFromUser();
        while (priority < 1 || priority > 5) {
            System.out.println("Priority has to be from 1 to 5");
            priority = userInput.getNumberFromUser();
        }
        return priority;
    }

    private String getCategoryName() {
        System.out.println("Please enter category name");
        String categoryName = userInput.getStringFormUser();
        for (Category category : dataFromFiles.getListFromCategoryFile()) {
            while (category.getCategoryName().equalsIgnoreCase(categoryName)) {
                System.out.print("This category exist please enter another");
                categoryName = userInput.getStringFormUser();
            }
        }
        return categoryName;
    }

    public int getCategoryIdFromUser() {
        int chosenCategoryId;
        while (true) {
            System.out.println("Choose category ID to edit");
            chosenCategoryId = userInput.getNumberFromUser();
            int finalChosenCategoryId = chosenCategoryId;
            Optional<Category> foundCategory = dataFromFiles.getListFromCategoryFile()
                    .stream().filter(x -> x.getCategoryID() == finalChosenCategoryId).findFirst();
            if (foundCategory.isPresent()) {
                foundCategory.get().setCategoryName(getCategoryName());
                status.setStatus(true);

                break;
            }
        }
        return chosenCategoryId;
    }

    public void saveCategoryListToFile(List<Category> categoryList) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(FileTypes.NEW_CATEGORIES.getFileAddress());
            for (Category category : categoryList) {
                String pattern = category.getCategoryID() + ";" + category.getCategoryName() + ";" + category.getPriority();
                fileWriter.write(pattern);
                fileWriter.write("\n");

            }
            System.out.println("Successfully saved");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("There was some problem");
        }
    }


}

