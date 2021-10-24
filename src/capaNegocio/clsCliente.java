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
public class clsCliente {

    clsJDBCConexion objConexion = new clsJDBCConexion();
    String strSQL;
    ResultSet rs = null;

    public Integer generarCodigoCliente() throws Exception {
        strSQL = "select coalesce(max(codCliente),0)+1 as codigo from cliente";

        try {
            rs = objConexion.consultarBD(strSQL);
            if (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (Exception e) {
            throw new Exception("Error al generar código del cliente!");
        }
        return 0;
    }

    public ResultSet listarCliente() throws Exception {
        strSQL = "select * from cliente";

        try {
            rs = objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar cliente");
        }

    }

    public ResultSet buscarCliente(Integer cod) throws Exception {
        strSQL = "select * from cliente where codcliente=" + cod + "";

        try {
            rs = objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar cliente");
        }

    }

    public ResultSet buscarClientePorDocumento(String numdocumento, char td) throws Exception {
        strSQL = "select * from cliente where numdocumento='" + numdocumento + "'and tipodocumento='" + td + "'";

        try {
            rs = objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar cliente");
        }

    }

    public ResultSet listarClientesVigentes() throws Exception {
        strSQL = "select * from cliente where vigencia=true";

        try {
            rs = objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar clientes vigentes");
        }

    }

    public void registrarCliente(Integer cod, String numD, String tipoD, String nom, String ape, String fecha, Boolean sexo, String ciudad, String telefono, String correo, Boolean vigencia) throws Exception {
        strSQL = "insert into cliente values(" + cod + ",'" + numD + "','" + tipoD + "','" + nom + "','" + ape + "','" + fecha + "'," + sexo + ",'" + ciudad + "','" + telefono + "','" + correo + "'," + vigencia + ")";

        try {
            objConexion.ejecutarBD(strSQL);

        } catch (Exception e) {
            throw new Exception("Error al registrar cliente");
        }

    }

    public void modificarCliente(Integer cod, String numD, String tipoD, String nom, String ape, String fecha, Boolean sexo, String ciudad, String telefono, String correo, Boolean vigencia) throws Exception {
        strSQL = " UPDATE cliente SET  numdocumento='" + numD + "',tipodocumento='" + tipoD + "',nombres='" + nom + "',apellidos='" + ape + "',fechanac='" + fecha + "', sexo= " + sexo + ",ciudad='" + ciudad + "',telefono='" + telefono + "',correo='" + correo + "', vigencia=" + vigencia + " WHERE codCliente=" + cod;

        try {
            objConexion.ejecutarBD(strSQL);

        } catch (Exception e) {
            throw new Exception("Error al modificar cliente");
        }

    }

    public void eliminarCliente(Integer cod) throws Exception {
        strSQL = " DELETE FROM cliente WHERE codcliente=" + cod + ";";

        try {
            objConexion.ejecutarBD(strSQL);

        } catch (Exception e) {
            throw new Exception("Error al eliminar cliente");
        }

    }

    public void darBajaCliente(Integer cod) throws Exception {
        strSQL = "UPDATE cliente SET vigencia=false WHERE codcliente=" + cod + ";";

        try {
            objConexion.ejecutarBD(strSQL);

        } catch (Exception e) {
            throw new Exception("Error al eliminar cliente");
        }

    }
}
