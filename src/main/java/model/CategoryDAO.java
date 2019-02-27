package model;

import utils.UtilLoadFiles;

import java.io.IOException;
import java.util.List;

public class CategoryDAO {

    private UtilLoadFiles utilLoadFiles = UtilLoadFiles.getInstance();

    private List<Category> categoryList = utilLoadFiles.loadCategoryFile(FileTypes.CATEGORIES.getFileAdress());

    public CategoryDAO() throws IOException {
    }
}
