package com.ecommerce.bookstore.utils;

import java.io.IOException;

import com.ecommerce.bookstore.model.Book;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class BookDeserializer extends JsonDeserializer<Book> {

    @Override
    public Book deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
        try {
            ObjectCodec oc = jsonParser.getCodec();
            JsonNode node = oc.readTree(jsonParser);
            final Integer id = node.get("bookID").asInt();
            String title = node.get("title").asText();
            if(title.length()>255){
                title = title.substring(0, 254);
            }
            String authors = node.get("authors").asText();
            if(authors.length()>255){
                authors = authors.substring(0, 254);
            }
            final String languageCode = node.get("language_code").asText();
            final float averageRating = (float) node.get("average_rating").asDouble();
            final int ratingsCount = node.get("ratings_count").asInt();
            final float price = (float) node.get("price").asDouble();
            final String isbn = node.get("isbn").asText();
            return new Book(id , title , authors , languageCode , averageRating , ratingsCount , price , isbn , "");
            
        } catch (JsonParseException ex) {
        } catch (Exception e) {
        }
        return null;
    }

}
