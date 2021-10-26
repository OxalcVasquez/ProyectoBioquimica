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
 * @author Jordan Oxalc Vásquez Fernández
 */
public class clsVenta {

    clsJDBCConexion objConexion = new clsJDBCConexion();
    String strSQL;
//    Statement sent;
    ResultSet rs = null;
    Connection con;
    CallableStatement cs = null;

    //Falta validar el stock maximo , stock == 0, validar el numero de comporbamte y tipo,metodos de lista 
    public Integer generarNumVenta() throws Exception {
        strSQL = "select f_generarNumVenta();";
        try {
            objConexion.conectarBD();
            con = objConexion.getCon();
            cs = con.prepareCall(strSQL);
            rs = cs.executeQuery();
            if (rs.next()) {
                return rs.getInt("f_generarNumVenta");
            }
        } catch (Exception e) {
            throw new Exception("Error al ejecutar rla funcion");

        } finally {
            objConexion.desconectarBD();
            cs.close();
        }
        return 0;
    }

    public Boolean verificarVenta(String numcom, String tipo) throws Exception {
        strSQL = "select * from comprobanteventa where numcomprobante='" + numcom + "' and tipo='" + tipo + "'";

        try {
            rs = objConexion.consultarBD(strSQL);
            if (rs.next()) {
                return false;
            }
        } catch (Exception e) {
            throw new Exception("Error al verificar venta");
        }
        return true;
    }

    public ResultSet listarVentas() throws Exception {
        strSQL = "select v.*,c.nombres ||' '|| c.apellidos as cliente,t.nombres ||' '|| t.apellidos as trabajador from comprobanteVenta as v "
                + "inner join trabajador t on v.codtrabajador = t.codtrabajador "
                + "inner join cliente c on v.codcliente = c.codcliente";

        try {
            rs = objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar ventas");
        }

    }

    public ResultSet buscarVenta(Integer numventa) throws Exception {
        strSQL = "select * from comprobanteventa where numventa =" + numventa;

        try {
            rs = objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar ventas");
        }

    }

    public ResultSet buscarDetalleVenta(Integer numventa) throws Exception {
        strSQL = "select D.*, P.nombre as producto from detalleventa D inner join producto P on P.codproducto=D.codproducto "
                + " where numventa=" + numventa;

        try {
            rs = objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar ventas");
        }

    }

    public void registrarVenta(Integer num, String numcom, String tipo, Double igv, Double subtotal, Double total, String fecha, String hora, Integer codcli, Integer codtra, ArrayList Detalle) throws Exception {
        ArrayList consultas = new ArrayList();
        consultas.add((String) "INSERT INTO comprobanteventa(numventa, numcomprobante, tipo, igv, subtotal, total, fecha, hora, codcliente, codtrabajador) "
                + "	VALUES (" + num + ", '" + numcom + "', '" + tipo + "', " + igv + ", " + subtotal + ", " + total + ",'" + fecha + "' , '" + hora + "', " + codcli + ", " + codtra + ");");

        for (int i = 0; i < Detalle.size(); i++) {
            Object[] datos = (Object[]) Detalle.get(i);
            consultas.add((String) "INSERT INTO detalleventa(cantidad, precio, numventa, codproducto) VALUES (" + datos[2] + "," + datos[1] + ", " + num + ", " + datos[4] + ")");
            consultas.add((String) "UPDATE producto set stock=stock-" + datos[2] + " where codproducto=" + datos[4]);

        }
        try {
            objConexion.ejecutartBDTransacciones(consultas);

        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    public void modificarVenta(Integer num, String numcom, String tipo, Double igv, Double subtotal, Double total, String fecha, String hora, Integer codcli, Integer codtra, ArrayList Detalle, ArrayList detalleModificado) throws Exception {
        ArrayList consultas = new ArrayList();

        for (int i = 0; i < Detalle.size(); i++) {
            Object[] datos = (Object[]) Detalle.get(i);
            consultas.add((String) "UPDATE producto set stock=stock+" + datos[2] + " where codproducto=" + datos[4]);
            consultas.add((String) "DELETE FROM  detalleventa where numventa=" + num);

        }

        consultas.add((String) "DELETE FROM  comprobanteventa where numventa=" + num);

        consultas.add((String) "INSERT INTO comprobanteventa(numventa, numcomprobante, tipo, igv, subtotal, total, fecha, hora, codcliente, codtrabajador) "
                + "	VALUES (" + num + ", '" + numcom + "', '" + tipo + "', " + igv + ", " + subtotal + ", " + total + ",'" + fecha + "' , '" + hora + "', " + codcli + ", " + codtra + ");");

        for (int i = 0; i < detalleModificado.size(); i++) {
            Object[] datos = (Object[]) detalleModificado.get(i);
            consultas.add((String) "INSERT INTO detalleventa(cantidad, precio, numventa, codproducto) VALUES (" + datos[2] + "," + datos[1] + ", " + num + ", " + datos[4] + ")");
            consultas.add((String) "UPDATE producto set stock=stock-" + datos[2] + " where codproducto=" + datos[4]);

        }
        try {
            objConexion.ejecutartBDTransacciones(consultas);

        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    public void eliminarVenta(Integer num, ArrayList Detalle) throws Exception {
        ArrayList consultas = new ArrayList();

        for (int i = 0; i < Detalle.size(); i++) {
            Object[] datos = (Object[]) Detalle.get(i);
            consultas.add((String) "UPDATE producto set stock=stock+" + datos[2] + " where codproducto=" + datos[4]);
            consultas.add((String) "DELETE FROM  detalleventa where numventa=" + num);

        }

        consultas.add((String) "DELETE FROM  comprobanteventa where numventa=" + num);

        try {
            objConexion.ejecutartBDTransacciones(consultas);

        } catch (Exception e) {
            throw new Exception(e);
        }

    }

}
