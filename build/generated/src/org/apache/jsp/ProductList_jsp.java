package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ProductList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title></title>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery-1.7.2.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"http://cloud.github.com/downloads/wycats/handlebars.js/handlebars-1.0.0.beta.6.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/jquery.ui.all.css\"/>\n");
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
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"backgroundPopup\" style=\"width: 70%;margin-left: 35%\">\n");
      out.write("            <div id=\"cartDetail\">\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <input type=\"button\" id=\"btnCheckOut\" title=\"Check Out\" value=\"Check Out\"/>\n");
      out.write("            <table id=\"prodDisp\" cellspacing=\"0\">\n");
      out.write("                <tr >\n");
      out.write("                    <th></th>\n");
      out.write("                    <th>ISBN</th>\n");
      out.write("                    <th>Title</th>\n");
      out.write("                    <th>Author</th>\n");
      out.write("                    <th>Price</th>\n");
      out.write("                    <th></th>\n");
      out.write("                </tr>\n");
      out.write("                <script id=\"template\" type=\"text/x-handlebars-template\">\n");
      out.write("                    {{#each this}}\n");
      out.write("                    <tr >\n");
      out.write("                        <td>\n");
      out.write("                            <img style=\"height: 100px;width: 50px;\" src=\"img/{{{url}}}\" alt=\"{{title}}\" />\n");
      out.write("                        </td>    \n");
      out.write("                        <td>{{isbn}}</td>\n");
      out.write("                        <td>{{title}}</td>\n");
      out.write("                        <td>{{author}}</td>\n");
      out.write("                        <td>{{price}}</td>\n");
      out.write("                        <td>\n");
      out.write("                            <input type=\"button\" id=\"{{{isbn}}}\" class=\"btnAddToCart\" value=\"Add to cart\" title=\"Add To Cart\"/>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>         \n");
      out.write("                    {{/each}}\n");
      out.write("                    </script>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div id=\"checkOut\" style=\"display: none;background-color: #F5FAFA;\">\n");
      out.write("                <table>\n");
      out.write("                    <tr>\n");
      out.write("                        <th colspan=\"2\">Add Details\n");
      out.write("                            <span style=\"float: right;\">\n");
      out.write("                                <a id=\"checkOutClose\" class=\"ui-dialog-titlebar-close ui-corner-all\" >X</a> \n");
      out.write("                            </span>\n");
      out.write("                        </th>\n");
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Name</td>\n");
      out.write("                        <td><input type=\"text\" id =\"txtName\" name=\"txtName\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Address</td>\n");
      out.write("                        <td><input type=\"text\" id=\"txtAddress\" name=\"txtAddress\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Contact</td>\n");
      out.write("                        <td><input type=\"text\" id=\"txtContact\" name=\"txtContact\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <th colspan=\"2\"> \n");
      out.write("                            <span style=\"margin-left: 30%;\"  >\n");
      out.write("                                <input type=\"button\" id=\"MakePayment\" title=\"Pay\" value=\"Pay\"/>\n");
      out.write("                            </span>\n");
      out.write("                        </th>\n");
      out.write("                    </tr>\n");
      out.write("                </table>    \n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <script>\n");
      out.write("                var popupStatus = 0;  \n");
      out.write("                var cart=$(\"#cartDetail\");\n");
      out.write("                (function(){\n");
      out.write("                    var data=$.getJSON(\"DisplayProduct\",function(dt){\n");
      out.write("                        var temp=Handlebars.compile($(\"#template\").html());\n");
      out.write("                        console.log(data);\n");
      out.write("                        console.log(\"asdasdasd   \"+dt.catalog);\n");
      out.write("                        var o=jQuery.parseJSON(dt.catalog);\n");
      out.write("                        console.log(\"565555555555  \"+o);\n");
      out.write("                        $(\"#prodDisp\").append(temp(dt.catalog));\n");
      out.write("                    });\n");
      out.write("                \n");
      out.write("                    $(\"#btnCheckOut\").on(\"click\",function(){\n");
      out.write("                        centerPopup();  \n");
      out.write("                        loadPopup();  \n");
      out.write("                    });\n");
      out.write("                    $(\"#checkOutClose\").on(\"click\",function(){ \n");
      out.write("                        disablePopup();  \n");
      out.write("                    });  \n");
      out.write("                    //class=\"ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix\"\n");
      out.write("                    $(\"#MakePayment\").live(\"click\",function(){\n");
      out.write("                        $.ajaxSetup({\n");
      out.write("                            url:\"AddToCart\",\n");
      out.write("                            data: {\n");
      out.write("                                \"type\":1, \n");
      out.write("                                \"txtName\":$(\"#txtName\").val(),\n");
      out.write("                                \"txtAddress\":$(\"#txtAddress\").val(),\n");
      out.write("                                \"txtContact\":$(\"#txtContact\").val()\n");
      out.write("                            },\n");
      out.write("                            type: \"POST\",\n");
      out.write("                            success:function(result){\n");
      out.write("                                cart.html(result);\n");
      out.write("                            }\n");
      out.write("                        }); \n");
      out.write("                        console.log(\"ttttttttt \"+$(\"#txtName\").val());\n");
      out.write("                        $.ajax();\n");
      out.write("                        disablePopup();  \n");
      out.write("                    });\n");
      out.write("                })();\n");
      out.write("                $(\".btnAddToCart\").live(\"click\",function(){\n");
      out.write("                    console.log(\"add to cart clicked\");\n");
      out.write("                    $.ajaxSetup({\n");
      out.write("                        url:\"AddToCart\",\n");
      out.write("                        data: {\"type\":0, \"id\":$(this).attr('id')},\n");
      out.write("                        type: \"POST\",\n");
      out.write("                        success:function(result){\n");
      out.write("                            cart.html(result);\n");
      out.write("                        }\n");
      out.write("                    }); \n");
      out.write("                    $.ajax();\n");
      out.write("                });\n");
      out.write("                function loadPopup(){  \n");
      out.write("                    if(popupStatus==0){  \n");
      out.write("                        $(\"#backgroundPopup\").css({  \n");
      out.write("                            \"opacity\": \"0.2\"  \n");
      out.write("                        });  \n");
      out.write("                        //$(\"#backgroundPopup\").fadeIn(\"slow\");  \n");
      out.write("                        $(\"#checkOut\").fadeIn(\"slow\");  \n");
      out.write("                        popupStatus = 1;  \n");
      out.write("                    }  \n");
      out.write("                }  \n");
      out.write("                function disablePopup(){  \n");
      out.write("                    if(popupStatus==1){  \n");
      out.write("                        //$(\"#backgroundPopup\").fadeOut(\"slow\");  \n");
      out.write("                        $(\"#checkOut\").fadeOut(\"slow\");\n");
      out.write("                        $(\"#backgroundPopup\").css({  \n");
      out.write("                            \"opacity\": \"1\"  \n");
      out.write("                        });  \n");
      out.write("                        popupStatus = 0;  \n");
      out.write("                    }  \n");
      out.write("                }  \n");
      out.write("                function centerPopup(){  \n");
      out.write("                    var windowWidth = document.documentElement.clientWidth;  \n");
      out.write("                    var windowHeight = document.documentElement.clientHeight;  \n");
      out.write("                    var popupHeight = $(\"#checkOut\").height();  \n");
      out.write("                    var popupWidth = $(\"#checkOut\").width();  \n");
      out.write("\n");
      out.write("                    $(\"#checkOut\").css({  \n");
      out.write("                        \"position\": \"absolute\",  \n");
      out.write("                        \"top\": windowHeight/2-popupHeight/2,  \n");
      out.write("                        \"left\": windowWidth/2-popupWidth/2  \n");
      out.write("                    });  \n");
      out.write("                    $(\"#backgroundPopup\").css({  \n");
      out.write("                        \"height\": windowHeight  \n");
      out.write("                    });  \n");
      out.write("  \n");
      out.write("                }  \n");
      out.write("            </script>\n");
      out.write("        </body>\n");
      out.write("    </html>\n");
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
