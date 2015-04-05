package org.test.voyanta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.test.voyanta.utils.dto.BookInfoDTO;
import org.test.voyanta.database.entities.Book;
import org.test.voyanta.service.BookService;
import org.test.voyanta.utils.dto.PageDTO;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Created by lich on 2015-04-03.
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    public BookController(BookService bookServices) {
        this.bookServices = bookServices;
    }

    BookService bookServices;

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public @ResponseBody BookInfoDTO addBook(@RequestBody Book book, HttpServletResponse response) {

        //adding unique id (for example for tracing purposes)
        response.setHeader("UUID", String.valueOf(UUID.randomUUID()));

        BookInfoDTO bookInfoDTO = bookServices.addBook(book);
        bookInfoDTO.add(linkTo(methodOn(BookController.class).getBook(bookInfoDTO.getBookId())).withSelfRel());

        return bookInfoDTO;
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Book getBook(@PathVariable final Integer id) {

        return bookServices.getBook(id);
    }

    @RequestMapping(value = "/book/{id}/pages", method = RequestMethod.GET)
    public @ResponseBody PageDTO getBookPages(@PathVariable final Integer id) {


        return bookServices.getBookPages(id);
    }
}
