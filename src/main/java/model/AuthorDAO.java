package model;

import utils.UtilLoadFiles;

public class AuthorDAO {

    UtilLoadFiles utilLoadFiles = UtilLoadFiles.getInstance();

    public AuthorDAO() {
        utilLoadFiles.readFiles(FileTypes.AUTHORS);
    }


   /* public List<Author> writeAuthorsList(List<String[]> dataFile) {
        //TODO: later
         Author author;

//        for (String[] s : dataFile) {
//            author = new Author(Integer.parseInt(s[0]), s[1], Integer.parseInt(s[2]));
//            authorsList.add(author);
//        }
        dataFile.forEach(x -> authorsList.add(Author author = new Author(Integer.parseInt(x[0]), x[1], Integer.parseInt(x[2]))));
//        authorsList.add(author);
//        System.out.println(authorsList);
//        authorsList.forEach(System.out::print);
        return authorsList;
    }*/
}
