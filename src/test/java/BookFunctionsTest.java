import enums.Binding;
import functions.BookFunctions;
import model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.Assert.*;

public class BookFunctionsTest {

    BookFunctions bookFunctions;
    List<Book> listBooks = new ArrayList<>();

    @BeforeEach
    void setUp() {
        Book book1 = new Book(1, "CTytyuł 1", 12345, 2019, Binding.M, null, null);
        Book book2 = new Book(2, "Tytyuł 2", 56789, 1982, Binding.M, null, null);
        Book book3 = new Book(3, "Tytyuł 3", 33345, 1990, Binding.M, null, null);
        Book book4 = new Book(4, "Tytyuł 4", 42562, 1992, Binding.T, null, null);
        Book book5 = new Book(5, "CTytyuł 5", 35151, 2118, Binding.M, null, null);
        Book book6 = new Book(6, "Tytyuł 6", 516711, 2003, Binding.T, null, null);

        listBooks.add(book1);
        listBooks.add(book2);
        listBooks.add(book3);
        listBooks.add(book4);
        listBooks.add(book5);
        listBooks.add(book6);

        bookFunctions = new BookFunctions();
    }

    @Test
    void searchBookByIsbnStream() {
        Optional book = Optional.of(new Book(1, "default", 11111, 2000, Binding.M, null, null));
        assertEquals(listBooks.get(0), bookFunctions.searchBookByIsbnStream(12345, listBooks));
        assertEquals(book, bookFunctions.searchBookByIsbnStream(12323445, listBooks));
        assertEquals(book, bookFunctions.searchBookByIsbnStream(345, listBooks));
    }

    @Test
    void searchBookByIsbnFor() {
        assertEquals(listBooks.get(0), bookFunctions.searchBookByIsbnFor(12345, listBooks));
        assertNull(bookFunctions.searchBookByIsbnFor(1245, listBooks));
        assertNull(bookFunctions.searchBookByIsbnFor(12243345, listBooks));
    }

    @Test
    void searchLastTwoBooks() {
        List<Book> tempBook = Arrays.asList(listBooks.get(4), listBooks.get(5));
        List<Book> nullList = Collections.emptyList();
        assertEquals(tempBook, bookFunctions.searchLastTwoBooks(listBooks));
        assertEquals(tempBook, bookFunctions.searchLastTwoBooks(listBooks));
        assertEquals(nullList, bookFunctions.searchLastTwoBooksStream(nullList));

    }

    @Test
    void searchLastTwoBooksStream() {
        List<Book> tempBook = Arrays.asList(listBooks.get(4), listBooks.get(5));
        assertEquals(tempBook, bookFunctions.searchLastTwoBooksStream(listBooks));
        assertEquals(tempBook, bookFunctions.searchLastTwoBooksStream(listBooks));
    }

    @Test
    void searchFirstRelease() {
        assertEquals(listBooks.get(1), bookFunctions.searchFirstRelease(listBooks));
    }

    @Test
    void searchFirstReleaseStream() {
        assertEquals(listBooks.get(1), bookFunctions.searchFirstReleaseStream(listBooks));
    }

    @Test
    void searchLastRelease() {
        assertEquals(listBooks.get(4), bookFunctions.searchLastRelease(listBooks));
        assertEquals(listBooks.get(4), bookFunctions.searchLastReleaseStream(listBooks));
    }

    @Test
    void sumOfYears() {
        assertEquals(12104, bookFunctions.sumOfYearsFor(listBooks));
        assertEquals(12104, bookFunctions.sumOfYearsStream(listBooks));
    }

    //ex6
    @Test
    void searchBooksAfterSomeYear() {
        List<Book> bookTestList = Arrays.asList(listBooks.get(0), listBooks.get(4));
        assertEquals(bookTestList, bookFunctions.searchBooksAfterSomeYear(listBooks));
    }

    @Test
    void searchBooksAfterSomeYearFor() {
        List<Book> tempBook = Arrays.asList(listBooks.get(0), listBooks.get(4));
        assertEquals(tempBook, bookFunctions.searchBooksAfter2017YearFor(listBooks));
    }

    @Test
    void searchAllBooksAfterSomeYear() {
        assertFalse(bookFunctions.searchAllBooksAfterSomeYear(listBooks));
    }

    @Test
    void searchAllBooksAfterSomeYearFor() {
        assertFalse(bookFunctions.searchAllBooksAfterSomeYearFor(listBooks));
    }

    //ex8
    @Test
    void returnAverageYear() {
        assertEquals(2011.6, bookFunctions.returnAverageYear(listBooks), 1);

    }

    @Test
    void returnAverageYearFor() {
        assertEquals(2011.6, bookFunctions.returnAverageYearFor(listBooks), 1);

    }

    //ex9
    @Test
    void returnBookBeforeSomeYear() {
        assertTrue(bookFunctions.returnBookBeforeSomeYear(listBooks));
        assertTrue(bookFunctions.returnBookBeforeSomeYearFor(listBooks));

    }

    //ex10
    @Test
    void returnBooksWithSomeParameters() {
        List<Book> tempBook = Arrays.asList(listBooks.get(0), listBooks.get(4));
        assertEquals(tempBook, bookFunctions.returnBooksWithSomeParameters(listBooks));
        assertEquals(tempBook, bookFunctions.returnBooksWithSomeParametersFor(listBooks));
    }


    @Test
    void addOneHundredYear() {
        assertEquals(listBooks.get(4), bookFunctions.addOneHundredYear(listBooks).get(4));
        assertEquals(listBooks.get(4), bookFunctions.addOneHundredYearStream(listBooks).get(4));
    }

    @Test
    void returnTitlesBookDiverseByTwo() {
        List<String> tempBookList = Arrays.asList(listBooks.get(1).getTitle(), listBooks.get(2).getTitle(), listBooks.get(3).getTitle(), listBooks.get(4).getTitle());
        assertEquals(tempBookList, bookFunctions.returnTitlesBookDiverseByTwo(listBooks));
        assertEquals(tempBookList, bookFunctions.returnTitlesBookDiverseByTwoStream(listBooks));
    }

    @Test
    void returnMap() {
        Map<Integer, Book> someMap = new HashMap<>();
        someMap.put(12345, listBooks.get(0));
        someMap.put(56789, listBooks.get(1));
        someMap.put(33345, listBooks.get(2));
        someMap.put(42562, listBooks.get(3));
        someMap.put(35151, listBooks.get(4));
        someMap.put(516711, listBooks.get(5));

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

        temp1.add(listBooks.get(0));
        temp1.add(listBooks.get(1));
        temp2.add(listBooks.get(2));
        temp2.add(listBooks.get(3));
        temp3.add(listBooks.get(4));
        temp3.add(listBooks.get(5));
        listOfLists.add(temp1);
        listOfLists.add(temp2);
        listOfLists.add(temp3);

        assertEquals(listOfLists, bookFunctions.listOfLists(listBooks, 2));
    }
}
