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
 * @author LENOVO
 */
public class clsComprobanteVenta {
    clsJDBCConexion objConexion = new clsJDBCConexion();
    String strSQL;
    ResultSet rs = null;
    
    public ResultSet listarComprobanteVenta() throws Exception {
        strSQL = "select * from comprobanteVenta";

        try {
            rs = objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar comprobante venta");
        }

    }
    
    public void registrarComprobanteVenta(String numcomprobante,String tipo,Double igv,Double total,String fecha,Integer codcliente,Integer codtrabajador) throws Exception {
        strSQL = "INSERT INTO comprobanteVenta(numcomprobante,tipo,igv,total,fecha,hora,codcliente,codtrabajador) VALUES (" + numcomprobante + ", '" + tipo + "'," + igv + "," + total + ",'" + fecha + "',current_time," + codcliente + ", " + codtrabajador + ");";

        try {
            objConexion.ejecutarBD(strSQL);

        } catch (Exception e) {
            throw new Exception("Error al registrar comprobante venta");
        }

    }

     public void modificarComprobanteVenta(String numcomprobante,String tipo,Double igv,Double total,String fecha,Integer codcliente,Integer codtrabajador) throws Exception {
        strSQL = " UPDATE comprobanteVenta SET  tipo='" + tipo + "',igv=" + igv + ",total=" + total + ",fecha='" + fecha + "',codcliente=" + codcliente + ", codtrabajador= " + codtrabajador + " WHERE numcomprobante=" + numcomprobante + ";";

        try {
            objConexion.ejecutarBD(strSQL);

        } catch (Exception e) {
            throw new Exception("Error al modificar comprobante venta");
        }

    }
     
      public void eliminarComprobanteVenta(String numcomprobante) throws Exception {
        strSQL = " DELETE FROM comprobanteVenta WHERE numcomprobante='" + numcomprobante + "';";

        try {
            objConexion.ejecutarBD(strSQL);

        } catch (Exception e) {
            throw new Exception("Error al eliminar comprobante venta");
        }

    }
}
