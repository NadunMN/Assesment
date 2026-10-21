package com.example.test.mapper;

import com.example.test.model.dto.CategoryDTO;
import com.example.test.model.dto.NewsDTO;
import com.example.test.model.entity.Category;
import com.example.test.model.entity.News;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    CategoryDTO toDto(Category entity);
    Category toEntity(CategoryDTO dto);

    NewsDTO toNewsDto(News news);
}
