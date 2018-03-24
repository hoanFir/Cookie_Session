package net.hoanfir.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SessionServlet", urlPatterns = "/session")
public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        session技术是将数据存储在服务器端的技术，会为每一个客户端创建一块内存空间存储客户的数据
//        注意，每个客户都需要每次携带一个标识ID（JSESSIONID）去服务器寻找属于自己的内存空间
//        session的实现基于cookie，因为那个ID是存在cookie里面的

//        第一次访问没有session，服务器会自动创建一个session对象
//        之后再进行访问的时候已经存在了session对象，可直接获取这个对象
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        response.getWriter().write("JSESSIONID=" + sessionId);

//        向session中存取数据，注意session也是一个域对象

//        session具有对象的生命周期
//        如果没有设置生命周期，即若没有持久化，每次关闭重启客户端就会产生一个新的JSESSIONID

    }
}
