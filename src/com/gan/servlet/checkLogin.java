package com.gan.servlet;

import com.gan.service.Check;
import com.gan.service.CheckAccount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/check")
public class checkLogin extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        HttpSession se=req.getSession();
        String user=req.getParameter("uname");
        String pwd=req.getParameter("pwd");
        User u=new User();
        u.setUser(user);
        u.setPassword(pwd);

        Check check=new CheckAccount();
        if(check.checkUser(u)) {
            System.out.println("user exist");
            se.setAttribute("user", u);
            Cookie ck=new Cookie("user",u.getUser());
            ck.setPath("login");
            resp.addCookie(ck);
            resp.sendRedirect("main");

        }else{

            resp.sendRedirect("sign");

        }
    }
}
