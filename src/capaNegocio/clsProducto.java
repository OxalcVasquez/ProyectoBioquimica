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
 * @author Jordan Oxalc Vásquez Fernández 10-18-2021
 */
public class clsProducto {

    clsJDBCConexion objConexion = new clsJDBCConexion();
    String strSQL;
    ResultSet rs = null;
    Connection con;
    CallableStatement cs = null;

    public Integer generarCodigoProducto() throws Exception {
        strSQL = "select f_generar_codproducto();";

        try {
            rs = objConexion.consultarBD(strSQL);
            if (rs.next()) {
                return rs.getInt("f_generar_codproducto");
            }
        } catch (Exception e) {
            throw new Exception("Error al generar código del producto!");
        }
        return 0;
    }

    public ResultSet listarProductos() throws Exception {
        strSQL = "select * from f_listarProductos(); 				";

        try {
            rs = objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar producto");
        }

    }

    public ResultSet buscarProducto(Integer cod) throws Exception {
        strSQL = "select * from f_buscarProducto(" + cod + ")";

        try {
            rs = objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar producto");
        }

    }

    public ResultSet buscarProductos(String nombre) throws Exception {
        strSQL = "select * from f_buscarProductosNombres('"+nombre+"')";

        try {
            rs = objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar productos");
        }

    }

    public ResultSet buscarProductosCategoria(String categoria) throws Exception {
        strSQL = "select * from f_buscarProductosCategoria('" + categoria + "')";

        try {
            rs = objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar productos por categoria");
        }

    }
    
     public ResultSet buscarProductosMarca(String marc) throws Exception {
        strSQL = "select * from f_buscarProductosMarca('" + marc + "')";

        try {
            rs = objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar productos por marca");
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

    public Boolean verificarProductoEnVenta(Integer cod) throws Exception {
        strSQL = "{ ? = call f_verificar_venta_productos(?)}";
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

    public Boolean verificarStock(Integer cod) throws Exception {
        strSQL = "{ ? = call f_verificar_stock_producto(?)}";
        try {
            objConexion.conectarBD(); //ConectaBd
            con = objConexion.getCon(); //Jala Conexión de CapaDatos
            cs = con.prepareCall(strSQL);//Prepara la función
            cs.setInt(2, cod);
            cs.registerOutParameter(1, Types.BOOLEAN);
            cs.executeUpdate();
            return cs.getBoolean(1);
        } catch (Exception e) {
            throw new Exception("Error al verificar stock producto");
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
