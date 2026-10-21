package com.example.test.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "news")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long newsId;

    @Column(name = "heading", nullable = false)
    private String heading;

    @Column(name = "detail", nullable = false)
    private String detail;

    @OneToMany(mappedBy = "news")
    private List<Category> categories = new ArrayList<>();

    @OneToMany(mappedBy = "news")
    private List<Comments> comments = new ArrayList<>();


}
