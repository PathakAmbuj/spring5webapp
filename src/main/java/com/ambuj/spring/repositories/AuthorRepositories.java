package com.ambuj.spring.repositories;

import com.ambuj.spring.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepositories extends CrudRepository<Author, Long> {
}
