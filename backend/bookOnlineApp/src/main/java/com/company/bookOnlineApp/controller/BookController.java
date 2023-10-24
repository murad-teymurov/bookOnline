package com.company.bookOnlineApp.controller;

import com.company.bookOnlineApp.dto.enums.CategoryType;
import com.company.bookOnlineApp.dto.request.BookRequestModelSave;
import com.company.bookOnlineApp.dto.response.BookResponseModel;
import com.company.bookOnlineApp.model.BookStatus;
import com.company.bookOnlineApp.service.BookServiceTest;
import com.company.bookOnlineApp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/book")
@RestController
@RequiredArgsConstructor
public class BookController {

   private CategoryService categoryService;
   private BookServiceTest bookService;


   @GetMapping
   public ResponseEntity<List<BookResponseModel>> getBooks() {
       return ResponseEntity.ok(bookService.getAllBooks());
   }



    @PostMapping("/save")
    public ResponseEntity<BookResponseModel> saveBook(@RequestBody BookRequestModelSave request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bookService.saveBook(request));
    }

    @GetMapping("{categorytype}")
    public ResponseEntity<List<BookResponseModel>> getBookByCategoryType(CategoryType categoryType) {
       return  ResponseEntity.ok(bookService.getBookListByCategory(categoryType));
    }

    @GetMapping("{status}")
    public ResponseEntity<List<BookResponseModel>> getBookByStatus(BookStatus bookStatus) {
        return  ResponseEntity.ok(bookService.getBookListByStatus(bookStatus));
    }

    @GetMapping("{title}")
    public ResponseEntity<List<BookResponseModel>> getBookByTitle(String title) {
        return  ResponseEntity.ok(bookService.getBookListByTitle(title));
    }
}
