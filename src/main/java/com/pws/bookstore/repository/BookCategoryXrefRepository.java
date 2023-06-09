package com.pws.bookstore.repository;

import com.pws.bookstore.entity.Book;

import com.pws.bookstore.entity.BookCategoryXref;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface BookCategoryXrefRepository extends JpaRepository<BookCategoryXref, UUID> {
    @Query("select o.book from  BookCategoryXref o where o.categories.catName=:category")
    List<Book> findAllBookers(Pageable pageable, String category);
}