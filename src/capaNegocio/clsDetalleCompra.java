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
 * @author NUEVO
 */
public class clsDetalleCompra {
    clsJDBCConexion objConexion = new clsJDBCConexion();
    String strSQL;
    ResultSet rs = null;
    public ResultSet listarDetalle(Integer cod) throws Exception {
        strSQL = " select D.*, P.nombre as producto from detallecompra D inner join producto P on P.codproducto=D.codproducto\n" +
" where codcomprobante="+cod+"";

        try {
            rs = objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar detalle");
        }

    }
}
