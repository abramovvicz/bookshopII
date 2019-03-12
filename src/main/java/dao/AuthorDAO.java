package dao;

import model.Author;
import utils.UserInput;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class AuthorDAO {

    private DataFromFiles dataFromFiles = DataFromFiles.getInstance();
    private UserInput userInput = new UserInput();
    private FileWriter fileWriter;


    public void getDataFromUserAboutNewAuthor() {
        String name = getAuthorName();
        int age = getAuthorAgeFromUser();
        int id = getAuthorsID();
        addAuthorToList(id, name, age);
    }

    private int getAuthorAgeFromUser() {
        int numberFromUser = userInput.getNumberFromUser("Enter Authors age");
        while (numberFromUser < 0 || numberFromUser > 120) {
            System.out.println("Please enter vailid data form 1 to 120");
            numberFromUser = userInput.getNumberFromUser("Enter Authors age");
        }
        return numberFromUser;
    }

    private String getAuthorName() {
        return userInput.getStringFormUser("Enter Author name");
    }

    private int getAuthorsID() {  //TODO think about that
        List<Integer> collect = dataFromFiles.getListFromAuthorFile().stream().map(Author::getId).collect(Collectors.toList());
        int generatedID = 1;
        for (int i : collect) {
            if (i == collect.get(collect.size() - 1)) {
                generatedID += i;
            }
        }
        return generatedID;
    }

    private void addAuthorToList(int id, String name, int age) {
        Author author = new Author(id, name, age);
        dataFromFiles.getListFromAuthorFile().add(author);
        System.out.println("Author succesfull added to database");
    }

    public void saveAuthorListToFile(List<Author> listOFAuthors) {
        try {
            fileWriter = new FileWriter("newAuthors.csv");
            for (Author listOFAuthor : listOFAuthors) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(listOFAuthor.getId() + ";" + listOFAuthor.getFullName() + ";" + listOFAuthor.getAge());
                fileWriter.write(stringBuilder.toString());
                fileWriter.write("\n");

            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("There was some problem");
        }

        /*
        List<Integer> id = listOFAuthors.stream().map(Author::getId).collect(Collectors.toList());
        List<String> names = listOFAuthors.stream().map(Author::getFullName).collect(Collectors.toList());
        List<Integer> ages = listOFAuthors.stream().map(Author::getAge).collect(Collectors.toList());
        try {
            fileWriter = new FileWriter("newAuthors.csv");
            for (int i = 0; i < listOFAuthors.size(); i++) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(id.get(i) + ";" + names.get(i) + ";" + ages.get(i));
                fileWriter.write(stringBuilder.toString());
                fileWriter.write("\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}