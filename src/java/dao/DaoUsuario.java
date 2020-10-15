/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.BeansUsuario;
import config.Conexion;
import interfaces.InterfazUsuario;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Windows 10
 */
public class DaoUsuario implements InterfazUsuario{
    Conexion con;
    Connection conexion;
    BeansUsuario u;
    private PreparedStatement pst;
    private ResultSet rs;

    public DaoUsuario() throws SQLException, IOException{
        this.con=new Conexion();
    }
    
    @Override
    public List IniciarSesion(String usuario, String clave) throws SQLException{
        String sql="SELECT * FROM usuario WHERE usuario=? and clave=? and borrado = '0'";
        try{
            conexion = con.getConexion();
            pst = conexion.prepareStatement(sql);
            pst.setString(1, usuario);
            pst.setString(2, clave);
            rs = pst.executeQuery();
            List<BeansUsuario> lista = new ArrayList<>();
            
            while(rs.next()){
                u = new BeansUsuario();
                u.setId_Usuario(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setCargo(rs.getString(3));
                u.setUsuario(rs.getString(4));
                u.setClave(rs.getString(5));
                u.setTipo(rs.getString(6));
                u.setBorrado(rs.getString(7));
                lista.add(u);
            }
            pst.close();
            rs.close();
            conexion.close();
            return lista;
        }catch(SQLException e){
            throw e;
        }
    }
    
    public List BuscarUsuarioPorId_Usuario(int Id_Usuario) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE Id_Usuario=?";
        try {
            conexion = con.getConexion();
            pst = conexion.prepareStatement(sql);
            pst.setInt(1, Id_Usuario);
            rs = pst.executeQuery();
            List<BeansUsuario> lista = new ArrayList<>();
            while (rs.next()) {
                u = new BeansUsuario();
                u.setId_Usuario(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setCargo(rs.getString(3));
                u.setUsuario(rs.getString(4));
                u.setClave(rs.getString(5));
                u.setTipo(rs.getString(6));
                u.setBorrado(rs.getString(7));
                lista.add(u);
            }
            pst.close();
            rs.close();
            conexion.close();
            return lista;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    /*
    public static void main(String[] args) throws SQLException, IOException {
        DaoUsuario bu = new DaoUsuario();
        List<BeansUsuario> beansU = bu.IniciarSesion("BIBLIOTECARIO", "BIBLIOTECA");
        int i = 0;
        int t = beansU.size();
        while(i<=t-1){
            System.out.println(beansU.get(i).getId_Usuario() + " - " + beansU.get(i).getNombre());
            i++;
        }
        
    }
    */
}
