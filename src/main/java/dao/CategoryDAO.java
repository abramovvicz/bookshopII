package dao;

import enums.FileTypes;
import model.Category;
import utils.ApplicationStatus;
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
    private ApplicationStatus applicationStatus = ApplicationStatus.getInstance();


    public void addCategoryToList(int id, String name, int priority) {
        applicationStatus.setStatus(true);

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
        if (categoryList.isEmpty()) {
            System.out.println("Sorry category list is empty");
        }
        System.out.println("Enter category ID to delete");
        List<Category> copyAuthorsList = new ArrayList<>(categoryList);
        boolean flag = true;
        while (flag) {
            int idEnteredByUser = userInput.getNumberFromUser();
            for (Category category : copyAuthorsList) {
                if (category.getCategoryID() == idEnteredByUser) {
                    categoryList.remove(category);
                    applicationStatus.setStatus(true);
                    System.out.println("Successfully remove category");
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("Did`nt find category, please enter another ID");
            }
        }
    }

    public void deleteCategoryByIDStream(List<Category> categoryList) {
        if (categoryList.isEmpty()) {
            System.out.println("Sorry category list is empty");
        }
        System.out.println("Enter category ID to delete");
        List<Category> copyCategoryList = new ArrayList<>(categoryList);
        while (true) {
            int chosenCategoryId = userInput.getNumberFromUser();
            Optional<Category> foundCategory = copyCategoryList
                    .stream().filter(x -> x.getCategoryID() == chosenCategoryId).findFirst();
            if (foundCategory.isPresent()) {
                categoryList.remove(foundCategory);
                applicationStatus.setStatus(true);
                System.out.println("Successfully remove category of ID: " + chosenCategoryId);
                break;
            } else {
                System.out.println("Did`int find category id - please renter ID!");
            }

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

    public void getCategoryIdFromUser() {
        System.out.println("Choose category ID to edit");
        while (true) {
            int chosenCategoryId = userInput.getNumberFromUser();
            Optional<Category> foundCategory = dataFromFiles.getListFromCategoryFile()
                    .stream().filter(x -> x.getCategoryID() == chosenCategoryId).findFirst();
            if (foundCategory.isPresent()) {
                foundCategory.get().setCategoryName(getCategoryName());
                applicationStatus.setStatus(true);
                break;
            } else {
                System.out.println("Did`int find category id - please renter ID!");
            }
        }
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

