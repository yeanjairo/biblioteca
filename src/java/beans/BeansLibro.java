/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.InputStream;

/**
 *
 * @author Windows 10
 */
public class BeansLibro {
    int codigo_libro;
    String titulo;
    String año;
    String nivel;
    InputStream foto;
    InputStream pdf;
    String autor;
    String correo;
    String eliminado;
    int Id_Usuario;

    public BeansLibro() {
    }

    public BeansLibro(int codigo_libro, String titulo, String año, String nivel, InputStream foto, InputStream pdf, String autor, String correo, String eliminado, int Id_Usuario) {
        this.codigo_libro = codigo_libro;
        this.titulo = titulo;
        this.año = año;
        this.nivel = nivel;
        this.foto = foto;
        this.pdf = pdf;
        this.autor = autor;
        this.correo = correo;
        this.eliminado = eliminado;
        this.Id_Usuario = Id_Usuario;
    }

    public int getCodigo_libro() {
        return codigo_libro;
    }

    public void setCodigo_libro(int codigo_libro) {
        this.codigo_libro = codigo_libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

    public InputStream getPdf() {
        return pdf;
    }

    public void setPdf(InputStream pdf) {
        this.pdf = pdf;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEliminado() {
        return eliminado;
    }

    public void setEliminado(String eliminado) {
        this.eliminado = eliminado;
    }

    public int getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(int Id_Usuario) {
        this.Id_Usuario = Id_Usuario;
    }
    
    
    
}
