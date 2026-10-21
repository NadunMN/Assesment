package com.example.test.controller;


import com.example.test.mapper.CategoryMapper;
import com.example.test.model.dto.CategoryDTO;
import com.example.test.model.dto.CommentRequestDTO;
import com.example.test.model.dto.NewsDTO;
import com.example.test.model.entity.Category;
import com.example.test.model.entity.News;
import com.example.test.repository.CategoryRepository;
import com.example.test.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategory() {
        List<CategoryDTO> categories =
                categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<NewsDTO>> getAllNewsForCat(
            @PathVariable Long id
    ) {
        List<NewsDTO> news = categoryService.getAllNewsForCat(id);
        return ResponseEntity.ok(news);
    }


    @GetMapping("/news/{id}")
    public ResponseEntity<NewsDTO> getNewsDetails(
            @PathVariable Long id
    ) {
        NewsDTO news = categoryService.getNews(id);
        return ResponseEntity.ok(news);
    }

    @PostMapping("/addcomment")
    public ResponseEntity<String> addComment(
            @RequestBody CommentRequestDTO commentRequestDto
    ){
        String message = categoryService.addComment(commentRequestDto);

        if (message == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        return ResponseEntity.status(HttpStatus.CREATED).body(message);

    }

}
