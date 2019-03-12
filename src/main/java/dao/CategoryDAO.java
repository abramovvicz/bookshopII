package dao;

import model.Category;
import utils.UserInput;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryDAO {

    private DataFromFiles dataFromFiles = DataFromFiles.getInstance();
    private List<Category> categoryList = dataFromFiles.getListFromCategoryFile();
    private UserInput userInput = new UserInput();


    public void getDataFromUserAboutNewCategory() {
        String categoryName = getCategoryName();
        int categoryPriority = getCategoryPriority();
        int id = generateCategoryID();
        Category category = new Category(id, categoryName, categoryPriority);
        categoryList.add(category);
        System.out.println("Succesfully added new category");
    }

    private int generateCategoryID() { //TODO: trudne ze względu na potrzebę aktualizacji gdy user usunie kategorie itd.
        List<Integer> collect = categoryList.stream().map(x -> x.getCategoryID()).collect(Collectors.toList());

        int generatedID = 1;
        for (int i : collect) {
            if (i == collect.get(collect.size() - 1)) {
                generatedID +=i;
            }
        }
        System.out.println("id category is: " + generatedID);
        return generatedID;

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
        for(Category category: dataFromFiles.getListFromCategoryFile())
        {
            System.out.println("category ID: " + category.getCategoryID());
            System.out.println("chosen by user ID:" + categoryByUserID);
            while (categoryByUserID!=category.getCategoryID())
            {
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
