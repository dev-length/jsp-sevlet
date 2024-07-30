package org.scoula.ex03;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sports")
public class SportsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
//        sports에 저장되어있는 값이 여러개이므로 getParameterValues를 통해 배열로 받아옴
        String[] sports = req.getParameterValues("sports");
        String sex = req.getParameter("sex");

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        out.print("<html><body>");
//        체크된 값들을 돌면서 하나씩 출력한다
        for(String s : sports) {
            out.print("좋아하는 운동: "+s+"<br>");
        }
//        라디오값은 하나밖에 선택이 안되므로 배열처리할 필요 없음
        out.print("성별 : "+sex+"<br>");
        out.print("</body></html>");
    }
}
