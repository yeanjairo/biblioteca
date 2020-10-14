/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DaoLibro;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Windows 10
 */
@WebServlet(name = "servletpdf", urlPatterns = {"/servletpdf"})
public class servletpdf extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletpdf</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletpdf at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            int bookId = Integer.parseInt(request.getParameter("codigoLibro"));
            DaoLibro dao = new DaoLibro();
            dao.ListarPDF(bookId, response);
        } catch (SQLException ex) {
            Logger.getLogger(servletImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*
        String bookId = request.getParameter("codigoLibro")!=null?request.getParameter("codigoLibro"):"NA";
        ServletOutputStream sos;
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition","inline; filename="+bookId+".pdf" );
        sos = response.getOutputStream();
        */
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
