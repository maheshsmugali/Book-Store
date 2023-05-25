package com.pws.bookstore.repository;

import com.pws.bookstore.entity.User;
import com.pws.bookstore.entity.UserBooksXref;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserBookXrefRepository extends JpaRepository<UserBooksXref, UUID> {


    @Query("select o.user from UserBooksXref o where o.book.bookName=:bookName")
    List<User> findAllUser(String bookName);
}