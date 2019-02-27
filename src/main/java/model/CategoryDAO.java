package model;

import utils.UtilLoadFiles;

import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    private UtilLoadFiles utilLoadFiles = UtilLoadFiles.getInstance();

    private List<Category> categoryList = new ArrayList<>();

    public CategoryDAO() {
        utilLoadFiles.readFiles(FileTypes.CATEGORIES);

    }
}
