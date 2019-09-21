package com.gan.dao;

import com.gan.servlet.User;

import java.sql.*;

public class QueryDatabase implements Query {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql;

    @Override
    public boolean queryMysql(User user) {
        try {
            String sql=String.format("select * from user where id='%s';",user.getUser());
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mxshop?serverTimezone=UTC&useSSL=False&", "root", "");
            ps = conn.prepareStatement(sql);
//            ps.setString(1,id);
//            ps.setString(2,pwd);
            rs = ps.executeQuery();
            if (rs.next()) {
                String pwd=rs.getString("password");
                if(pwd.equals(user.getPassword())){
                    System.out.println("correct password");
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return false;
    }
    //查询数据库，判断id是否已经存在数据库中
    public boolean queryMysql(String id) {
        try {
            String sql=String.format("select * from user where id='%s';",id);
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mxshop?serverTimezone=UTC&useSSL=False&", "root", "");
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            if (rs.next()) {
                    return true;
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
    public boolean insertMysql(User user){
        String id = user.getUser();
        String pwd = user.getPassword();
        int result;
        try {
            this.sql=String.format("insert into user values('%s','%s');",id,pwd);
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mxshop?serverTimezone=UTC&useSSL=False&", "root", "");
            ps = conn.prepareStatement(sql);
            result = ps.executeUpdate();
            if (result>=0) {
                System.out.println("Insert successfully");
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return false;
    }
    public void setSql(String SQL) {
        sql = SQL;
    }
}
