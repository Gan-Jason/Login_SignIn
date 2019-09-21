package com.gan.dao;

import com.gan.servlet.User;

public interface Query {
    boolean queryMysql(User user);
    boolean insertMysql(User user);
    boolean queryMysql(String id);

}
