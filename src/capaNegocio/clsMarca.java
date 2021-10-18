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
 * @author Jordan Oxalc Vásquez Fernández - 10/15/2021
 */
public class clsMarca {

    clsJDBCConexion objConexion = new clsJDBCConexion();
    String strSQL;
    ResultSet rs = null;

    public Integer generarCodigoMarca() throws Exception {
        strSQL = "select coalesce(max(codMarca),0)+1 as codigo from Marca";

        try {
            rs = objConexion.consultarBD(strSQL);
            if (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (Exception e) {
            throw new Exception("Error al generar código de la Marca!");
        }
        return 0;
    }

    public Integer obtenerCodigoMarca(String nombre) throws Exception {
        strSQL = "select codMarca from marca where nombre='" + nombre + "'";

        try {
            rs = objConexion.consultarBD(strSQL);
            if (rs.next()) {
                return rs.getInt("codMarca");
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener codigo de Marca!");
        }
        return 0;
    }

    public ResultSet listarMarcas() throws Exception {
        strSQL = "select * from Marca";

        try {
            rs = objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar Marca");
        }

    }

    public ResultSet buscarMarca(Integer cod) throws Exception {
        strSQL = "select * from Marca where codMarca=" + cod + "";

        try {
            rs = objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar Marca");
        }

    }

    public ResultSet listarMarcasVigentes() throws Exception {
        strSQL = "select * from Marca where vigencia=true";

        try {
            rs = objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar Marcas vigentes");
        }

    }

    public void registrarMarca(Integer cod, String nombre, Boolean vigencia) throws Exception {
        strSQL = "INSERT INTO Marca(codMarca, nombre, vigencia) VALUES (" + cod + ", '" + nombre + "', " + vigencia + ");";

        try {
            objConexion.ejecutarBD(strSQL);

        } catch (Exception e) {
            throw new Exception("Error al registrar Marca");
        }

    }

    public void modificarMarca(Integer cod, String nombre, Boolean vigencia) throws Exception {
        strSQL = " UPDATE Marca SET  nombre='" + nombre + "', vigencia= " + vigencia + " WHERE codMarca=" + cod + ";";

        try {
            objConexion.ejecutarBD(strSQL);

        } catch (Exception e) {
            throw new Exception("Error al modificar Marca");
        }

    }

    public void eliminarMarca(Integer cod) throws Exception {
        strSQL = " DELETE FROM Marca WHERE codMarca=" + cod + ";";

        try {
            objConexion.ejecutarBD(strSQL);

        } catch (Exception e) {
            throw new Exception("Error al eliminar Marca");
        }

    }

    public void darBajaMarca(Integer cod) throws Exception {
        strSQL = "UPDATE  Marca SET vigencia=false WHERE codMarca=" + cod + ";";

        try {
            objConexion.ejecutarBD(strSQL);

        } catch (Exception e) {
            throw new Exception("Error al eliminar Marca");
        }
    }
}
