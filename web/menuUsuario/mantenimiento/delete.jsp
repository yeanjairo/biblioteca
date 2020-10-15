<%-- 
    Document   : delete
    Created on : 14/10/2020, 04:17:05 AM
    Author     : Windows 10
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="beans.BeansLibro"%>
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
        
<%
       BeansLibro l=new BeansLibro();
       List<BeansLibro> lista1=new ArrayList();      
       lista1=(List<BeansLibro>)request.getAttribute("lista");
       session.removeAttribute("lista");
%>

        <table align="center">
            <tr>
                <td align="center">
                    <form action="servletLibro" method="post" enctype="multipart/form-data">
                        <table>
                            <tr>
                                <td>Código:</td>
                                <td><input type="text" id="codigo" name="codigo" disabled value="<%= lista1.get(0).getCodigo_libro()%>"></td>
                                <input type="hidden" id="codigo1" name="codigo1" value="<%= lista1.get(0).getCodigo_libro()  %>">
                            </tr>
                            <tr>
                                <td>Título:</td>
                                <td><input type="text" id="titulo" name="titulo" value="<%= lista1.get(0).getTitulo() %>"></td>
                            </tr>
                            <tr>
                                <td>Año:</td>
                                <td><input type="text" id="year" name="year" value="<%= lista1.get(0).getAño() %>"></td>
                            </tr>
                            <tr>
                                <td>Nivel:</td>
                                <td><input type="text" id="nivel" name="nivel" value="<%= lista1.get(0).getNivel() %>"></td>
                            </tr>
                            <tr>
                                <td>Foto:</td>
                                <td><input type="file" id="foto" name="foto" value="<%= lista1.get(0).getFoto() %>"></td>
                            </tr>
                            <tr>
                                <td>PDF:</td>
                                <td><input type="file" id="pdf" name="pdf" value="<%= lista1.get(0).getPdf() %>"></td>
                            </tr>
                            <tr>
                                <td>Autor:</td>
                                <td><input type="text" id="autor" name="autor" value="<%= lista1.get(0).getAutor()%>"></td>
                            </tr>
                            <tr>
                                <td>Correo:</td>
                                <td><input type="text" id="correo" name="correo" value="<%= lista1.get(0).getAutor()%>"></td>
                            </tr>
                            <tr>
                                <td>Eliminado:</td>
                                <td>
                                    <select name="eliminado" id="eliminado">
                                        <option value="" selected></option> 
                                        <option value="0" <%if(lista1.get(0).getEliminado().equalsIgnoreCase("0")){out.print("Selected");} %>>NO</option> 
                                        <option value="1" <%if(lista1.get(0).getEliminado().equalsIgnoreCase("1")){out.print("Selected");} %>>SI</option> 
                                    </select>                                                                        
                                </td>
                            </tr>
                            <tr>
                                <td>ID Usuario:</td>
                                <td><input type="text" id="u_codigo" name="u_codigo" disabled value="<%= lista1.get(0).getCodigo_libro() %>"></td>
                                <input type="hidden" id="u_codigo1" name="u_codigo1" value="<%= lista1.get(0).getCodigo_libro()  %>">
                            </tr>
                            <tr>
                                <input type="hidden" id="operacion" name="operacion" value="delete">
                                <td><input type="submit" value="Eliminar"></td>
                                <td><a href="servletLibro?destino=Listar">Regresar</a></td>
                            </tr>
                        </table>
                    </form>
                </td>
            </tr>
        </table>

    </body>
</html>
