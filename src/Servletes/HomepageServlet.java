package Servletes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/homepage")
public class HomepageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username =(String) req.getAttribute("username");

        if(username!=null){
            resp.getWriter().write("Welcome to the homepage");
        }
        else{
            resp.sendError(HttpServletResponse.SC_FORBIDDEN,"This page is forbidden");
        }
    }
}
