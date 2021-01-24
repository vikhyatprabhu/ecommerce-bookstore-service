package com.ecommerce.bookstore.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ImageURL {
   @JsonProperty("Image")
   private String image; 
}
