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
 * @author Jordan Oxalc Vásquez Fernández 10-18-2021
 */
public class clsProducto {

    clsJDBCConexion objConexion = new clsJDBCConexion();
    String strSQL;
    ResultSet rs = null;

    public Integer generarCodigoProducto() throws Exception {
        strSQL = "select coalesce(max(codProducto),0)+1 as codigo from producto";

        try {
            rs = objConexion.consultarBD(strSQL);
            if (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (Exception e) {
            throw new Exception("Error al generar código del producto!");
        }
        return 0;
    }

    public ResultSet listarProductos() throws Exception {
        strSQL = "select p.*,c.nombre as categoria,m.nombre as marca from producto p "
                + "inner join categoria c on p.codcategoria = c.codcategoria "
                + "inner join marca m  on p.codmarca = m.codmarca";

        try {
            rs = objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar producto");
        }

    }

    public ResultSet buscarProducto(Integer cod) throws Exception {
        strSQL = "select p.*,c.nombre as categoria,m.nombre as marca from producto p "
                + "inner join categoria c on p.codcategoria = c.codcategoria "
                + "inner join marca m  on p.codmarca = m.codmarca where codProducto=" + cod + "";

        try {
            rs = objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar producto");
        }

    }
    public ResultSet buscarProductos(String nombre) throws Exception {
        strSQL = "select p.*,c.nombre as categoria,m.nombre as marca from producto p "
                + "inner join categoria c on p.codcategoria = c.codcategoria "
                + "inner join marca m  on p.codmarca = m.codmarca where p.nombre like '"+ nombre + "%'";

        try {
            rs = objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar producto");
        }

    }
    
      public ResultSet buscarProductosCategoria(String categoria) throws Exception {
        strSQL = "select p.*,c.nombre as categoria,m.nombre as marca from producto p "
                + "inner join categoria c on p.codcategoria = c.codcategoria "
                + "inner join marca m  on p.codmarca = m.codmarca where c.nombre = '"+ categoria + "'";

        try {
            rs = objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar producto");
        }

    }

    public ResultSet listarProductosVigentes() throws Exception {
        strSQL = "select * from producto where vigencia=true";

        try {
            rs = objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar productos vigentes");
        }

    }

    public void registrarProducto(Integer cod, String nom, String des, Double precioV, Double precioC, Integer stock, Boolean vigencia, String fechaV, Integer codMarca, Integer codCategoria) throws Exception {

        strSQL = "INSERT INTO producto (codproducto, nombre, descripcion, precioventa, preciocompra, stock, vigencia, fechavencimiento, codmarca, codcategoria) "
                + " VALUES (" + cod + ", '" + nom + "', '" + des + "', " + precioV + ", " + precioC + ", " + stock + ", " + vigencia + ", '" + fechaV + "', " + codMarca + ", " + codCategoria + ");";
        try {
            objConexion.ejecutarBD(strSQL);

        } catch (Exception e) {
            throw new Exception("Error al registrar producto");
        }

    }

    public void modificarProducto(Integer cod, String nom, String des, Double precioV, Double precioC, Integer stock, Boolean vigencia, String fechaV, Integer codMarca, Integer codCategoria) throws Exception {

        strSQL = "UPDATE producto SET  nombre='" + nom + "', descripcion='" + des + "', precioventa=" + precioV + ", preciocompra=" + precioC + ", stock=" + stock + ", vigencia=" + vigencia + ", fechavencimiento='" + fechaV + "', codmarca=" + codMarca + ", codcategoria= " + codCategoria + ""
                + " WHERE codproducto=" + cod + ";";
        try {
            objConexion.ejecutarBD(strSQL);

        } catch (Exception e) {
            throw new Exception("Error al modificar producto");
        }

    }

    public void eliminarProducto(Integer cod) throws Exception {
        strSQL = " DELETE FROM producto WHERE codProducto=" + cod + ";";

        try {
            objConexion.ejecutarBD(strSQL);

        } catch (Exception e) {
            throw new Exception("Error al eliminar producto");
        }

    }

    public void darBajaProducto(Integer cod) throws Exception {
        strSQL = "UPDATE producto SET vigencia=false WHERE codProducto=" + cod + ";";

        try {
            objConexion.ejecutarBD(strSQL);

        } catch (Exception e) {
            throw new Exception("Error al eliminar producto");
        }

    }
}
