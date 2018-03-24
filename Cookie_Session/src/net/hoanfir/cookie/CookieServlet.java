package net.hoanfir.cookie;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import java.io.IOException;

@WebServlet(name = "CookieServlet", urlPatterns = "/cookie")
public class CookieServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Cookie cookie = new Cookie("username", "jaanai");

        //        若想删除客户端已经存储的cookie信息，可以使用同名同路径持久化时间为0的cookie进行覆盖
        cookie.setMaxAge(60*10);

//        cookie.setPath("/hello") 代表访问hello应用中的所有资源都携带cookie
//        cookie.setPath("/hello/coookieServlet") 代表访问hello应用中的cookieServlet时才携带cookie
        cookie.setPath("/hello/getcookie");

        Cookie cookie1 = new Cookie("goodsname", "telephone");
        response.addCookie(cookie1);

//        向客户端发送cookie
        response.addCookie(cookie);
    }
}
