package com.company.bookOnlineApp.service;

import com.company.bookOnlineApp.entity.Category;
import com.company.bookOnlineApp.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;


    public Category loadCategory(long id) {
        return categoryRepository.findById(id).orElseThrow();

    }

    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name).orElseThrow(RuntimeException::new);
    }
}
