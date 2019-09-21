package com.gan.servlet;

import com.gan.dao.QueryDatabase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.CheckAccount(req, resp);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session=req.getSession();
        Cookie[] ck_result;
        ck_result=req.getCookies();
        if(ck_result.length>0){
            for(Cookie cookie:ck_result) {
                String user_name = "";
                if (cookie.getName().equals("user")) {
                    String name = cookie.getValue();
                    if (new QueryDatabase().queryMysql(name)) {
                        session.setAttribute("user", name);
                        resp.sendRedirect("main");

                    }
                }
            }
        }
        resp.getWriter().write("-----------------------");
        resp.getWriter().write("<html>");
        resp.getWriter().write("<head>");
        resp.getWriter().write("</head>");
        resp.getWriter().write("<body>");
        resp.getWriter().write("<form action='check' method='post'>");
        resp.getWriter().write("”√ªß√˚: <input type='text' name='uname' value=''><br />");
        resp.getWriter().write("√‹¬Î: <input type='password' name='pwd' value=''><br />");
        resp.getWriter().write("<input type='submit' value='µ«¬º'><br />");
        resp.getWriter().write("</form>");
        resp.getWriter().write("</body>");
        resp.getWriter().write("</html>");


    }
}
