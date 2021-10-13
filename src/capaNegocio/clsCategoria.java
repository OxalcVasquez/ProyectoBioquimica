/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaNegocio;

import capaDatos.clsJDBCConexion;
import java.sql.ResultSet;

/**
 *
 * @author Jordan Oxalc Vásquez Fernández
 */
public class clsCategoria {

    clsJDBCConexion objConexion = new clsJDBCConexion();
    String strSQL;
    ResultSet rs = null;

    public Integer generarCodigoCategoria() throws Exception {
        strSQL = "select coalesce(max(codCategoria),0)+1 as codigo from categoria";

        try {
            rs = objConexion.consultarBD(strSQL);
            if (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (Exception e) {
            throw new Exception("Error al generar código de la categoria!");
        }
        return 0;
    }

    public ResultSet listarCategorias() throws Exception {
        strSQL = "select * from categoria";

        try {
            rs = objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar categoria");
        }

    }
    
      public ResultSet buscarCategoria(Integer cod) throws Exception {
        strSQL = "select * from categoria where codcategoria=" + cod + "";

        try {
            rs = objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar categoria");
        }

    }

    public ResultSet listarCategoriasVigentes() throws Exception {
        strSQL = "select * from categoria where vigencia=true";

        try {
            rs = objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar categorias vigentes");
        }

    }
    
    public void registrarCategoria(Integer cod, String nombre, Boolean vigencia) throws Exception {
        strSQL = "INSERT INTO categoria(codcategoria, nombre, vigencia) VALUES (" + cod + ", '" + nombre + "', " + vigencia + ");";

        try {
            objConexion.ejecutarBD(strSQL);

        } catch (Exception e) {
            throw new Exception("Error al registrar categoria");
        }

    }

     public void modificarCategoria(Integer cod, String nombre, Boolean vigencia) throws Exception {
        strSQL = " UPDATE categoria SET  nombre='" + nombre + "', vigencia= " + vigencia + " WHERE codcategoria=" + cod + ";";

        try {
            objConexion.ejecutarBD(strSQL);

        } catch (Exception e) {
            throw new Exception("Error al modificar categoria");
        }

    }
     
      public void eliminarCategoria(Integer cod) throws Exception {
        strSQL = " DELETE FROM categoria WHERE codcategoria=" + cod + ";";

        try {
            objConexion.ejecutarBD(strSQL);

        } catch (Exception e) {
            throw new Exception("Error al eliminar categoria");
        }

    }
      
         public void darBajaCategoria(Integer cod) throws Exception {
        strSQL = "UPDATE  categoria SET vigencia=false WHERE codcategoria=" + cod + ";";

        try {
            objConexion.ejecutarBD(strSQL);

        } catch (Exception e) {
            throw new Exception("Error al eliminar categoria");
        }

    }
     
     
}
