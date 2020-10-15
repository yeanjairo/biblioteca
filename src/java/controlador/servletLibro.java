/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import beans.BeansLibro;
import beans.BeansUsuario;
import dao.DaoLibro;
import dao.DaoUsuario;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Windows 10
 */
@WebServlet(name = "servletLibro", urlPatterns = {"/servletLibro"})
@MultipartConfig
public class servletLibro extends HttpServlet {

    String agregar = "menuUsuario/mantenimiento/LibroAdd.jsp";
    String listar = "menuUsuario/lista/Listar.jsp";
    String d1 = "menuUsuario/menuUsuario.jsp";
    String actualizar = "menuUsuario/mantenimiento/update.jsp";
    String eliminar = "menuUsuario/mantenimiento/delete.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletLibro</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletLibro at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String recibe = request.getParameter("destino");
        if (recibe.equalsIgnoreCase("Add")) {
            acceso = agregar;
        }

        if (recibe.equalsIgnoreCase("Listar")) {
            acceso = listar;
        }
        
        if(recibe.equalsIgnoreCase("update")){
            acceso = actualizar;
            String Id_Libro=request.getParameter("id_libro");
            request.setAttribute("id_libro", Id_Libro);
            int codigo=Integer.parseInt(Id_Libro);
            try {
                DaoLibro ObjL = new DaoLibro();
                List<BeansLibro> lista = ObjL.BuscarLibroPorId_Libro(codigo) ;
                request.setAttribute("lista", lista);
            }catch (Exception e) {
                
            }
        }
        
        if(recibe.equalsIgnoreCase("delete")){
            acceso = eliminar;
            String Id_Libro=request.getParameter("id_libro");
            request.setAttribute("id_libro", Id_Libro);
            int codigo=Integer.parseInt(Id_Libro);
            try {
                DaoLibro ObjL = new DaoLibro();
                List<BeansLibro> lista = ObjL.BuscarLibroPorId_Libro(codigo) ;
                request.setAttribute("lista", lista);
            }catch (Exception e) {
                
            }
        }

        RequestDispatcher destino = request.getRequestDispatcher(acceso);
        destino.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String operacion = request.getParameter("operacion");

        if (operacion.trim().equalsIgnoreCase("LibroAdd")) {
            //String codigo = request.getParameter("codigo");
            String codigoL = "";
            String titulo = request.getParameter("titulo");
            String año = request.getParameter("year");
            String nivel = request.getParameter("nivel");
            Part foto = request.getPart("foto");
            InputStream inputStream1 = foto.getInputStream();
            Part pdf = request.getPart("pdf");
            InputStream inputStream2 = pdf.getInputStream();
            String autor = request.getParameter("autor");
            String correo = request.getParameter("correo");
            String eliminado = request.getParameter("eliminado");
            String Id_Usuario = request.getParameter("Id_Usuario");

            try {
                DaoLibro objL = new DaoLibro();
                int t = objL.ContarLibros();
                codigoL = Integer.toString(t + 1);

                BeansLibro l = new BeansLibro();
                l.setCodigo_libro(Integer.parseInt(codigoL));
                l.setTitulo(titulo);
                l.setAño(año);
                l.setNivel(nivel);
                l.setFoto(inputStream1);
                l.setPdf(inputStream2);
                l.setAutor(autor);
                l.setCorreo(correo);
                l.setEliminado(eliminado);
                l.setId_Usuario(Integer.parseInt(Id_Usuario));
                objL.IngresarLibro(l);
            } catch (SQLException ex) {
                Logger.getLogger(servletLibro.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (operacion.trim().equalsIgnoreCase("Listar")) {
            try {
                DaoLibro objL = new DaoLibro();
                List<BeansLibro> lista = objL.ListarLibros();
                request.setAttribute("lista", lista);
                RequestDispatcher rd;
                rd = request.getRequestDispatcher(d1);
                rd.forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(servletLibro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(operacion.trim().equalsIgnoreCase("update")){
            String codigo=request.getParameter("codigo1");
            String titulo=request.getParameter("titulo");
            String año=request.getParameter("year");
            String nivel = request.getParameter("nivel");
            Part foto = request.getPart("foto");
            InputStream inputStream1 = foto.getInputStream();
            Part pdf = request.getPart("pdf");
            InputStream inputStream2 = pdf.getInputStream();
            String autor = request.getParameter("autor");
            String correo = request.getParameter("correo");
            String eliminado = request.getParameter("eliminado");
            String id_usuario = request.getParameter("u_codigo1");
            try {
                DaoLibro objL = new DaoLibro();
                BeansLibro l = new BeansLibro();
                
                l.setCodigo_libro(Integer.parseInt(codigo));
                l.setTitulo(titulo);
                l.setAño(año);
                l.setNivel(nivel);
                l.setFoto(inputStream1);
                l.setPdf(inputStream2);
                l.setAutor(autor);
                l.setCorreo(correo);
                l.setEliminado(eliminado);
                l.setId_Usuario(Integer.parseInt(id_usuario));
                objL.actualizar(l);
                
            } catch (SQLException ex) {
                Logger.getLogger(servletLibro.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher destino = request.getRequestDispatcher("menuUsuario/menuUsuario.jsp");
            destino.forward(request, response);
        }
        
        RequestDispatcher destino = request.getRequestDispatcher("menuUsuario/menuUsuario.jsp");
        destino.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
