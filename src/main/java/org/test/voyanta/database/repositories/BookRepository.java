package org.test.voyanta.database.repositories;

import org.springframework.data.repository.CrudRepository;
import org.test.voyanta.database.entities.Book;

/**
 * Created by lich on 2015-04-03.
 */
public interface BookRepository extends CrudRepository<Book, Integer> {
    int countByAuthor(String author);
}
