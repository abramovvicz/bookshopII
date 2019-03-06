package model;

import java.util.*;
import java.util.stream.Collectors;

public class BookFunctions {

    //ex1a
    public Book searchBookByIsbn(int isbn, List<Book> bookList) {
        return bookList.stream().filter(x -> x.getIsbn() == isbn).findAny().orElse(null);

    }

    //ex1b
    public Book searchBookByIsbn1(int isbn, List<Book> bookList) {
        Book result = null;
        for (Book book : bookList) {
            if (book.getIsbn() == isbn) {
                result = book;
            }
        }
        return result;
    }

    //ex2
    public List<Book> searchLastTwoBooks(List<Book> bookList) {
        int size = bookList.size();
        if (bookList.isEmpty()) {
            return bookList;
        } else {
            return bookList.subList(size - 2, size);
        }


    }


    public List<Book> searchLastTwoBooksStream(List<Book> bookList) {

        return bookList.stream().skip(8).collect(Collectors.toList());

       /* List<Book> tempList = new ArrayList<>();
        int size = bookList.size();
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.indexOf(bookList.get(i)) == size && bookList.indexOf(bookList.get(i)) == size - 2) {
                tempList.add(bookList.get(i));
            }
        }
        return tempList;*/
    }

    //ex3

    public Book searchFirstRelease(List<Book> bookList) {
        int id = bookList.stream().map(x -> x.getYear()).sorted().findFirst().get();
        Book result = null;
        for (Book book : bookList) {
            if (book.getYear() == id) {
                result = book;
            }
        }
        return result;
    }

    public Book searchFirstReleaseStream(List<Book> bookList) {
        return bookList.stream().min(Comparator.comparingInt(x -> x.getYear())).get();
    }

    //ex4
    public Book searchLastRelease(List<Book> bookList) {
        List<Integer> temp = bookList.stream().map(x -> x.getYear()).sorted().collect(Collectors.toList());
        Collections.reverse(temp);
        Book result = null;
        for (Book book : bookList) {
            if (book.getYear() == temp.get(0)) {
                result = book;
            }
        }
        return result;
    }

    public Book searchLastReleaseStream(List<Book> bookList) {
        return bookList.stream().max(Comparator.comparingInt(x -> x.getYear())).get();
    }

    //ex5
    public int sumOfYears(List<Book> bookList) {
        int min = bookList.stream().map(x -> x.getYear()).sorted().findFirst().get();
        int max = bookList.stream().map(x -> x.getYear()).sorted(Collections.reverseOrder()).findFirst().get();
        int result = max - min;
        System.out.println(result);
        return result;
    }

    public long sumOfYearsStream(List<Book> bookList) {
        return bookList.stream().mapToInt(x -> x.getYear()).sum();

    }

    //ex6
    public List<Book> searchBooksAfterSomeYear(List<Book> bookList) {
        return bookList.stream().filter(x -> x.getYear() > 2017).collect(Collectors.toList());
    }

