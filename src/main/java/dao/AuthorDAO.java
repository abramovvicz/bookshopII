package dao;

import enums.FileTypes;
import model.Author;
import utils.ApplicationStatus;
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
    private ApplicationStatus applicationStatus = ApplicationStatus.getInstance();


    public void editAuthorAgeByUser(List<Author> authorList) {
        if (authorList.isEmpty()) {
            System.out.println("Sorry authors list is empty");
        }
        System.out.println("Enter author id to change Age");
        int newAuthorsAge;
        boolean flag = true;
        while (flag) {
            newAuthorsAge = getAuthorIdFromUser();
            for (Author author : authorList) {
                if (author.getId() == newAuthorsAge) {
                    author.setAge(getAuthorAgeFromUser());
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("Did`int find any authors. Please renter authors ID");
            }
        }
    }

    public void editAuthorAgeByUserStream(List<Author> authorList) {
        if (authorList.isEmpty()) {
            System.out.println("Sorry authors list is empty");
        }
        System.out.println("Enter author id to change Age");
        while (true) {
            int newAuthorsAge = userInput.getNumberFromUser();
            Optional<Author> findAuthorToChangeAge = authorList.stream()
                    .filter(x -> x.getId() == newAuthorsAge).findFirst();
            if (findAuthorToChangeAge.isPresent()) {
                findAuthorToChangeAge.get().setAge(getAuthorAgeFromUser());
                applicationStatus.setStatus(true);
                System.out.println("Successfully change authors age");
                break;
            } else {
                System.out.println("Didi`nt find anything, please renter id to change Authors age");
            }
        }
    }

    public void getDataFromUserAboutNewAuthor() {
        String name = getAuthorName();
        int age = getAuthorAgeFromUser();
        int id = getAuthorsID();
        addAuthorToList(id, name, age);
        applicationStatus.setStatus(true);
        System.out.println("Successfully added a new author");

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
        int authorsID = 1;
        if (dataFromFiles.getListFromAuthorFile().isEmpty()) {
            return 1;
        }
        Optional<Author> authorWithMaxId = dataFromFiles.getListFromAuthorFile().stream()
                .max(Comparator.comparingInt(x -> x.getId()));
        if (authorWithMaxId.isPresent()) {
            authorsID = authorWithMaxId.get().getId() + 1;
        } else {
            System.out.println("Didn`t find authors id");
        }
        return authorsID;
    }


    private int getAuthorIdFromUser() {
        return userInput.getNumberFromUser();
    }

    public void deleteAuthorsByID(List<Author> authorList) {
        if (authorList.isEmpty()) {
            System.out.println("Sorry author list is empty");
        }
        System.out.println("Enter author ID to delete");
        List<Author> copyAuthorsList = new ArrayList<>(authorList);
        boolean flag = true;
        while (flag) {
            int idEnteredByUser = getAuthorIdFromUser();
            for (Author author : copyAuthorsList) {
                if (author.getId() == idEnteredByUser) {
                    authorList.remove(author);
                    applicationStatus.setStatus(true);
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("Did`nt find author with entered ID");
                System.out.println("Please enter another ID");
            }
        }
    }

    private void addAuthorToList(int id, String name, int age) {
        Author author = new Author(id, name, age);
        dataFromFiles.getListFromAuthorFile().add(author);
        applicationStatus.setStatus(true);
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
            System.out.println("Author file has successfully saved");
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