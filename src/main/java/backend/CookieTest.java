package backend;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shalon
 */
public class CookieTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       Cookie cookie = new Cookie("token", "akldjf2oijfad");
       
       res.addCookie(cookie);
       res.getWriter().println("cookie created");
    }

    
    
}