    public List<Book> searchBooksAfterSomeYearFor(List<Book> bookList) {
        List<Book> resutlList = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getYear() > 2017) {
                resutlList.add(book);
            }
        }

        return resutlList;
    }


    //ex7
    public boolean searchAllBooksAfterSomeYear(List<Book> bookList) {
        return bookList.stream().allMatch(x -> x.getYear() > 2000);
    }

    public boolean searchAllBooksAfterSomeYearFor(List<Book> bookList) {
        List<Book> resutlList = new ArrayList<>();

        for (Book book : bookList) {
            if (book.getYear() > 2000) {
                resutlList.add(book);
                if (resutlList.size() == bookList.size()) {
                    return true;
                }
            }
        }
        return false;
    }


    //ex 8 //todo: for
    public double returnAvargeYear(List<Book> bookList) {

        return bookList.stream().mapToInt(x -> x.getYear()).average().getAsDouble();
    }

    public double returnAvargeYearFor(List<Book> bookList) {
        double sum = 0.0;
        for (Book book : bookList) {
            sum = sum + book.getYear();

        }
        return sum / bookList.size();
    }


    //ex9 for

    public boolean returnBookBeforeSomeYear(List<Book> bookList) {
        return bookList.stream().anyMatch(x -> x.getYear() < 2003);

    }


    public boolean returnBookBeforeSomeYearFor(List<Book> bookList) {
        for (Book book : bookList) {
            if (book.getYear() > 2003) {
                return true;
            }
        }
        return false;
    }


    //ex10 for
    public List<Book> returnBooksWithSomeParameters(List<Book> bookList) {
        return bookList.stream().filter(x -> x.getTitle().startsWith("C") && x.getYear() > 2007).collect(Collectors.toList());
    }


    public List<Book> returnBooksWithSomeParametersFor(List<Book> bookList) {
        List<Book> tempList = new ArrayList<>();
        for (Book book : bookList) {

            if (book.getTitle().startsWith("C") && book.getYear() > 2007) {
                tempList.add(book);
            }
        }
        return tempList;
    }


    //ex11
    public List<Book> addOneHundredYear(List<Book> bookList) {
        List<Book> newListBook = new ArrayList<>();
        for (Book book : bookList) {
            book.setYear(book.getYear() + 100);
            newListBook.add(book);
        }
        return newListBook;
    }


    public List<Book> addOneHundredYearFor(List<Book> bookList) {
        List<Book> newListBook = new ArrayList<>();
        //TODO:
//        bookList.stream().map(x->newListBook.add(x.setYear(x.getYear()+100))) ????????
        return newListBook;
    }


    //ex12 Zwróć tytuły wszystkich książek, których rok jest podzielny przez 2.

    public List<String> returnTitlesBookDiverseByTwo(List<Book> bookList) {
        List<String> list = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getYear() % 2 == 0) {
                list.add(book.getTitle());
            }
        }
        return list;
    }

    public List<String> returnTitlesBookDiverseByTwoStream(List<Book> bookList) {
        return bookList.stream().filter(x -> x.getYear() % 2 == 0).map(x -> x.getTitle()).collect(Collectors.toList());
    }


    //ex13 Zwróć mapę, która będzie miała klucz isbn i wartość obiekt Book (Map<String, Book>).
    public Map<Integer, Book> returnMap(List<Book> bookList) {
        Map<Integer, Book> map = new HashMap<>();

        for (Book book : bookList) {
            map.put(book.getIsbn(), book);
        }
        return map;
    }

    public Map<Integer, Book> returnMapStream(List<Book> bookList) {
        return bookList.stream().collect(Collectors.toMap(x -> x.getIsbn(), x -> x));
    }

    //ex14 Posortuj książki po roku wydania zaczynając od wydanej najpóźniej.

    public List<Book> sortBooksByYearASC(List<Book> bookList) {
        return bookList.stream().sorted(Comparator.comparing(Book::getYear)).collect(Collectors.toList());
    }

    public List<Book> sortBooksByYearASCFor(List<Book> bookList) {
        Collections.sort(bookList, (o1, o2) -> Integer.compare(o1.getYear(), o2.getYear()));
        return bookList;
    }

    //ex15 Podziel listę książek na 3 listy po 2 książki i zwróć z metody.
    public List<Book> sortBooksByYearDESC(List<Book> bookList) {
        return bookList.stream().sorted(Comparator.comparing(Book::getYear).reversed()).collect(Collectors.toList());
    }

    public List<Book> sortBooksByYearDESCFor(List<Book> bookList) {
        Collections.sort(bookList, (o1, o2) -> Integer.compare(o2.getYear(), o1.getYear()));
        return bookList;
    }

    //ex16 Podziel listę książek na 3 listy po 2 książki i zwróć z metody.

    public List<List<Book>> listOfLists(List<Book> bookList) {
//        bookList.stream().map(x-> new ArrayList<Book>(2).add()).collect(Collectors.toList());
        List<List<Book>> resultList = new ArrayList<>();
        return resultList;
    }

}


