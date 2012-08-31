package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ProductMaster_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("        <title>Insert title here</title>\n");
      out.write("        <script type=\"text/javascript\"\n");
      out.write("        src=\"js/jquery-1.7.2.min.js\"></script>\n");
      out.write("        <style>\n");
      out.write("            th {\n");
      out.write("                font: bold 11px \"Trebuchet MS\", Verdana, Arial, Helvetica,\n");
      out.write("                    sans-serif;\n");
      out.write("                color: #6D929B;\n");
      out.write("                border-right: 1px solid #C1DAD7;\n");
      out.write("                border-bottom: 1px solid #C1DAD7;\n");
      out.write("                border-left: 1px solid #C1DAD7;\n");
      out.write("                border-top: 1px solid #C1DAD7;\n");
      out.write("                letter-spacing: 2px;\n");
      out.write("                text-transform: uppercase;\n");
      out.write("                text-align: left;\n");
      out.write("                padding: 6px 6px 6px 12px;\n");
      out.write("                background: #CAE8EA url(img/bg_header.jpg) no-repeat;\n");
      out.write("            }\n");
      out.write("            td {\n");
      out.write("                border-right: 1px solid #C1DAD7;\n");
      out.write("                border-left: 1px solid #C1DAD7;\n");
      out.write("                border-bottom: 1px solid #C1DAD7;\n");
      out.write("                background: #fff;\n");
      out.write("                padding: 6px 6px 6px 12px;\n");
      out.write("                color: #6D929B;\n");
      out.write("            }\n");
      out.write("            td.alt {\n");
      out.write("                background: #F5FAFA;\n");
      out.write("                color: #B4AA9D;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"width: 50%;margin-left: 40%;margin-top:5%\">\n");
      out.write("        <form method=\"post\" action=\"AddProduct\">\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <th colspan=\"2\">Book Master</th>\n");
      out.write("                </tr>\n");
      out.write("                <tr></tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Book name </td>\n");
      out.write("                    <td><input type=\"text\" id=\"txtName\" name=\"txtName\"/></td>\n");
      out.write("                </tr>    \n");
      out.write("                <tr>\n");
      out.write("                    <td>Book Author</td>\n");
      out.write("                    <td><input type=\"text\" id=\"txtAuthor\" name=\"txtAuthor\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Book price</td>\n");
      out.write("                    <td><input type=\"text\" id=\"txtPrice\" name=\"txtPrice\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Book ISBN</td>\n");
      out.write("                    <td><input type=\"text\" id=\"txtIsbn\" name=\"txtIsbn\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Book Img Url</td>\n");
      out.write("                    <td><input type=\"text\" id=\"txtUrl\" name=\"txtUrl\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                <div id=\"output\"></div>\n");
      out.write("                </tr>\n");
      out.write("                <tr >\n");
      out.write("                    <td colspan=\"2\" style=\"text-align: center\">\n");
      out.write("                        <input type=\"submit\" text=\"Submit\" id=\"btnSubmit\" value=\"Submit\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>           \n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
