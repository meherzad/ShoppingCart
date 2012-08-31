<%-- 
    Document   : ProductList
    Created on : Jul 31, 2012, 1:08:14 AM
    Author     : Meherzad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
        <script type="text/javascript" src="http://cloud.github.com/downloads/wycats/handlebars.js/handlebars-1.0.0.beta.6.js"></script>
        <link rel="stylesheet" href="css/jquery.ui.all.css"/>
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
    <body>
        <div id="backgroundPopup" style="width: 70%;margin-left: 35%">
            <div id="cartDetail">

            </div>
            <input type="button" id="btnCheckOut" title="Check Out" value="Check Out"/>
             <a href="ProductMaster.jsp">Book Master</a>
            <table id="prodDisp" cellspacing="0">
                <tr >
                    <th></th>
                    <th>ISBN</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Price</th>
                    <th></th>
                </tr>
                <script id="template" type="text/x-handlebars-template">
                    {{#each this}}
                    <tr >
                        <td>
                            <img style="height: 100px;width: 50px;" src="img/{{{url}}}" alt="{{title}}" />
                        </td>    
                        <td>{{isbn}}</td>
                        <td>{{title}}</td>
                        <td>{{author}}</td>
                        <td>{{price}}</td>
                        <td>
                            <input type="button" id="{{{isbn}}}" class="btnAddToCart" value="Add to cart" title="Add To Cart"/>
                        </td>
                    </tr>         
                    {{/each}}
                    </script>
                </table>
            </div>


            <div id="checkOut" style="display: none;background-color: #F5FAFA;">
                <table>
                    <tr>
                        <th colspan="2">Add Details
                            <span style="float: right;">
                                <a id="checkOutClose" class="ui-dialog-titlebar-close ui-corner-all" >X</a> 
                            </span>
                        </th>

                    </tr>

                    <tr>
                        <td>Name</td>
                        <td><input type="text" id ="txtName" name="txtName"/></td>
                    </tr>
                    <tr>
                        <td>Address</td>
                        <td><input type="text" id="txtAddress" name="txtAddress"/></td>
                    </tr>
                    <tr>
                        <td>Contact</td>
                        <td><input type="text" id="txtContact" name="txtContact"/></td>
                    </tr>
                    <tr>
                        <th colspan="2"> 
                            <span style="margin-left: 30%;"  >
                                <input type="button" id="MakePayment" title="Pay" value="Pay"/>
                            </span>
                        </th>
                    </tr>
                </table>    

            </div>

            <script>
                var popupStatus = 0;  
                var cart=$("#cartDetail");
                (function(){
                    var data=$.getJSON("DisplayProduct",function(dt){
                        var temp=Handlebars.compile($("#template").html());
                        console.log(data);
                        console.log("asdasdasd   "+dt.catalog);
                        var o=jQuery.parseJSON(dt.catalog);
                        console.log("565555555555  "+o);
                        $("#prodDisp").append(temp(dt.catalog));
                    });
                
                    $("#btnCheckOut").on("click",function(){
                        centerPopup();  
                        loadPopup();  
                    });
                    $("#checkOutClose").on("click",function(){ 
                        disablePopup();  
                    });  
                    //class="ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix"
                    $("#MakePayment").live("click",function(){
                        $.ajaxSetup({
                            url:"AddToCart",
                            data: {
                                "type":1, 
                                "txtName":$("#txtName").val(),
                                "txtAddress":$("#txtAddress").val(),
                                "txtContact":$("#txtContact").val()
                            },
                            type: "POST",
                            success:function(result){
                                cart.html(result);
                            }
                        }); 
                        console.log("ttttttttt "+$("#txtName").val());
                        $.ajax();
                        disablePopup();  
                    });
                })();
                $(".btnAddToCart").live("click",function(){
                    console.log("add to cart clicked");
                    $.ajaxSetup({
                        url:"AddToCart",
                        data: {"type":0, "id":$(this).attr('id')},
                        type: "POST",
                        success:function(result){
                            cart.html(result);
                        }
                    }); 
                    $.ajax();
                });
                function loadPopup(){  
                    if(popupStatus==0){  
                        $("#backgroundPopup").css({  
                            "opacity": "0.2"  
                        });  
                        //$("#backgroundPopup").fadeIn("slow");  
                        $("#checkOut").fadeIn("slow");  
                        popupStatus = 1;  
                    }  
                }  
                function disablePopup(){  
                    if(popupStatus==1){  
                        //$("#backgroundPopup").fadeOut("slow");  
                        $("#checkOut").fadeOut("fast");
                        $("#backgroundPopup").css({  
                            "opacity": "1"  
                        });  
                        popupStatus = 0;  
                    }  
                }  
                function centerPopup(){  
                    var windowWidth = document.documentElement.clientWidth;  
                    var windowHeight = document.documentElement.clientHeight;  
                    var popupHeight = $("#checkOut").height();  
                    var popupWidth = $("#checkOut").width();  

                    $("#checkOut").css({  
                        "position": "absolute",  
                        "top": windowHeight/2-popupHeight/2,  
                        "left": windowWidth/2-popupWidth/2  
                    });  
                    $("#backgroundPopup").css({  
                        "height": windowHeight  
                    });  
  
                }  
            </script>
        </body>
    </html>
