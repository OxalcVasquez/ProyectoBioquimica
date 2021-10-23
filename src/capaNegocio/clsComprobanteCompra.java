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
 * @author Emily Alvarado
 */
public class clsComprobanteCompra {
     clsJDBCConexion objConexion = new clsJDBCConexion();
    String strSQL;
    ResultSet rs = null;
    
    public ResultSet listarComprobanteCompra() throws Exception {
        strSQL = "select * from comprobanteCompra";

        try {
            rs = objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar comprobante compra");
        }

    }
    
    public void registrarComprobanteCompra(Integer codC,String numC,String tipo,Double total,String fecha, String ruc) throws Exception {
        strSQL = "INSERT INTO comprobanteCompra(codcomprobante,numcomprobante,tipo,total,fecha,rucproveedor) VALUES (" + codC + ", '" + numC + "','" + tipo + "'," + total + ",'" + fecha + "', '" + ruc + "');";

        try {
            objConexion.ejecutarBD(strSQL);

        } catch (Exception e) {
            throw new Exception("Error al registrar comprobante compra");
        }

    }

     public void modificarComprobanteCompra(Integer codC,String numC,String tipo,Double total,String fecha, String ruc) throws Exception {
        strSQL = " UPDATE comprobanteCompra SET  numcomprobante='" + numC+ "',tipo='" + tipo + "',total=" + total + ",fecha='" + fecha + "',rucproveedor=" + ruc + " WHERE codcomprobante=" + codC + ";";

        try {
            objConexion.ejecutarBD(strSQL);

        } catch (Exception e) {
            throw new Exception("Error al modificar comprobante compra");
        }

    }
     
      public void eliminarComprobanteCompra(Integer codC) throws Exception {
        strSQL = " DELETE FROM comprobanteCompra WHERE codcomprobante=" + codC + ";";

        try {
            objConexion.ejecutarBD(strSQL);

        } catch (Exception e) {
            throw new Exception("Error al eliminar comprobante compra");
        }

    }
}
