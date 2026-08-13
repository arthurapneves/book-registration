package com.bookregistration.book.registration.repository;

import com.bookregistration.book.registration.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookListRepository extends JpaRepository<Books, Long> {
}
