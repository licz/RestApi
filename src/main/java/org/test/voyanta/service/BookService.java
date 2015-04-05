package org.test.voyanta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.test.voyanta.utils.dto.BookInfoDTO;
import org.test.voyanta.database.entities.Book;
import org.test.voyanta.database.repositories.BookRepository;
import org.test.voyanta.utils.dto.PageDTO;

import java.util.Random;

/**
 * Created by lich on 2015-04-03.
 */
@Service
public class BookService {

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    private BookRepository bookRepository;

    public BookInfoDTO addBook(Book book) {
        book.setNumberOfPages(new Random().nextInt(400)+100);
        book = bookRepository.save(book);
        BookInfoDTO booksInfoDTO = new BookInfoDTO();
        booksInfoDTO.setBookId(book.getId());
        booksInfoDTO.setNumberOfBooksWithThisAuthor(bookRepository.countByAuthor(book.getAuthor()));
        return booksInfoDTO;
    }

    public Book getBook(Integer id) {
        return bookRepository.findOne(id);
    }

    @Cacheable("pages")
    public PageDTO getBookPages(Integer id) {
        long start = System.currentTimeMillis();
        PageDTO pageDTO = new PageDTO();
        pageDTO.setNumber(bookRepository.findOne(id).getNumberOfPages());
        pageDTO.setMiliseconds(System.currentTimeMillis() - start);
        return pageDTO;
    }
}
