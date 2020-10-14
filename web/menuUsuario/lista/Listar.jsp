<%-- 
    Document   : listar
    Created on : 06/10/2020, 08:34:30 PM
    Author     : Windows 10
--%>

<%@page import="java.io.ByteArrayInputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="org.apache.tomcat.util.http.fileupload.IOUtils"%>
<%@page import="dao.DaoLibro"%>
<%@page import="beans.BeansLibro"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="beans.BeansUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
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
        
        <table align="center" border="2">
            <tr>
                <td>
                    <div>
                        <ul class="nav">
                            <li><a href="servletUsuario?destino=inicio">Inicio</a></li>
                            <li><a href="servletLibro?destino=Listar">Listar</a></li> 
                            <li><a>Mantenimiento</a>
                                <ul>
                                    <li><a href="servletLibro?destino=Add">Registrar Libros</a></li>
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
        
        <table align="center" border="4">
            <tr align="center">
                <td>CÓDIGO</td>
                <td>TÍTULO</td>
                <td>AÑO</td>
                <td>NIVEL</td>
                <td>FOTO</td>
                <td>PDF</td>
                <td>AUTOR</td>
                <td>CORREO</td>
                <td>ELIMINADO</td>
                <td>ID USUARIO</td>
                <td colspan="2">Acciones</td>
                <td></td>
            </tr>
            <% 
                DaoLibro l=new DaoLibro();
                List<BeansLibro> lista1 = l.ListarLibros() ;      
                int t;
       
                try{
                    if(lista1.isEmpty()){
                        t=0;
                    }else{
                        t=lista1.size();
                    }
                    int i=0;
                    if(t>0){
                        while(i<t){
            %>
            <tr align="center">
                <td> <%= lista1.get(i).getCodigo_libro() %> </td>
                <td> <%= lista1.get(i).getTitulo() %> </td>
                <td> <%= lista1.get(i).getAño() %> </td>
                <td> <%= lista1.get(i).getNivel() %> </td>
                
                <td><img src="servletImagen?id=<%=lista1.get(i).getCodigo_libro()%>" width="300" height="200"></td>
                
                <td> <%= lista1.get(i).getPdf() %> </td>
                <td> <%= lista1.get(i).getAutor() %> </td>
                <td> <%= lista1.get(i).getCorreo() %> </td>
                <td> <%= lista1.get(i).getEliminado() %> </td>
                <td> <%= lista1.get(i).getId_Usuario() %> </td>
                <td colspan="2"><a></a>Editar</td>
                <td><a></a>Eliminar</td>
            </tr>
            
            <%
                i=i+1;
                }
            }
       }catch(Exception e){
       
       }     
%>
       
        </table>
    </body>
</html>
