package dao;

import enums.FileTypes;
import model.Author;
import utils.Status;
import utils.UserInput;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class AuthorDAO {

    private DataFromFiles dataFromFiles = DataFromFiles.getInstance();
    private UserInput userInput = new UserInput();
    private Status status = Status.getInstance();


    public void editAuthorAgeByUser(List<Author> authorList) {
        int newAuthorsAge;
        System.out.println("Enter author id to change Age");
        while (true) {
            newAuthorsAge = getAuthorIdFromUser();
            int finalNewAuthorsAge = newAuthorsAge;
            Optional<Author> findAuthorToChangeAge = authorList.stream()
                    .filter(x -> x.getId() == finalNewAuthorsAge).findFirst();
            if (findAuthorToChangeAge.isPresent()) {
                findAuthorToChangeAge.get().setAge(getAuthorAgeFromUser());
                status.setStatus(true);
                break;
            }
        }
    }

    public void getDataFromUserAboutNewAuthor() {
        String name = getAuthorName();
        int age = getAuthorAgeFromUser();
        int id = getAuthorsID();
        addAuthorToList(id, name, age);
        status.setStatus(true);

        System.out.println("Successfully added new author");

    }

    private int getAuthorAgeFromUser() {
        System.out.println("Enter Authors age");
        int numberFromUser = userInput.getNumberFromUser();
        while (numberFromUser < 0 || numberFromUser > 120) {
            System.out.println("Please enter valid data form 1 to 120");
            System.out.println("Enter Authors age");

            numberFromUser = userInput.getNumberFromUser();
        }
        return numberFromUser;
    }

    private String getAuthorName() {
        System.out.println("Enter Author name");
        return userInput.getStringFormUser();
    }

    private int getAuthorsID() {
        if (dataFromFiles.getListFromAuthorFile().isEmpty()) {
            return 1;
        }
        Author authorWithMaxId = dataFromFiles.getListFromAuthorFile().stream()
                .max(Comparator.comparingInt(x -> x.getId())).get();
        return authorWithMaxId.getId() + 1;
    }


    private int getAuthorIdFromUser() {
        return userInput.getNumberFromUser();
    }

    public void deleteAuthorsByID(List<Author> authorList) {
        System.out.println("Enter author ID to delete");
        List<Author> copyAuthorsList = new ArrayList<>(authorList);
        boolean flag = true;
        while (flag) {
            int idEnteredByUser = getAuthorIdFromUser();
            for (Author author : copyAuthorsList) {
                if (author.getId() == idEnteredByUser) {
                    authorList.remove(author);
                    status.setStatus(true);

                    flag = false;
                }
            }
            System.out.println("Did`nt find author with entered ID");
            System.out.println("Please enter another ID");
        }
    }

    private void addAuthorToList(int id, String name, int age) {
        Author author = new Author(id, name, age);
        dataFromFiles.getListFromAuthorFile().add(author);
        status.setStatus(true);
        System.out.println("Author successfully added to database");
    }

    public void saveAuthorListToFile(List<Author> listOFAuthors) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(FileTypes.NEW_AUTHORS.getFileAddress());
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
    }
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