package com.gan.servlet;

import com.gan.service.Sign;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/signIn")
public class UserSignIn extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Sign s = new Sign();
        String id=req.getParameter("uname");
        String pwd=req.getParameter("pwd");
        User u=new User();
        u.setPassword(pwd);
        u.setUser(id);
        if(s.sign(u)) {
            HttpSession se = req.getSession();
            se.setAttribute("user",u);
            resp.sendRedirect("main");
        } else{
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("用户已存在！");
        }

    }
}
