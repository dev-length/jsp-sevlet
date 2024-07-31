package org.scoula.ex04.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cart_delete_cookie")
public class CartDeleteCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<html><body>");

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for(Cookie cookie : cookies) {
                // 쿠키의 유효기간을 1초로 설정해서 사라지게 만든다
                cookie.setMaxAge(1);
                resp.addCookie(cookie);
            }
        }

        out.print("장바구니 비웠음! <br>");
        out.print("<a href='cookie_product.jsp'>상품 선택 페이지</a><br>");
        out.print("</body></html>");
    }
}
