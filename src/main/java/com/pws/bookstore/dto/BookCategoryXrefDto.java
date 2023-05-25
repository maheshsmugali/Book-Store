package com.pws.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookCategoryXrefDto {

    private UUID bookId;

    private UUID categoryId;

}