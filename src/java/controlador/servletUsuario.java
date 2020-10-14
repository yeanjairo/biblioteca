/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import beans.BeansUsuario;
import dao.DaoUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Windows 10
 */
@WebServlet(name = "servletUsuario", urlPatterns = {"/servletUsuario"})
public class servletUsuario extends HttpServlet {
    
    String salir = "salir.jsp";
    String inicio = "menuUsuario/menuUsuario.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String recibe = request.getParameter("destino");
        if(recibe.equalsIgnoreCase("salir")){
            acceso = salir;
        }
        
        
        if(recibe.equalsIgnoreCase("inicio")){
            acceso = inicio;
        }
        RequestDispatcher destino=request.getRequestDispatcher(acceso);
        destino.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection cnx = null;
        String u = request.getParameter("usuario");
        String c = request.getParameter("clave");
        
        int cu = 0, cc = 0;
        cu = u.trim().length();
        cc = c.trim().length();
        
        if((cu==0) || (cc==0)){
            RequestDispatcher destino = request.getRequestDispatcher("index.jsp");
            destino.forward(request, response);
        }else{
            try{
                DaoUsuario objU = new DaoUsuario();
                List<BeansUsuario> lista = objU.IniciarSesion(u, c);
                int total;
                total = lista.size();
                if(total == 1){
                    String tipo, nombre;
                    tipo = lista.get(0).getTipo();
                    nombre = lista.get(0).getNombre();
                    
                    HttpSession mysession = request.getSession(true);
                    mysession.setAttribute("n", nombre);
                    mysession.setAttribute("t", tipo);
                    
                    if(tipo.equals("A")){
                        RequestDispatcher destino = request.getRequestDispatcher("menuUsuario/menuUsuario.jsp?cadena="+nombre+ "-"+tipo);
                        destino.forward(request, response);
                    }else{
                        RequestDispatcher destino=request.getRequestDispatcher("index.jsp");
                        destino.forward(request, response);
                    }
                }else{
                    RequestDispatcher destino=request.getRequestDispatcher("index.jsp");
                    destino.forward(request, response);
                }
            }catch(SQLException ex){
                Logger.getLogger(servletUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
