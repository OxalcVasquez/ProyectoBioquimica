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
import java.util.ArrayList;

/**
 *
 * @author Emily Alvarado
 */
public class clsComprobanteCompra {
     clsJDBCConexion objConexion = new clsJDBCConexion();
    String strSQL;
    ResultSet rs = null;
       Connection con;
    CallableStatement cs = null;
    
    public Integer generarCodigoCCompra() throws Exception {
        strSQL = "select f_codCompra();";
        try {
            objConexion.conectarBD();
            con = objConexion.getCon();
            cs = con.prepareCall(strSQL);
            rs = cs.executeQuery();
            if (rs.next()) {
                return rs.getInt("f_codCompra");
            }
        } catch (Exception e) {
            throw new Exception("Error al generar código de la compra");

        } finally {
            objConexion.desconectarBD();
            cs.close();
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

     public void modificarComprobanteCompra(Integer codC,String numC,String tipo,Double total,String fecha, String ruc, ArrayList Detalle, ArrayList detalleModificado) throws Exception {
        //strSQL = " UPDATE comprobanteCompra SET  numcomprobante='" + numC+ "',tipo='" + tipo + "',total=" + total + ",fecha='" + fecha + "',rucproveedor=" + ruc + " WHERE codcomprobante=" + codC + ";";

        ArrayList consultas = new ArrayList();

        for (int i = 0; i < Detalle.size(); i++) {
            Object[] datos = (Object[]) Detalle.get(i);
            consultas.add((String) "UPDATE producto set stock=stock-" + datos[2] + " where codproducto=" + datos[4]);
            consultas.add((String) "DELETE FROM  detallecompra where codcomprobante=" + codC);

        }

        consultas.add((String) "DELETE FROM  comprobanteCompra where codcomprobante=" + codC);

        consultas.add((String) "INSERT INTO comprobanteCompra(codcomprobante,numcomprobante,tipo,total,fecha,rucproveedor) "
                + "	VALUES (" + codC + ", '" + numC + "','" + tipo + "'," + total + ",'" + fecha + "', '" + ruc + "');");

        for (int i = 0; i < detalleModificado.size(); i++) {
            Object[] datos = (Object[]) detalleModificado.get(i);
            consultas.add((String) "INSERT INTO detalleCompra(cantidad, precio, codcomprobante, codproducto) VALUES (" + datos[2] + "," + datos[1] + ", " + codC + ", " + datos[4] + ")");
            consultas.add((String) "UPDATE producto set stock=stock+" + datos[2] + " where codproducto=" + datos[4]);

        }
        try {
            objConexion.ejecutartBDTransacciones(consultas);

        } catch (Exception e) {
            throw new Exception(e);
        }

    }
     
      public void eliminarComprobanteCompra(Integer codC, ArrayList Detalle) throws Exception {
        //strSQL = " DELETE FROM comprobanteCompra WHERE codcomprobante=" + codC + ";";

        ArrayList consultas = new ArrayList();

        for (int i = 0; i < Detalle.size(); i++) {
            Object[] datos = (Object[]) Detalle.get(i);
            consultas.add((String) "UPDATE producto set stock=stock-" + datos[2] + " where codproducto=" + datos[4]);
            consultas.add((String) "DELETE FROM  detallecompra where codcomprobante=" + codC);

        }

        consultas.add((String) "DELETE FROM  comprobanteCompra WHERE codcomprobante=" + codC);

        try {
            objConexion.ejecutartBDTransacciones(consultas);

        } catch (Exception e) {
            throw new Exception(e);
        }

    }
      
      public ResultSet buscarCompra (Integer cod) throws Exception {
        strSQL = "select C.* ,P.razonsocial  from comprobanteCompra C inner join proveedor P on p.ruc=C.rucproveedor\n" +
" WHERE codcomprobante= "+cod+"";

        try {
            rs = objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar compra");
        }

    }
      
         
}
