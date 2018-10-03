package Servletes;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if("admin".equals(username) && "admin".equals(password)){
            resp.getWriter().write("Login successfully");
            req.setAttribute("username",username);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("homepage");
            requestDispatcher.forward(req,resp);
        }
        else{
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Error during login");
        }
    }
}
