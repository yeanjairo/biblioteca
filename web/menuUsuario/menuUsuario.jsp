<%-- 
    Document   : panel
    Created on : 05/10/2020, 06:03:17 PM
    Author     : Windows 10
--%>

<%@page import="dao.DaoLibro"%>
<%@page import="beans.BeansLibro"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="beans.BeansUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<% 
if(session.getAttribute("n")!=null || session.getAttribute("t")!=null){   
    String n,t;
    n=session.getAttribute("n").toString();
    t=session.getAttribute("t").toString(); 
}else{
      response.sendRedirect("index.jsp");              
}
String p=request.getParameter("cadena");

%>

<html>
    <head>
        <link href="stylo/stylomenu.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table align="center" border="2">
            <tr>
                <td>
                    <div>
                        <table border="1">
                            <tr>
                                <td rowspan="3">LOGO 1</td>
                                <td> LIBRERIA UNIVERSIDAD NACIONAL PEDRO RUIZ GALLO</td>
                            </tr>
                            <tr align="center">
                                <td>Menú de administración</td>
                                <td> Hola: <%=session.getAttribute("n")%> </td>
                            </tr>
                            <tr align="center">
                                <td>Administración</td>
                                <td> <a href="servletUsuario?destino=salir">salir</a> </td>
                            </tr>
                        </table>
                    </div>        
                </td>
            </tr>
        </table>

        <br>
        <br>
        <form action="servletLibro" method="post">
        <table align="center" border="2">
            <tr>
                <td>
                    <div>
                        <ul class="nav">
                            <li><a href="servletUsuario?destino=inicio">Inicio</a></li>
                            <li><a href="servletLibro?destino=Listar">Listar</a></li>
                            <input type="hidden" name = "operacion" value="Listar">
                            <li><a>Mantenimiento</a>
                                <ul>
                                    <li><a href="servletLibro?destino=Add">Registrar Libros</a></li>
                                    <!-- comment -->
                              
                                </ul>
                            </li>
                        </ul>
                    </div>
                </td>
            </tr>
        </table>
        </form>
        <br>
        <br>
   
    </body>
</html>
