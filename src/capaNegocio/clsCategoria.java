/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaNegocio;

import capaDatos.clsJDBCConexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;

/**
 *
 * @author Jordan Oxalc Vásquez Fernández
 */
public class clsCategoria {

    clsJDBCConexion objConexion = new clsJDBCConexion();
    String strSQL;
    ResultSet rs = null;
      Connection con;
    CallableStatement cs = null;


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
    
     public Boolean verificarNumProductosCategoria(Integer cod) throws Exception {
        strSQL = "{ ? = call f_verificar_numproductos_categoria(?)}";
        try {
            objConexion.conectarBD(); //ConectaBd
            con = objConexion.getCon(); //Jala Conexión de CapaDatos
            cs = con.prepareCall(strSQL);//Prepara la función
            cs.setInt(2, cod);
            cs.registerOutParameter(1, Types.BOOLEAN);
            cs.executeUpdate();
            return cs.getBoolean(1);
        } catch (Exception e) {
            throw new Exception("Error al verificar el producto");
        }
    }
     public Integer obtenerCodigoCategoria(String nombre) throws Exception {
        strSQL = "select codCategoria from categoria where nombre='"+nombre+"'";

        try {
            rs = objConexion.consultarBD(strSQL);
            if (rs.next()) {
                return rs.getInt("codCategoria");
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener codigo de categoria!");
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
        strSQL = "select pa_registrarCategoria(" + cod + ", '" + nombre + "', " + vigencia + ");";

        try {
            objConexion.consultarBD(strSQL);

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
