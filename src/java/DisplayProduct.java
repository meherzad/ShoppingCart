/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Meherzad
 */
public class DisplayProduct extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DisplayProduct</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DisplayProduct at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JSONObject jObject = null;
        PrintWriter out;
        JSONObject json = new JSONObject();
        JSONArray jArray = new JSONArray();
        DBConnection obj = new DBConnection();
        ResultSet rs = obj.getRecords("Select * from bookMaster;");
        System.out.println("record received");
        try {
            while (rs.next()) {
                jObject=new JSONObject();
                jObject.put("isbn", rs.getString("isbn"));
                jObject.put("title", rs.getString("title"));
                jObject.put("author", rs.getString("author"));
                jObject.put("price", rs.getString("price"));
                jObject.put("url", rs.getString("url"));
                jArray.add(jObject);
                
            }
            //response.setContentType("application/json");
            //response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            //StringWriter ot = new StringWriter();
            //jArray.writeJSONString(ot);
            //String jsonText = ot.toString();
            //System.out.println(jsonText);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            json.put("catalog", jArray);
            out.println(json);
        } catch (SQLException ex) {
            Logger.getLogger(DisplayProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
