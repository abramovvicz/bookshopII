package dao;

import model.Author;
import utils.UserInput;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class AuthorDAO {

    private DataFromFiles dataFromFiles = DataFromFiles.getInstance();
    private UserInput userInput = new UserInput();


    public void getDataFromUserAboutNewAuthor() {
        String name = getAuthorName();
        int age = getAuthorAgeFromUser();
        int id = getAuthorsID();
        addAuthorToList(id, name, age);
        System.out.println("Succesfully added new author");

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

    private int getAuthorsID() {
        Author authorWithMaxId = dataFromFiles.getListFromAuthorFile().stream().max(Comparator.comparingInt(x -> x.getId())).get();
        return authorWithMaxId.getId() + 1;
    }

    private void addAuthorToList(int id, String name, int age) {
        Author author = new Author(id, name, age);
        dataFromFiles.getListFromAuthorFile().add(author);
        System.out.println("Author succesfull added to database");
    }

    public void saveAuthorListToFile(List<Author> listOFAuthors) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("src/main/resources/newAuthors.csv");
            for (Author listOFAuthor : listOFAuthors) {
                String pattern = listOFAuthor.getId() + ";" + listOFAuthor.getFullName() + ";" + listOFAuthor.getAge();
                fileWriter.write(pattern);
                fileWriter.write("\n");

            }
            System.out.println("Successfully saved");
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