/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Meherzad
 */
public class AddToCart extends HttpServlet {

    Cart cart;
    HttpSession session = null;

    public AddToCart() {
    }

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
            out.println("<title>Servlet AddToCart</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddToCart at " + request.getContextPath () + "</h1>");
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
        processRequest(request, response);
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
        PrintWriter out = response.getWriter();
        String str = request.getParameter("type");
        int type;
        if (str != null) {
            type = Integer.parseInt(str);
        } else {
            System.out.print("Error");
            return;
        }
        session = request.getSession(true);
        if (session.getAttribute("cart") == null) {
            cart = new Cart();
        } else {
            cart = (Cart) session.getAttribute("cart");
        }

        if (type == 0) {
            cart.addToCart(Integer.parseInt(request.getParameter("id")));
            out.write("Prod added " + cart.cartSize());
            session.setAttribute("cart", cart);
        } else {
            int nTotal = 0;
            try {
                DBConnection ob = new DBConnection();
                String query;
                int total = 0, transId;
                query = "Insert into transMaster(custName, custAddress, total ) values('";
                query = query + request.getParameter("txtName") + "', '" + request.getParameter("txtAddress");
                query = query + "', " + total + ");";
                System.out.println("Trans master " + query);
                ob.setRecords(query);
                query = "Select last_insert_rowid();";
                ResultSet rs = ob.getRecords(query);
                System.out.println("55555555555555  " + rs.toString());
                rs.next();
                transId = Integer.parseInt(rs.getString(1));
                System.out.println("5511111111155asdasdasda  " + transId);
                Hashtable<Integer, Integer> list = cart.sendCart();
                rs.close();
                for (Map.Entry<Integer, Integer> li : list.entrySet()) {
                    query = "select * from bookMaster where isbn=" + li.getKey() + ";";
                    System.out.println("query  " + query);

                    ResultSet rs1 = ob.getRecords(query);
                    rs1.next();
                    total = rs1.getInt("price");
                    total *= li.getValue();
                    nTotal += total;
                    query = "insert into transDetail(transId, productId, prodQuant, total) values";
                    query += " (" + transId + ", " + li.getKey() + ", " + li.getValue() + ", " + total + ");";
                    System.out.println("Detail query  " + query);
                    ob.setRecords(query);
                    query = "Update transMaster set total=" + nTotal + " where transId=" + transId + ";";
                    System.out.println("Detail query  " + query);
                    ob.setRecords(query);
                }
                cart.emptyCart();
                out.write("Transaction recorded added");

            } catch (SQLException ex) {
                Logger.getLogger(AddToCart.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                session.setAttribute("cart", null);
            }
        }

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
