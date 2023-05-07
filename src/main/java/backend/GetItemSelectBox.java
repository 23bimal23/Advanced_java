/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class GetItemSelectBox extends HttpServlet {
  Connection con;
        
    @Override
    public void init() throws ServletException {
        
        try {
            con = DBConnect.connect();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(itemSave.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    
      try {
          String query= "select * from tbl_item";
          Statement  stmt = con.createStatement();
          ResultSet result = stmt.executeQuery(query);
          String combo = "<select name='item_id' >";
          
          while(result.next()){
              String id = result.getString("id");
              String itemName = result.getString("name");
              combo += "<option value='"+id+"'>";
              combo += itemName;
              combo+="</option>";
              
          }
          combo+="</select>";
          res.setContentType("text/html");
          res.getWriter().println(combo);
      } catch (SQLException ex) {
          Logger.getLogger(GetItemSelectBox.class.getName()).log(Level.SEVERE, null, ex);
      }
        }

    @Override
    public void destroy() {
      try {
          con.close();
      } catch (SQLException ex) {
          Logger.getLogger(GetItemSelectBox.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
}