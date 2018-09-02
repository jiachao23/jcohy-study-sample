package com.jcohy.study.elasticsearch;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by jiac on 2018/9/2.
 * ClassName  : com.jcohy.study.elasticsearch
 * Description  :
 */
public interface BookRepository extends ElasticsearchRepository<Book, String> {

}
