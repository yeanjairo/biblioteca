/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.BeansLibro;
import config.Conexion;
import interfaces.InterfazLibro;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Windows 10
 */
public class DaoLibro implements InterfazLibro{
    Conexion con;
    Connection conexion;
    BeansLibro l;
    private PreparedStatement pst;
    private ResultSet rs;

    public DaoLibro() throws SQLException, IOException{
        this.con=new Conexion();
    }
    
    @Override
    public List ListarLibros() throws SQLException{
        String sql="SELECT * FROM libro";
        try{
            conexion = con.getConexion();
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();
            List<BeansLibro> lista = new ArrayList<>();
            
            while(rs.next()){
                l = new BeansLibro();
                l.setCodigo_libro(rs.getInt(1));
                l.setTitulo(rs.getString(2));
                l.setAño(rs.getString(3));
                l.setNivel(rs.getString(4));
                l.setFoto(rs.getBinaryStream(5));
                l.setPdf(rs.getBinaryStream(6));
                l.setAutor(rs.getString(7));
                l.setCorreo(rs.getString(8));
                l.setEliminado(rs.getString(9));
                l.setId_Usuario(rs.getInt(10));
                lista.add(l);
            }
            pst.close();
            rs.close();
            conexion.close();
            return lista;
        }catch(SQLException e){
            throw e;
        }
    }
    /*
    public void listarImg(int id, HttpServletResponse response){
        String sql = "select * from libro where Id = " +id;
        
        InputStream input = null;
        OutputStream out = null;
        BufferedInputStream bufferedI = null;
        BufferedOutputStream bufferedO = null;
        response.setContentType("image/*");
        try{
            conexion = con.getConexion();
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                input = rs.getBinaryStream("Foto");
                
            }
            bufferedI = new BufferedInputStream(input);
            bufferedO = new BufferedOutputStream(out);
            
            int i = 0;
            while((i=bufferedI.read()) != -1){
                bufferedO.write(i);
            }
        }catch(Exception e){
            
        }
    }
    */
    public void IngresarLibro(BeansLibro l)throws SQLException{
        try{
            String sql = "INSERT into libro(codigo_libro, titulo, año, nivel, foto, pdf, autor, correo, eliminado, Id_Usuario)"
                     +" values(?,?,?,?,?,?,?,?,?,?)";
            conexion = con.getConexion();
            pst = conexion.prepareStatement(sql);
            pst.setInt(1, l.getCodigo_libro());
            pst.setString(2, l.getTitulo());
            pst.setString(3, l.getAño());
            pst.setString(4, l.getNivel());
            pst.setBlob(5, l.getFoto());
            pst.setBlob(6, l.getPdf());
            pst.setString(7, l.getAutor());
            pst.setString(8, l.getCorreo());
            pst.setString(9, l.getEliminado());
            pst.setInt(10, l.getId_Usuario());
            pst.executeUpdate();
        }catch(SQLException e){
            throw e;
        }
    }
    
    public int ContarLibros() throws SQLException{
        int t = 0;
        String sql = "select count(*) as t from libro";    
        try{
            conexion = con.getConexion();
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                t = rs.getInt(1);
            }
        }catch(SQLException e){
            throw e;
        }
        return t;
    }
    
    public void listarImg(int id, HttpServletResponse response){
        String sql = "SELECT * FROM libro WHERE codigo_libro = " +id;
        
        InputStream input = null;
        OutputStream out = null;
        BufferedInputStream bufferedI = null;
        BufferedOutputStream bufferedO = null;
        response.setContentType("image/*");
        try{
            out = response.getOutputStream();
            conexion = con.getConexion() ;
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                input = rs.getBinaryStream("foto");   
            }
            bufferedI = new BufferedInputStream(input);
            bufferedO = new BufferedOutputStream(out);
            
            int i = 0;
            while((i=bufferedI.read()) != -1){
                bufferedO.write(i);
            }
        }catch(Exception e){
            
        }
    }
    
    public void ListarPDF(int id, HttpServletResponse response){
        String sql = "SELECT * FROM libro WHERE codigo_libro=" +id;
        
        
        try{
            ServletOutputStream sos;
            response.setContentType("application/pdf");
            response.setHeader("Content-disposition","inline; filename="+id+".pdf" );
            sos = response.getOutputStream();
            
            conexion = con.getConexion() ;
            pst = conexion.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next())
                    sos.write(rs.getBytes("pdf"));
            else
                return;
            sos.flush();
            sos.close();
        }catch(Exception e){
            
        }
        
        
    }
    
    public static void main(String[] args) throws SQLException, IOException {
        DaoLibro bl = new DaoLibro();
        int t=bl.ContarLibros();
        System.out.println("total="+t);
        
    }

  
}
