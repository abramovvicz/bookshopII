package functions;

import enums.Binding;
import model.Book;

import java.util.*;
import java.util.stream.Collectors;

public class BookFunctions {


    //ex1a
    public Optional<Book> searchBookByIsbnStream(int isbn, List<Book> bookList) {
        Optional<Book> optional = bookList.stream().filter(x -> x.getIsbn() == isbn).findAny();
        Book book = optional.orElse(new Book(1, "default", 11111, 2000, Binding.M,
                null, null));
        return Optional.of(book);
        //TODO nie wiem czy dobrze użyłem i nie moge zrobić testu...
    }

    //ex1b
    public Book searchBookByIsbnFor(int isbn, List<Book> bookList) {
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
        if (bookList.isEmpty()) {
            return bookList;
        }
        return bookList.stream().skip(bookList.size() - 2).collect(Collectors.toList());
    }

    //ex3

    public Book searchFirstRelease(List<Book> bookList) {
        if (bookList.isEmpty()) {
            return null;
        }
        Collections.sort(bookList, Comparator.comparingInt(Book::getYear));
        return bookList.get(0);
    }

    public Book searchFirstReleaseStream(List<Book> bookList) {
        if (bookList.isEmpty()) {
            return null;
        }
        return bookList.stream().min(Comparator.comparingInt(x -> x.getYear())).get();
    }

    //ex4
    public Book searchLastRelease(List<Book> bookList) {
        List<Integer> sortedReversedList = bookList.stream().map(x -> x.getYear()).sorted().collect(Collectors.toList());
        Collections.reverse(sortedReversedList);
        Book result = null;
        for (Book book : bookList) {
            if (book.getYear() == sortedReversedList.get(0)) {
                result = book;
            }
        }
        return result;
    }

    public Book searchLastReleaseStream(List<Book> bookList) {
        return bookList.stream().max(Comparator.comparingInt(x -> x.getYear())).get();
    }

    //ex5
    public int sumOfYearsFor(List<Book> bookList) {
        int result = 0;
        for (Book book : bookList) {
            result += book.getYear();
        }
        return result;
    }

    public long sumOfYearsStream(List<Book> bookList) {
        return bookList.stream().mapToInt(x -> x.getYear()).sum();

    }

    //ex6
    public List<Book> searchBooksAfterSomeYear(List<Book> bookList) {
        return bookList.stream().filter(x -> x.getYear() > 2017).collect(Collectors.toList());
    }

    public List<Book> searchBooksAfter2017YearFor(List<Book> bookList) {
        List<Book> resultList = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getYear() > 2017) {
                resultList.add(book);
            }
        }
        return resultList;
    }


    //ex7
    public boolean searchAllBooksAfterSomeYear(List<Book> bookList) {
        return bookList.stream().allMatch(x -> x.getYear() > 2000);
    }

    public boolean searchAllBooksAfterSomeYearFor(List<Book> bookList) {
        for (Book book : bookList) {
            if (book.getYear() < 2000) {
                return false;
            }
        }
        return true;
    }


    //ex 8
    public double returnAverageYear(List<Book> bookList) {

        return bookList.stream().mapToInt(x -> x.getYear()).average().getAsDouble();
    }

    public double returnAverageYearFor(List<Book> bookList) {
        double sum = 0.0;
        for (Book book : bookList) {
            sum += book.getYear();

        }
        return sum / bookList.size();
    }


    //ex9 for

    public boolean returnBookBeforeSomeYear(List<Book> bookList) {
        return bookList.stream().anyMatch(x -> x.getYear() < 2003);
    }


    public List<Book> returnBookAfter2003(List<Book> bookList) {
        List<Book> listBooksBefore2003 = bookList.stream().filter(x -> x.getYear() > 2003).collect(Collectors.toList());
        System.out.println(listBooksBefore2003);
        return listBooksBefore2003;
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
        List<Book> bookWithSomeParameters = new ArrayList<>();
        for (Book book : bookList) {

            if (book.getTitle().startsWith("C") && book.getYear() > 2007) {
                bookWithSomeParameters.add(book);
            }
        }
        return bookWithSomeParameters;
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


    public List<Book> addOneHundredYearStream(List<Book> bookList) {
        return bookList.stream().peek(book -> new Book(book.getId(), book.getTitle(), book.getIsbn(),
                book.getYear(), book.getBinding(), book.getAuthor(), book.getCategory()))
                .peek(book -> book.setYear(book.getYear() + 100)).collect(Collectors.toList());
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
        List<Book> sortListOfBooksByYearASC = bookList.stream().sorted(Comparator.comparing(Book::getYear)).collect(Collectors.toList());
        System.out.println(sortListOfBooksByYearASC);
        return sortListOfBooksByYearASC;
    }

    public List<Book> sortBooksByYearASCFor(List<Book> bookList) {
        Collections.sort(bookList, (o1, o2) -> Integer.compare(o1.getYear(), o2.getYear()));
        return bookList;
    }

    //ex15
    public List<Book> sortBooksByYearDESC(List<Book> bookList) {
        List<Book> sortListOfBooksByYearDESC = bookList.stream().sorted(Comparator.comparing(Book::getYear).reversed()).collect(Collectors.toList());
        System.out.println(sortListOfBooksByYearDESC);
        return sortListOfBooksByYearDESC;
    }

    public List<Book> sortBooksByYearDESCFor(List<Book> bookList) {
        Collections.sort(bookList, (o1, o2) -> Integer.compare(o2.getYear(), o1.getYear()));
        return bookList;
    }

    //ex16 Podziel listę książek na 3 list po 2 książki i zwróć z metody.
    public List<List<Book>> listOfLists(List<Book> bookList, int number) {
        List<List<Book>> resultList = new ArrayList<>();
        final int N = bookList.size();
        if (bookList.size() % number == 0) {
            for (int i = 0; i < N; i += 2) {
                resultList.add(new ArrayList<>(bookList.subList(i, i + number < N ? i + number : N)));
            }
        }
        return resultList;
    }
}


