package com.jcohy.study.BloomFilter;

import java.util.List;

/**
 * Created by jiac on 2019/3/12.
 * ClassName  : com.jcohy.study.test
 * Description  :
 */
public interface UserService {
    List<User> findAllUser();
    User getUserByName(String name);
}
