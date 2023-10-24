package com.company.bookOnlineApp.dto.response;

import com.company.bookOnlineApp.model.BookStatus;
import lombok.Builder;
import lombok.Data;

import java.io.File;

@Data
@Builder
public class BookResponseModel {
    private long id;
    private String title;
    private String authorName;
    private BookStatus bookStatus;
    private String publisher;
    private Integer lastPageNumber;
    private Integer totalPage;
    private File image;
    private String categoryName;
    private String imageUrl;
}
