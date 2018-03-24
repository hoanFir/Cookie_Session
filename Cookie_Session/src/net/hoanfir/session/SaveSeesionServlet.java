package net.hoanfir.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "SaveSeesionServlet", urlPatterns = "/save")
public class SaveSeesionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

//        创建一个cookie覆盖之前服务器自动生成的JSESSIONID
        Cookie cookie = new Cookie("JSESSIONID", session.getId());

//        session的创建和获取取决于cookie中的JSESSIONID决定的，所以cookie如果被清除后，服务器就无法找到对应的session了
//        因此，对session的持久化就是对JSESSIONID持久化
//        设置持久化时间
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);

        session.setAttribute("username", "jaanai");
    }
}
