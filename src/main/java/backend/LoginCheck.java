/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Shalon
 */
@WebFilter("/*")


public class LoginCheck implements Filter{

    @Override
    public void doFilter(ServletRequest sreq, ServletResponse sres, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) sreq;
        HttpServletResponse res= (HttpServletResponse) sres;
        
        if(req.getServletPath().equals("/frontend/LoginForm.jsp")||req.getServletPath().equals("/LoginUser")){
            System.out.println("okay");
            System.out.println(req.getServletPath());   
        }else{
            HttpSession session = req.getSession();
            if(session.getAttribute("username")==null){
                session.setAttribute("errorMsg", "you are not logged in");
                System.out.println(session.getAttribute("errorMsg"));
                res.sendRedirect("/ServletDemo/frontend/LoginForm.jsp");
                return;
            }else{
                
            }
            
        }
        fc.doFilter(req,res);
    }
    

    
}