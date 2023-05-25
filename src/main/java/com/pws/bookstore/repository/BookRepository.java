package com.pws.bookstore.repository;



import com.pws.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {

    @Query("select o.bookName from Book o where o.bookName =:bookName")
    Optional<Book> findByName(String bookName);



}