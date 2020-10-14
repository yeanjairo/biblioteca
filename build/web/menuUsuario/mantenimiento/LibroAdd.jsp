<%-- 
    Document   : UsuarioAad
    Created on : 06/10/2020, 12:22:08 PM
    Author     : Windows 10
--%>
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
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="stylo/stylomenu.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar libros</title>
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
        
        <br><!-- comment -->
        <br> 
        
        <table align="center">
            <tr>
                <td align="center">
                    <form action="servletLibro" method="post" enctype="multipart/form-data">
                        <table>
                            <!--
                            <tr>
                                <td>Código:</td>
                                <td><input type="text" id="codigo" name="codigo"></td>
                            </tr>
                            -->
                            <tr>
                                <td>Título:</td>
                                <td><input type="text" id="titulo" name="titulo"></td>
                            </tr>
                            <tr>
                                <td>Año:</td>
                                <td><input type="text" id="year" name="year"></td>
                            </tr>
                            <tr>
                                <td>Nivel:</td>
                                <td><input type="text" id="nivel" name="nivel"></td>
                            </tr>
                            <tr>
                                <td>Foto:</td>
                                <td><input type="file" id="foto" name="foto"></td>
                            </tr>
                            <tr>
                                <td>PDF:</td>
                                <td><input type="file" id="pdf" name="pdf"></td>
                            </tr>
                            <tr>
                                <td>Autor:</td>
                                <td><input type="text" id="autor" name="autor"></td>
                            </tr>
                            <tr>
                                <td>Correo:</td>
                                <td><input type="text" id="correo" name="correo"></td>
                            </tr>
                            <tr>
                                <td>Eliminado:</td>
                                <td>
                                    <select name="eliminado" id="eliminado">
                                        <option value="" selected></option> 
                                        <option value="0">NO</option> 
                                        <option value="1">SI</option>
                                    </select>                                                                        
                                </td>
                            </tr>
                            <tr>
                                <td>Id Usuario:</td>
                                <td><input type="text" id="Id_Usuario" name="Id_Usuario"></td>
                            </tr>
                            <tr>
                                
                                <td><input type="submit" value="Registrar"></td>
                                <input type="hidden" id="operacion" name="operacion" value="LibroAdd">
                                <td><input type="reset" value="Reset"></td>
                                <td><a href="servletUsuario?destino=inicio">Regresar</a></td>
                            </tr>
                        </table>
                    </form>
                </td>
            </tr>
        </table>
        
    </body>
</html>
