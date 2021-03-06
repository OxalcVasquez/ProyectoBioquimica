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

/**
 *
 * @author Emily Alvarado 10-11-21
 */
public class clsProveedor {
    clsJDBCConexion objConectar = new clsJDBCConexion();
    String strSQL;
    ResultSet rs = null;
          Connection con;
    CallableStatement cs = null;
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
        strSQL="select pa_registrarProveedor('"+ruc+"', '"+razSocial+"','"+correo+"', '"+web+"','"+tel+"','"+ciudad+"','"+rubro+"',"+estado+")";
        try {
            objConectar.consultarBD(strSQL);
        } catch (Exception e) {
            throw new Exception(e);
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
     public boolean validarVigencia(String ruc) throws Exception{
        strSQL="select estado from proveedor where ruc ='"+ruc+"'";
        try {
            rs=objConectar.consultarBD(strSQL);
            if(rs.next()){
                return rs.getBoolean("estado");
            }
        } catch (Exception e) {
              throw new Exception(e.getMessage());
        }
        return false;
    }
     public void actualizarestado(String ruc) throws Exception{
        strSQL="update  proveedor set estado= true where ruc ='"+ruc+"'";
        try {
           objConectar.ejecutarBD(strSQL);
           
        } catch (Exception e) {
              throw new Exception(e.getMessage());
        }
        
    }
     public Boolean verfificarPro(String ruc) throws Exception{
        strSQL="select f_verificarProveedor('"+ruc+"')";
        try {
            objConectar.conectarBD();
            con=objConectar.getCon();
            cs=con.prepareCall(strSQL);
            rs=cs.executeQuery();
            if (rs.next()){
            return rs.getBoolean("f_verificarProveedor");
            }
            
        } catch (Exception e) {
            throw new Exception(e);
        }finally{
            objConectar.desconectarBD();
            cs.close();
        }
        return false;
    } 
     
}
