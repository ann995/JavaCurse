package Servletes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/paramRouter")
public class RouterParamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String site = req.getParameter("site");

        if("main.jsp".equals(site) || "about.jsp".equals(site) || "contact.jsp".equals(site)){
            resp.sendRedirect(resp.encodeRedirectURL(site));
        }
        else{
            resp.sendError(HttpServletResponse.SC_NOT_FOUND,"Address " + site + " not found");
        }
    }
}
