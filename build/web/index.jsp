
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="stylo/style_login.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <section class="form-login">
            <h5>FARMACIA</h5>

            <form action="servletUsuario" method="post">
                
                    <tr>
                        <td>Usuario:</td>
                        <td><input class = "controls" type="text" name="usuario" id="usuario" placeholder="usuario"></td>
                    </tr>
                    <tr>
                        <td>Clave:</td>
                        <td><input class = "controls" type="password" name="clave" id="clave" placeholder="ingrese su contraseña"></td>
                    </tr>
                    <tr colspan="2">
                        <td><input class = "buttoms" type="submit" name="enviar" id="enviar" value="Enviar"></td>
                        <td><input class = "buttoms" type="reset" name="cancelar" id="cancelar" value="Cancelar"></td> 
                    </tr> 
                
                
            </form>
        </section>
    </body>
</html>
