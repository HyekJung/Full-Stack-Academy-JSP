package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello") //서블릿 이름과 url 매핑
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.service(req, resp); //서블릿이 설치되면 해당 서비스가 실행됨
        System.out.println("HelloServlet.service");
        System.out.println("request = "+request);
        System.out.println("response = "+response);

        String userName = request.getParameter("userName");
        System.out.println("userName = " + userName);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello" + userName); //http body에 해당 내용 들어감
    }
}
