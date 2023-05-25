package com.pws.bookstore.controller;

import com.pws.bookstore.dto.*;
import com.pws.bookstore.entity.Book;
import com.pws.bookstore.entity.Orders;
import com.pws.bookstore.entity.User;
import com.pws.bookstore.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/book-store")
@RestController
public class CommonController {

    @Autowired
    private CommonService commonService;

    @PostMapping("/books")
    public String addBooks(@RequestBody BookDto bookDto) {
        commonService.addBooks(bookDto);
        return "Successfully Added Books";
    }

    @PostMapping("/books/categories")
    public String addCatBooks(@RequestBody BookCategoryDto bookCatDto) throws Exception {
        commonService.addCategoriesBooks(bookCatDto);
        return " Successfully Added Books With Categories";
    }

    @PostMapping("/books/categories/xref")
    public String addCatBooks(@RequestBody BookCategoryXrefDto bookCategoryXrefDto) throws Exception {
        commonService.addingBooksCatXref(bookCategoryXrefDto);
        return "Successfully Added Books Xref Categories   ";
    }


    @PostMapping("/users")
    public String addUsers(@RequestBody UserDto userDto) throws Exception {
        commonService.addUsers(userDto);
        return "User Added Successfully ";
    }

    @PostMapping("/user-books")
    public String addingUserBook(@RequestBody UserBookxrefDto userBookxrefDto) throws Exception {
        commonService.addingUserBooks(userBookxrefDto);
        return "User Xref Added Successfully ";
    }

    @GetMapping("/userinfo/get-all")
    public List<User> getAllUser(@RequestParam String bookName) {
        return commonService.getAllUsers(bookName);
    }

    @GetMapping("/books/get-all")
    public List<Book> getAllBooks(@RequestParam String category,@RequestParam int pageNumber,@RequestParam int pageSize){
        return commonService.getAllBooks(category,pageNumber,pageSize);
    }

    @PostMapping("/orders")
    public String addOrders(@RequestBody OrderDto orderDto) throws Exception {
        commonService.addOrders(orderDto);
        return "order added successfully";
    }

    @GetMapping("/details/get-all")
    public List<Orders> getAllInfo(@Param("startDate") Date startDate, @Param("endDate") Date endDate) {
        return commonService.findByDate(startDate,endDate);
    }

    @PostMapping("/cart")
    public ResponseEntity<Object> addToCart(@RequestBody CartDto cartDto) throws Exception {
        commonService.addingToCart(cartDto);
        return new ResponseEntity<>("Successfully Added To Cart ", HttpStatus.OK);
    }
}
