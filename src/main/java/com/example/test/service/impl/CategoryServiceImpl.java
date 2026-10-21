package com.example.test.service.impl;

import com.example.test.model.dto.CategoryDTO;
import com.example.test.model.dto.CommentRequestDTO;
import com.example.test.model.dto.NewsDTO;
import com.example.test.model.entity.Category;
import com.example.test.model.entity.Comments;
import com.example.test.model.entity.News;
import com.example.test.repository.CategoryRepository;
import com.example.test.repository.CommentRepository;
import com.example.test.repository.NewsRepository;
import com.example.test.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final NewsRepository newsRepository;
    private final CommentRepository commentsRepository;
//    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, NewsRepository newsRepository, CommentRepository commentsRepository) {
        this.categoryRepository = categoryRepository;
        this.newsRepository = newsRepository;
        this.commentsRepository = commentsRepository;
//        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {

        List<Category> categories = categoryRepository.findAll();


        return categories.stream()
                .map(categoryItem -> {
                    CategoryDTO categoryDTO = new CategoryDTO();
                    categoryDTO.setCategoryId(categoryItem.getCategoryId());
                    categoryDTO.setCategory(categoryItem.getCategory());
                    // Set other properties as needed
                    return categoryDTO;
                })
                .toList();

//        return categories.stream()
//                .map(categoryMapper::toDto)
//                .toList();
    }

    @Override
    public List<NewsDTO> getAllNewsForCat(Long id) {
        Optional<News> news = categoryRepository.findNewsByCategoryId(id);

        return news.stream()
                .map(newsItem -> {
                    NewsDTO newsDTO = new NewsDTO();
                    newsDTO.setNewsId(newsItem.getNewsId());
                    newsDTO.setHeading(newsItem.getHeading());
                    newsDTO.setDetails(newsItem.getDetail());
                    // Set other properties as needed
                    return newsDTO;
                })
                .toList();
//        return news.stream()
//                .map(categoryMapper::toNewsDto)
//                .toList();
    }

    @Override
    public NewsDTO getNews(Long id) {
        News news = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("News not found with id: " + id)).getNews();

        return new NewsDTO(news.getNewsId(), news.getHeading(), news.getDetail());

    }

    @Override
    public String addComment(CommentRequestDTO commentRequestDto) {

        Long newsId = Long.parseLong(commentRequestDto.getNewsId());
        String comment = commentRequestDto.getComment();

        News news = newsRepository.findById(newsId)
                .orElseThrow(() -> new RuntimeException("News not found"));

        Comments commentEntity = new Comments();

        commentEntity.setComment(comment);
        commentEntity.setNews(news);

        commentsRepository.save(commentEntity);

        return "Comment added successfully.";
    }

}
