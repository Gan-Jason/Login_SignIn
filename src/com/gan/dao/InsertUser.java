package com.gan.dao;

import com.gan.servlet.User;

public class InsertUser extends QueryDatabase{

    @Override
    public void setSql(String SQL) {
        super.setSql(SQL);
    }
    public boolean isIdExist(String id){
        Query query=new QueryDatabase();
        return  query.queryMysql(id);

    }
}
