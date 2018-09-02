package com.jcohy.study.elasticsearch;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by jiac on 2018/9/2.
 * ClassName  : com.jcohy.study.elasticsearch
 * Description  :
 */
@Document(indexName = "jcohy",type = "book")
public class Book {

    private Integer id;
    private String name;
    private String author;
    private Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
