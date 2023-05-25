package com.pws.bookstore.service;

import com.pws.bookstore.dto.*;
import com.pws.bookstore.entity.Book;
import com.pws.bookstore.entity.Orders;
import com.pws.bookstore.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface CommonService {
    void addBooks(BookDto bookDto);

    void addCategoriesBooks(BookCategoryDto bookCategoryDto)throws Exception;

    void addingBooksCatXref(BookCategoryXrefDto bookCategoryXrefDto) throws Exception;

    void addUsers(UserDto userDto);

    void addingUserBooks(UserBookxrefDto userBookxrefDto) throws Exception;

    List<User> getAllUsers(String bookName);

    List<Book> getAllBooks(String category, int pageNumber,int pageSize);

    List<Orders> findByDate(Date startDate, Date endDate);

    void addOrders(OrderDto orderDto) throws Exception;

    void addingToCart(CartDto cartDto) throws Exception;
}
