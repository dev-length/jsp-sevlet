package org.scoula.ex04.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/cart_view_cookie")
public class CartViewCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<html><body>");
        out.print("장바구니 리스트<br>");

        // 기존 쿠키 가져오기
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                // 각 쿠키의 이름과 값을 출력
                out.print(cookie.getName() + " : " + cookie.getValue() + "<br>");
            }
        }else{
            out.print("장바구니 비었음<br>");
        }

        out.print("<a href='cookie_product.jsp'>상품 선택 페이지</a><br>");
        out.print("<a href='cart_delete_cookie'>장바구니 비우기</a><br>");
        out.print("</body></html>");
    }
}