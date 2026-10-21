package com.example.test.service;

import com.example.test.model.dto.CategoryDTO;
import com.example.test.model.dto.CommentRequestDTO;
import com.example.test.model.dto.NewsDTO;

import java.util.List;
//import com.example.test.model.entity.Category;

public interface CategoryService {
        List<CategoryDTO> getAllCategories();
        List<NewsDTO> getAllNewsForCat(Long id);
        NewsDTO getNews(Long id);
        String addComment(CommentRequestDTO commentRequestDto);
}
