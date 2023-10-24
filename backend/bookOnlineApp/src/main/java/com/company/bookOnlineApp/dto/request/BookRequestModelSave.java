package com.company.bookOnlineApp.dto.request;

import com.company.bookOnlineApp.model.BookStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.File;

@Data
public class BookRequestModelSave {
    @NotBlank
    private String title;
    @NotBlank
    private String authorName;
    @NotNull
    private BookStatus bookStatus;
    @NotBlank
    private String publisher;
    @NotNull
    private Integer lastPageNumber;
    @NotNull
    private Integer totalPage;
    private File image;
    @NotNull
    private long categoryId;
}
