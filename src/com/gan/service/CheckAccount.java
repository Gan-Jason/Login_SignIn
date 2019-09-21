package com.gan.service;

import com.gan.dao.Query;
import com.gan.dao.QueryDatabase;
import com.gan.servlet.User;

import javax.servlet.http.HttpServlet;

public class CheckAccount  implements Check{


    @Override
    public boolean checkUser(User user) {
        QueryDatabase qu=new QueryDatabase();
        return qu.queryMysql(user);

    }
}
