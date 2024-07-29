package org.scoula.ex02;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "MyServlet", urlPatterns = {"/xxx", "/yyy"})
public class HelloServlet extends HttpServlet {
    private String message;
    private String message1;

    @Override
    public void init() throws ServletException {
//        message = "Hello Servlet!";
        System.out.println("init 호출");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        charset=UTF-8 추가해야 한글 안 깨짐
        response.setContentType("text/html; charset=UTF-8");

        // Hello
        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("<a href='/'>" + "홈으로" + "<a>");
//        out.println("</body></html>");
        System.out.println("Hello Servlet 요청");
        out.println("<h1>Hello Servlet</h1>");
    }

    @Override
    public void destroy() {
        System.out.println("destroy 호출");
    }
}