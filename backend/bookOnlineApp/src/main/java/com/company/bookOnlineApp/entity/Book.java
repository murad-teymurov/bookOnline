package com.company.bookOnlineApp.entity;

import com.company.bookOnlineApp.model.BookStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String authorName;
    private String publisher;
    private Integer lastPageNumber;
    private Integer totalPage;

    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;

    @OneToOne
    private Image image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    private User user;

}
