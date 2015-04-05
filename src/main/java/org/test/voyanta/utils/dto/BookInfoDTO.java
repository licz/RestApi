package org.test.voyanta.utils.dto;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by lich on 2015-04-03.
 */
public class BookInfoDTO extends ResourceSupport {
    private int bookId;
    private int numberOfBooksWithThisAuthor;

    public int getNumberOfBooksWithThisAuthor() {
        return numberOfBooksWithThisAuthor;
    }

    public void setNumberOfBooksWithThisAuthor(int numberOfBooksWithThisAuthor) {
        this.numberOfBooksWithThisAuthor = numberOfBooksWithThisAuthor;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
