/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package backend;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Shalon
 */
public class ActivateUser extends HttpServlet {
    Connection con;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            con = DBConnect.connect();
            String query = "update tbl_user SET status =? where id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, "active");
            stmt.setInt(2, id);
            stmt.executeUpdate();
            
            res.getWriter().println("user activated successfully");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ActivateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   
}
