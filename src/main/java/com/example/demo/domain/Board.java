package com.example.demo.domain;

import com.example.demo.converter.LocalDatePersistenceConverter;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "num")
    private int num;

    @Column(name = "title")
    private  String title;

    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private String content;

    @Column(name = "created_date")
    private LocalDate createdDate;
}
