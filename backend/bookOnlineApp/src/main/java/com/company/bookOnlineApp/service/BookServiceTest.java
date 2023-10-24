package com.company.bookOnlineApp.service;

import com.company.bookOnlineApp.dto.enums.CategoryType;
import com.company.bookOnlineApp.dto.request.BookRequestModelSave;
import com.company.bookOnlineApp.dto.response.BookResponseModel;
import com.company.bookOnlineApp.entity.Book;
import com.company.bookOnlineApp.entity.Category;
import com.company.bookOnlineApp.model.BookStatus;
import com.company.bookOnlineApp.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceTest {

    private final BookRepository bookRepository;
    private final CategoryService categoryService;

    // here function access-modifier must be public if wanna use the @Transactional
    @Transactional
    public BookResponseModel saveBook(BookRequestModelSave bookRequestModelSave) {
        Category category = categoryService.loadCategory(bookRequestModelSave.getCategoryId());
        Book book = Book.builder()
                .title(bookRequestModelSave.getTitle())
                .authorName(bookRequestModelSave.getAuthorName())
                .bookStatus(bookRequestModelSave.getBookStatus())
                .publisher(bookRequestModelSave.getPublisher())
                .lastPageNumber(bookRequestModelSave.getLastPageNumber())
                .totalPage(bookRequestModelSave.getTotalPage())
                .category(category)
                .build();

        Book savedBook = bookRepository.save(book);

        return BookResponseModel.builder()
                .categoryName(savedBook.getCategory().getName())
                .id(savedBook.getId())
                .bookStatus(savedBook.getBookStatus())
                .publisher(savedBook.getPublisher())
                .title(savedBook.getTitle())
                .totalPage(savedBook.getTotalPage())
                .lastPageNumber(savedBook.getLastPageNumber())
                .build();

    }

    public List<BookResponseModel> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(book -> mapBook(book)).collect(Collectors.toList());
    }

    public List<BookResponseModel> getBookListByCategory(CategoryType categoryType) {
        Category category = categoryService.getCategoryByName(categoryType.getValue());
        return category.getBookList()
                .stream()
                .map(book -> mapBook(book)).collect(Collectors.toList());
    }

    public List<BookResponseModel> getBookListByStatus(BookStatus bookStatus) {
        return bookRepository.findByBookStatus(bookStatus)
                .stream()
                .map(book ->
                        BookResponseModel.builder()
                                .id(book.getId())
                                .imageUrl(book.getImage().getImageUrl())
                                .build()).collect(Collectors.toList());
    }

    public List<BookResponseModel> getBookListByTitle(String title) {
        return bookRepository.findByTitle(title)
                .stream()
                .map(book ->
                        BookResponseModel.builder()
                                .id(book.getId())
                                .imageUrl(book.getImage().getImageUrl())
                                .build()).collect(Collectors.toList());
    }

    public BookResponseModel mapBook(Book book) {
        return BookResponseModel.builder()
                .title(book.getTitle())
                .bookStatus(book.getBookStatus())
                .categoryName(book.getCategory().getName())
                .authorName(book.getAuthorName())
                .lastPageNumber(book.getLastPageNumber())
                .totalPage(book.getTotalPage())
                .imageUrl(book.getImage().getImageUrl())
                .build();
    }

}
