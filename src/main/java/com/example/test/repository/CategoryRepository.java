package com.example.test.repository;

import com.example.test.model.entity.Category;
import com.example.test.model.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

//    List<News> findAllByCategory(Long id);

    @Query("SELECT c.news FROM Category c WHERE c.categoryId = :id")
    Optional<News> findNewsByCategoryId(@Param("id") Long id);
}
