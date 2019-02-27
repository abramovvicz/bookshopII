package model;

import utils.UtilLoadFiles;

import java.io.IOException;

public class BookDAO {
    UtilLoadFiles utilLoadFiles = UtilLoadFiles.getInstance();

    public BookDAO()  {
        utilLoadFiles.readFiles(FileTypes.BOOKS);
    }
}
