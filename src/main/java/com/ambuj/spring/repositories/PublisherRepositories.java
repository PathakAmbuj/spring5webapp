package com.ambuj.spring.repositories;

import com.ambuj.spring.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepositories extends CrudRepository<Publisher, Long> {
}
