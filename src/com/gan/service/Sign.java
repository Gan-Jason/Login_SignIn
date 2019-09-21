package com.gan.service;

import com.gan.dao.InsertUser;
import com.gan.servlet.User;


public class Sign {

    public boolean sign(User user){
        InsertUser ins=new InsertUser();
        if(ins.queryMysql(user.getUser()))
            return false;
        return ins.insertMysql(user);


    }


}
