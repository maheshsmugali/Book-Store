package com.pws.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {

    private UUID userId;

    private UUID bookId;

    private Date date;
}