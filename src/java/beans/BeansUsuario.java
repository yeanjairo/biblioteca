/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Windows 10
 */
public class BeansUsuario {
    int Id_Usuario;
    String nombre;
    String cargo;
    String usuario;
    String clave;
    String tipo;
    String borrado;

    public BeansUsuario() {
    }

    public BeansUsuario(int Id_Usuario, String nombre, String cargo, String usuario, String clave, String tipo, String borrado) {
        this.Id_Usuario = Id_Usuario;
        this.nombre = nombre;
        this.cargo = cargo;
        this.usuario = usuario;
        this.clave = clave;
        this.tipo = tipo;
        this.borrado = borrado;
    }   

    public int getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(int Id_Usuario) {
        this.Id_Usuario = Id_Usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getBorrado() {
        return borrado;
    }

    public void setBorrado(String borrado) {
        this.borrado = borrado;
    }
    
    
}
