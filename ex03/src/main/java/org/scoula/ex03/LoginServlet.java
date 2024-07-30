package org.scoula.ex03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
//    GET 메소드로 보낸 데이터를 받아오기 위해서는 doGet 메소드 사용
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 요청에서 파라미터 얻기
        String userid = req.getParameter("userid");
        String password = req.getParameter("passwd");

        // 응답 내보내기
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.print("<html><body>");
        out.print("아이디값 : " + userid + "<br>");
        out.print("비밀번호값 : " + password + "<br>");
        out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        POST 메소드의 경우 기본값 인코딩은 한글이 깨지므로 UTF-8 변경 필수!
        req.setCharacterEncoding("UTF-8");
        //        GET 메소드와 동일한 로직을 처리하고 싶으므로 doGet 호출
        doGet(req,resp);
    }
}
