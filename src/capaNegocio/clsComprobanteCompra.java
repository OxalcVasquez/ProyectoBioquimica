/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaNegocio;

import capaDatos.clsJDBCConexion;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Emily Alvarado
 */
public class clsComprobanteCompra {
     clsJDBCConexion objConexion = new clsJDBCConexion();
    String strSQL;
    ResultSet rs = null;
    
    public Integer generarCodigoCCompra() throws Exception {
        strSQL = "select coalesce(max(codcomprobante),0)+1 as codigo from comprobanteCompra";

        try {
            rs = objConexion.consultarBD(strSQL);
            if (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (Exception e) {
            throw new Exception("Error al generar código de la compra!");
        }
        return 0;
    }
    
    public ResultSet listarComprobanteCompra() throws Exception {
        strSQL = "select C.*, P.razonsocial from comprobanteCompra C inner join proveedor P on p.ruc=C.rucproveedor";

        try {
            rs = objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar comprobante compra");
        }

    }
    public void registrarCompraTran(Integer codC,String numC,String tipo,Double total,String fecha, String ruc, ArrayList Detalle) throws Exception {
        ArrayList consultas = new ArrayList();
        consultas.add((String) "INSERT INTO comprobanteCompra(codcomprobante,numcomprobante,tipo,total,fecha,rucproveedor) VALUES (" + codC + ", '" + numC + "','" + tipo + "'," + total + ",'" + fecha + "', '" + ruc + "');");

        for (int i = 0; i < Detalle.size(); i++) {
            Object[] datos = (Object[]) Detalle.get(i);
            consultas.add((String) "INSERT INTO detalleCompra(cantidad, precio, codcomprobante, codproducto) VALUES (" + datos[2] + "," + datos[1] + ", " + codC + ", " + datos[4] + ")");
            consultas.add((String) "UPDATE producto set stock=stock+" + datos[2] + " where codproducto=" + datos[4]);

        }
        try {
            objConexion.ejecutartBDTransacciones(consultas);

        } catch (Exception e) {
            throw new Exception("Error al registrar la compra");
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
