<%-- 
    Document   : ProductMaster
    Created on : Jul 31, 2012, 1:01:10 AM
    Author     : Meherzad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>
        <script type="text/javascript"
        src="js/jquery-1.7.2.min.js"></script>
        <style>
            th {
                font: bold 11px "Trebuchet MS", Verdana, Arial, Helvetica,
                    sans-serif;
                color: #6D929B;
                border-right: 1px solid #C1DAD7;
                border-bottom: 1px solid #C1DAD7;
                border-left: 1px solid #C1DAD7;
                border-top: 1px solid #C1DAD7;
                letter-spacing: 2px;
                text-transform: uppercase;
                text-align: left;
                padding: 6px 6px 6px 12px;
                background: #CAE8EA url(img/bg_header.jpg) no-repeat;
            }
            td {
                border-right: 1px solid #C1DAD7;
                border-left: 1px solid #C1DAD7;
                border-bottom: 1px solid #C1DAD7;
                background: #fff;
                padding: 6px 6px 6px 12px;
                color: #6D929B;
            }
            td.alt {
                background: #F5FAFA;
                color: #B4AA9D;
            }

        </style>
    </head>
    <body style="width: 50%;margin-left: 40%;margin-top:5%">
        <form method="post" action="AddProduct">
            <a href="ProductList.jsp">Book List</a>
            <table>
                <tr>
                    <th colspan="2">Book Master</th>
                </tr>
                <tr></tr>
                <tr>
                    <td>Book name </td>
                    <td><input type="text" id="txtName" name="txtName"/></td>
                </tr>    
                <tr>
                    <td>Book Author</td>
                    <td><input type="text" id="txtAuthor" name="txtAuthor"/></td>
                </tr>
                <tr>
                    <td>Book price</td>
                    <td><input type="text" id="txtPrice" name="txtPrice"/></td>
                </tr>
                <tr>
                    <td>Book ISBN</td>
                    <td><input type="text" id="txtIsbn" name="txtIsbn"/></td>
                </tr>
                <tr>
                    <td>Book Img Url</td>
                    <td><input type="text" id="txtUrl" name="txtUrl"/></td>
                </tr>
                <tr>
                <div id="output"></div>
                </tr>
                <tr >
                    <td colspan="2" style="text-align: center">
                        <input type="submit" text="Submit" id="btnSubmit" value="Submit"/>
                    </td>
                </tr>
            </table>           
        </form>

    </body>
</html>