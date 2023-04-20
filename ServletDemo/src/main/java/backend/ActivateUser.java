/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package backend;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActivateUser extends HttpServlet {
    Connection con;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.parseInt("id");
        try {
            con =DBConnect.connect();
             String query ="UPDATE tbl_user SET status=? where id=?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, "active");
        stmt.setInt(2, id);
        stmt.executeUpdate();
        res.getWriter().println("User Activated Successfully");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ActivateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con.close();
        } catch (JMSException ex) {
            Logger.getLogger(ActivateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

   
}
