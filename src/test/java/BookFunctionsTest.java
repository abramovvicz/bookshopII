import model.Book;
import model.BookFunctions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class BookFunctionsTest {

    BookFunctions bookFunctions;
    List<Book> listBooks = new ArrayList<>();
    Book book1;
    Book book2;
    Book book3;
    Book book4;
    Book book5;
    Book book6;
    Book book7;
    Book book8;
    Book book9;
    Book book10;

    @BeforeEach
    void setUp() {
        book1 = new Book(1, "CTytyuł 1", 12345, 2019, "T", null, null);
        book2 = new Book(2, "Tytyuł 2", 56789, 1982, "M", null, null);
        book3 = new Book(3, "Tytyuł 3", 33345, 1990, "M", null, null);
        book4 = new Book(4, "Tytyuł 4", 42562, 1992, "T", null, null);
        book5 = new Book(5, "CTytyuł 5", 35151, 2118, "M", null, null);
        book6 = new Book(6, "Tytyuł 6", 516711, 2003, "T", null, null);
        book7 = new Book(7, "Tytyuł 7", 516712, 2003, "T", null, null);
        book8 = new Book(8, "Tytyuł 8", 516713, 2003, "M", null, null);
        book9 = new Book(9, "Tytyuł 9", 516714, 2003, "T", null, null);
        book9 = new Book(10, "Tytyuł 9", 516714, 2003, "T", null, null);
        listBooks.add(book1);
        listBooks.add(book2);
        listBooks.add(book3);
        listBooks.add(book4);
        listBooks.add(book5);
        listBooks.add(book6);
        listBooks.add(book7);
        listBooks.add(book8);
        listBooks.add(book9);
        bookFunctions = new BookFunctions();
    }

    @Test
    void searchBookByIsbn() {
        assertEquals(book1, bookFunctions.searchBookByIsbn(12345, listBooks));
        assertEquals(null, bookFunctions.searchBookByIsbn(12323445, listBooks));
        assertEquals(null, bookFunctions.searchBookByIsbn(345, listBooks));
    }

    @Test
    void searchBookByIsbn1() {
        assertEquals(book1, bookFunctions.searchBookByIsbn1(12345, listBooks));
        assertEquals(null, bookFunctions.searchBookByIsbn1(1245, listBooks));
        assertEquals(null, bookFunctions.searchBookByIsbn1(12243345, listBooks));
    }

    @Test
    void searchLastTwoBooks() {
//        int id5 = listBooks.stream().map(x -> x.getId()).findFirst().get();
        List<Book> tempBook = Arrays.asList(book8, book9);
        assertEquals(tempBook, bookFunctions.searchLastTwoBooks(listBooks));
        assertEquals(tempBook, bookFunctions.searchLastTwoBooks(listBooks));
    }

    @Test
    void searchLastTwoBooksFor() {
//        int id5 = listBooks.stream().map(x -> x.getId()).findFirst().get();
        List<Book> tempBook = Arrays.asList(book8, book9);
        List<Book> nullList = Arrays.asList();
        assertEquals(tempBook, bookFunctions.searchLastTwoBooks(listBooks));
        assertEquals(tempBook, bookFunctions.searchLastTwoBooks(listBooks));
        assertEquals(nullList, bookFunctions.searchLastTwoBooks(nullList));
    }

    @Test
    void searchFirstRelease() {
        assertEquals(book2, bookFunctions.searchFirstRelease(listBooks));
        assertEquals(book2, bookFunctions.searchFirstReleaseStream(listBooks));
    }

    @Test
    void searchLastRelease() {
//        assertEquals(book1, bookFunctions.searchLastRelease(listBooks));
        assertEquals(book1, bookFunctions.searchLastReleaseStream(listBooks));
    }

    @Test
    void sumOfYears() {
//        assertEquals(book1.getYear() - book2.getYear(), bookFunctions.sumOfYears(listBooks));
        assertEquals(18010, bookFunctions.sumOfYearsStream(listBooks));
    }
//ex6
    @Test
    void searchBooksAfterSomeYear() {
        List<Book> tempBook = Arrays.asList(book1, book5);
        assertEquals(tempBook, bookFunctions.searchBooksAfterSomeYear(listBooks));
    }

    @Test
    void searchBooksAfterSomeYearFor(){
        List<Book> tempBook = Arrays.asList(book1, book5);
        assertEquals(tempBook, bookFunctions.searchBooksAfterSomeYearFor(listBooks));
    }

    @Test
    void searchAllBooksAfterSomeYear() {
        assertEquals(false, bookFunctions.searchAllBooksAfterSomeYear(listBooks));
    }

    @Test
    void searchAllBooksAfterSomeYearFor() {
        assertEquals(false, bookFunctions.searchAllBooksAfterSomeYearFor(listBooks));
    }

    @Test
    void returnAvargeYear() {
        assertEquals(2012.5555, bookFunctions.returnAvargeYear(listBooks), 01);
    }

    @Test
    void returnAvargeYearFor(){
        assertEquals(2012.5555, bookFunctions.returnAvargeYearFor(listBooks), 01);

    }

    @Test
    void returnBookBeforeSomeYear() {
        assertEquals(true, bookFunctions.returnBookBeforeSomeYear(listBooks));
    }

    @Test
    void returnBooksWithSomeParameters() {
        List<Book> tempBook = Arrays.asList(book1, book5);

        assertEquals(tempBook, bookFunctions.returnBooksWithSomeParameters(listBooks));
    }

    @Test
    void addOneHundredYear() {
        List<Book> tempBookList = Arrays.asList(book5);
        assertEquals(listBooks.get(4), bookFunctions.addOneHundredYear(listBooks).get(4));
    }

    @Test
    void returnTitlesBookDiverseByTwo() {
        List<String> tempBookList = Arrays.asList(book2.getTitle(), book3.getTitle(), book4.getTitle(), book5.getTitle());
        assertEquals(tempBookList, bookFunctions.returnTitlesBookDiverseByTwo(listBooks));
        assertEquals(tempBookList, bookFunctions.returnTitlesBookDiverseByTwoStream(listBooks));
    }

    @Test
    void returnMap() {
        Map<Integer, Book> someMap = new HashMap<>();
        someMap.put(12345, book1);
        someMap.put(56789, book2);
        someMap.put(33345, book3);
        someMap.put(42562, book4);
        someMap.put(35151, book5);
        someMap.put(516711, book6);
        someMap.put(516712, book7);
        someMap.put(516713, book8);
        someMap.put(516714, book9);

        assertEquals(someMap, bookFunctions.returnMap(listBooks));
        assertEquals(someMap, bookFunctions.returnMapStream(listBooks));
    }

    @Test
    void sortBooksByYearASC() {
        List<Book> bookList = bookFunctions.sortBooksByYearASC(listBooks.subList(0, 3));

        assertEquals(2, bookList.get(0).getId());
        assertEquals(3, bookList.get(1).getId());
        assertEquals(1, bookList.get(2).getId());


    }

    @Test
    void sortBooksByYearASCFor() {
        List<Book> bookList2 = bookFunctions.sortBooksByYearASCFor(listBooks.subList(0, 3));
        assertEquals(2, bookList2.get(0).getId());
        assertEquals(3, bookList2.get(1).getId());
        assertEquals(1, bookList2.get(2).getId());
    }

    @Test
    void sortBooksByYearDESCFor() {
        List<Book> bookList2 = bookFunctions.sortBooksByYearDESCFor(listBooks.subList(0, 3));
        assertEquals(1, bookList2.get(0).getId());
        assertEquals(3, bookList2.get(1).getId());
        assertEquals(2, bookList2.get(2).getId());
    }

    @Test
    void sortBooksByYearDESC() {
        List<Book> bookList2 = bookFunctions.sortBooksByYearDESC(listBooks.subList(0, 3));
        assertEquals(1, bookList2.get(0).getId());
        assertEquals(3, bookList2.get(1).getId());
        assertEquals(2, bookList2.get(2).getId());
    }

    @Test
    void listOfLists() {
        List<List<Book>> listOfLists = new ArrayList<>();
        List<Book> temp1 = new ArrayList<>();
        List<Book> temp2 = new ArrayList<>();
        List<Book> temp3 = new ArrayList<>();
        List<Book> temp4 = new ArrayList<>();
        List<Book> temp5 = new ArrayList<>();
        temp1.add(book1);
        temp1.add(book2);
        temp2.add(book3);
        temp2.add(book4);
        temp3.add(book5);
        temp3.add(book6);
        temp4.add(book7);
        temp4.add(book8);
        temp5.add(book9);
        temp5.add(book10);
        listOfLists.add(temp1);
        listOfLists.add(temp2);
        listOfLists.add(temp1);
        assertEquals(listOfLists, bookFunctions.listOfLists(listBooks));


    }
}
