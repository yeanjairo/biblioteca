/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Windows 10
 */
public interface InterfazUsuario {
    public List IniciarSesion(String usuario, String clave) throws SQLException;
}
