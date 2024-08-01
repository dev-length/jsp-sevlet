package org.example.ex05.domain;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/scope")
public class ScopeServlet extends HttpServlet {
    ServletContext sc;

    @Override
    public void init(ServletConfig config) throws ServletException {
       sc = config.getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        sc.setAttribute("scopeName", "alpplication 값");

        HttpSession session = req.getSession();
        session.setAttribute("scopeName", "session 값");

        req.setAttribute("scopeName", "requstScope 값");
        Member member =  new Member("홍길동","hong");
        req.setAttribute("member",member);

        req.getRequestDispatcher("scope.jsp").forward(req,resp);
    }
}
