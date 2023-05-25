package com.pws.bookstore.repository;



import com.pws.bookstore.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface OrdersRepository extends JpaRepository<Orders, UUID> {

    @Query(value = "SELECT o.* FROM Orders o JOIN Users u ON o.userId = u.id WHERE o.orderDate >= :startDate AND o.orderDate < :endDate", nativeQuery = true)
    List<Orders> findOrdersByDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);


}
