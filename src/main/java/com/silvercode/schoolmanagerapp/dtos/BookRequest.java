package com.silvercode.schoolmanagerapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class BookRequest {

    private String title;
    private LocalDate createdAt;

}
