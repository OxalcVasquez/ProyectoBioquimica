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
 * @author Emily Alvarado 10-11-21
 */
public class clsProveedor {
    clsJDBCConexion objConectar = new clsJDBCConexion();
    String strSQL;
    ResultSet rs = null;
    public ResultSet listarProveedores() throws Exception{
        strSQL="select*from proveedor";
        try {
            rs=objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar proveedores-");
        }
    }
    
    public void registrarProv(String ruc,String razSocial,String correo, String web, String tel,String ciudad,String rubro,Boolean estado) throws Exception{
        strSQL="insert into proveedor values('"+ruc+"', '"+razSocial+"','"+correo+"', '"+web+"','"+tel+"','"+ciudad+"','"+rubro+"',"+estado+")";
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar Proveedor");
        }
    }
    
     public ResultSet buscarProv(String ruc) throws Exception{
        strSQL="select*from proveedor where ruc='"+ruc+"'";
        try {
            rs=objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar Proveedor");
        }
    }
     
     public void modificarProv(String ruc,String razSocial,String correo, String web, String tel,String ciudad,String rubro,Boolean estado) throws Exception{
        strSQL="update proveedor set razonsocial='"+razSocial+"',correo='"+correo+"',web='"+web+"',telefono='"+tel+"',ciudad='"+ciudad+"',rubro='"+rubro+"',estado="+estado+" where ruc='"+ruc+"'";
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al modificar proveedor.");
        }
    }
     
    public void eliminarProv(String ruc) throws Exception{
        strSQL="delete from proveedor where ruc='"+ruc+"'";
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al eliminar Proveedor.");
        }
    }
    
     public void darBajaHab(String ruc) throws Exception{
        strSQL="update proveedor set estado=false where ruc='"+ruc+"'";
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al dar de baja Proveedor.");
        }
    }
     
     public Boolean validar(String ruc) throws Exception{
        strSQL="select * from proveedor where ruc ='"+ruc+"'";
            try{
            rs=objConectar.consultarBD(strSQL);
            if(rs.next()){
                return false;
            }else{
                return true;
            }
        }catch (Exception e){
        throw new Exception(e);
        }
            
     }
}
