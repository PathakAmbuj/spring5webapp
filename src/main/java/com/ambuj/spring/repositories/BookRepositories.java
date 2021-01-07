package com.ambuj.spring.repositories;

import com.ambuj.spring.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepositories extends CrudRepository<Book, Long> {
}
