package demo;

import java.util.ArrayList;

/**
 * Created by chitboon on 10/23/15.
 */
public class BookDBAO {
    // get book details given the bookId
    // this method is dummy for now
    public BookDetails getBookDetails(String bookId) {
        // return dummy book for testing now
        return createDummyBook(bookId);
    }

    // convenient method to create a dummy book detail
    // this method is meant for testing
    private BookDetails createDummyBook(String bookId) {
        BookDetails details = new BookDetails();
        details.setBookId(bookId);
        details.setDescription("Web components for developers talks about how web components can transfor the way you develop application for the web");
        details.setFirstName("Java");
        details.setSurname("Expert");
        details.setInventory(5);
        details.setOnSale(false);
        details.setPrice(5.9f);
        details.setTitle("Web components for developers");
        details.setYear(2015);
        return details;
    }

    public ArrayList<BookDetails> getAllBooks()
    {
        ArrayList<BookDetails> bdList = new ArrayList<BookDetails>();
        bdList.add(createDummyBook("A0001"));
        bdList.add(createDummyBook("A0002"));
        bdList.add(createDummyBook("A0003"));
        bdList.add(createDummyBook("A0004"));
        bdList.add(createDummyBook("A0005"));
        return bdList;
    }
}