package com.gan.servlet;

import com.gan.service.CheckAccount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sign")
public class SignIn extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("uname");
        String pwd=req.getParameter("pwd");
        User u=new User();
        u.setPassword(pwd);
        u.setUser(id);
        CheckAccount ca=new CheckAccount();

        if(!ca.checkUser(u)) {
            req.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("�û��������ڻ����������!");
            resp.getWriter().write("�������µ�½������ע�᣺");
            resp.getWriter().write("<html>");
            resp.getWriter().write("<head>");
            resp.getWriter().write("</head>");
            resp.getWriter().write("<body>");
            resp.getWriter().write("<form action='signIn' method='post '>");
            resp.getWriter().write("�û���: <input type='text' name='uname' value=''><br />");
            resp.getWriter().write("����: <input type='text' name='pwd' value=''><br />");
            resp.getWriter().write("<input type='submit' value='ע��'><br />");
            resp.getWriter().write("</form>");
            resp.getWriter().write("</body>");
            resp.getWriter().write("</html>");
        }else{
            resp.sendRedirect("main");
        }


    }
}
