package model;

import utils.UtilLoadFiles;

import java.io.IOException;
import java.util.List;

public class AuthorDAO {

    UtilLoadFiles utilLoadFiles = UtilLoadFiles.getInstance();
    private Author author;
    private List<Author> authorsList = utilLoadFiles.loadAuthorFile(FileTypes.AUTHORS.getFileAdress());

    public AuthorDAO() throws IOException {
//        writeAuthorsList(dataFile);
    }


    public List<Author> writeAuthorsList(List<String[]> dataFile) {
//        for (String[] s : dataFile) {
//            author = new Author(Integer.parseInt(s[0]), s[1], Integer.parseInt(s[2]));
//            authorsList.add(author);
//        }
        dataFile.forEach(x -> authorsList.add(author = new Author(Integer.parseInt(x[0]), x[1], Integer.parseInt(x[2]))));
//        authorsList.add(author);
//        System.out.println(authorsList);
//        authorsList.forEach(System.out::print);
        return authorsList;
    }
}
