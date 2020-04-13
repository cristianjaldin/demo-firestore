package com.example.firestore.demofirestore.entity;

import com.google.cloud.firestore.annotation.DocumentId;

import org.springframework.cloud.gcp.data.firestore.Document;

@Document(collectionName = "books")
public class Book {

    @DocumentId
    //private Long  id;
    private String  id;
    private String title;
    private Author author;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}