package org.scoula.ex04.redirect;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response_redirect")
public class ResponseRedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청이 달라졌기 때문에 해당 값들은 null이 나온다. 이전 서블릿의 속성은 세션으로 저장해줘야한다.
        String username = request.getParameter("username");
        String useraddress = request.getParameter("useraddress");

        request.setAttribute("username",username);
        request.setAttribute("useraddress",useraddress);

        RequestDispatcher dis = request.getRequestDispatcher("/redirect_response.jsp");
        dis.forward(request, response);
    }
}
