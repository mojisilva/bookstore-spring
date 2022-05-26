package com.moji.bookstore.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "books")
public class Book {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long code;

        @Size(max = 50)
        @Column(nullable = false)
        private String name;

        @Column(nullable = false)
        private double price;

        @Column(nullable = false)
        private int quantity = 0;

        @Size(max = 50)
        @Column(nullable = false)
        private String category;


        private String imgUrl;
    }
