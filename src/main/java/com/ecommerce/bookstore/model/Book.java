package com.ecommerce.bookstore.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.ecommerce.bookstore.utils.BookDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Book
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonDeserialize(using = BookDeserializer.class)
public class Book {

	@Id
    @JsonProperty("bookID")
    private Integer bookID;

    @JsonProperty("title")
    private String title;

    @JsonProperty("authors")
    private String authors;

    @JsonProperty("language_code")
    private String languageCode;

    @JsonProperty("average_rating")
    private float averageRating;

    @JsonProperty( "ratings_count")
    private int ratingsCount;

    @JsonProperty("price")
    private float price;

    @JsonProperty("isbn")
    private String isbn;

    @JsonProperty("imageUrl" )
    private String imageUrl;

}