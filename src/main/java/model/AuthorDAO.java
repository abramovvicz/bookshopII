package model;

import utils.UserInput;
import utils.UtilLoadFiles;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorDAO {

    private UtilLoadFiles utilLoadFiles = UtilLoadFiles.getInstance();
    private List<Author> listOFAuthors = UtilLoadFiles.listFromAuthorFile;
    private UserInput userInput = new UserInput();
    private Author author;


    public AuthorDAO() {
        utilLoadFiles.readFiles(FileTypes.AUTHORS);
    }

    public void getDataFromUserAboutNewAuthor() {
        String name = getAuthorName();
        int age = getAuthorAge();
        int id = getAuhtorsID();
        addAuthorToList(id, name, age);
    }

    private int getAuthorAge() {
        int temp = 0;
        try {
            System.out.println("Enter Author age");  //TODO: check if user didnt enter some funny data
            int numberFromUser = userInput.getNumberFromUser();
            if (numberFromUser < 0 || numberFromUser > 100) {
                System.out.println("please enter vailid data");
                temp = numberFromUser;
                numberFromUser = userInput.getNumberFromUser();
                temp = numberFromUser;
            }
        } catch (Exception e) {
            System.out.println("some problem");
        }
        return temp;
    }

    private String getAuthorName() {
        System.out.println("Enter Author name"); //todo: exception user have to provide String data
        String name = userInput.getStringFormUser();
        return name;
    }

    private int getAuhtorsID() {
        List<Integer> collect = listOFAuthors.stream().map(Author::getId).collect(Collectors.toList());
        int generatedID = 0;
        for (int i : collect) {
            if (i == collect.get(collect.size() - 1)) {
                generatedID = +i;
            }
        }
        return generatedID;
    }

    private void addAuthorToList(int id, String name, int age) {
        author = new Author(id, name, age);
        listOFAuthors.add(author);
        System.out.println("Author succesfull added to database");
    }


}
        /*
    *
        //exercises
//        utilLoadFiles.listFromAuthorFile.stream()
//                .sorted(Comparator.comparingInt(Author::getAge))
//                .collect(Collectors.toList())
//                .forEach(System.out::println);

//                .collect(Collectors.groupingBy(x->x.getAge())).forEach();


//                .map(x->x.getAge()).sorted((x,y)->x.compareTo(y)).forEach(x->System.out.println("Sort age" + x));
//        .filter(x->x.getId()>=1).forEach(System.out::println);


//                .forEach(System.out::print);
//                    .filter(x->x.getFullName().startsWith("K")).forEach(System.out::print);
//                .map(x->x.getAge()).forEach(x->System.out.println(x + " "));
//                .filter(x->x.getFullName().startsWith("B"))
//                .map(x->x.getFullName().toUpperCase()).forEach(System.out::print);*/

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
