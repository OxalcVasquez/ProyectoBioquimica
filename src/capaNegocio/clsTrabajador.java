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
 * @author rodrigo , fecha : 17/10/21
 */
public class clsTrabajador {
    clsJDBCConexion obj  = new clsJDBCConexion();
    String strSQL = "";
    ResultSet rs = null;
    
    
    public int codigoTrabajador() throws Exception{
    
        strSQL = "select COALESCE(max(codtrabajador),0)+1 as codigo from trabajador";
        
        try {
            rs = obj.consultarBD(strSQL);
            if(rs.next()){
                return rs.getInt("codigo");
            }
        } catch (Exception e) {
            throw new Exception("No se pudo generar el codigo");
        }
        return 0;
    }
    
    public void guardarTrabajador(Integer codtrabajador,String nombres,String apellidos,String dni,String telefono,String correo,String direccion,Boolean sexo,String fechanac,String cargo,Boolean vigencia) throws Exception{
    
        strSQL = "insert into trabajador (codtrabajador,nombres,apellidos,dni,telefono,correo,direccion,sexo,fechanac,cargo,vigencia) values ("+codtrabajador+",'"+nombres+"','"+apellidos+"','"+dni+" ','"+telefono+" ','"+correo+" ','"+direccion+"',"+sexo+",'"+fechanac+"','"+cargo+"',"+vigencia+")";
        try {
            obj.ejecutarBD(strSQL);
            
        } catch (Exception e) {
            throw new Exception("No se pudo guardar");
        }
     
    }
    public void actualizarTrabajador(Integer codtrabajador,String nombres,String apellidos,String dni,String telefono,String correo,String direccion,Boolean sexo,String fechanac,String cargo,Boolean vigencia) throws Exception{
    
        strSQL = "update trabajador set codtrabajador = "+codtrabajador+",nombres = '"+nombres+"',apellidos = '"+apellidos+"',dni = '"+dni+"',telefono ='"+telefono+"',correo = '"+correo+"',direccion = '"+direccion+"',sexo ="+sexo+", fechanac = '"+fechanac+"',cargo = '"+cargo+"',vigencia = "+vigencia+" where codtrabajador = "+codtrabajador+"";
        try {
            obj.ejecutarBD(strSQL);
            
        } catch (Exception e) {
            throw new Exception("No se pudo actualizar");
        }
     
    }
    public void eliminarTrabajador(Integer codtrabajador) throws Exception{
    strSQL = "delete from trabajador where codtrabajador = "+codtrabajador+"";
        try {
        obj.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("No se eliminar");
        }
        
    }
    
    public ResultSet listarTrabajador() throws Exception{
    
        strSQL = "select * from trabajador";
        try {
           return  rs = obj.consultarBD(strSQL);
            
        } catch (Exception e) {
             throw new Exception("No se pudo guardar");
        }
    }
    
    public ResultSet buscar(Integer cod) throws Exception{
    strSQL = "select *  from trabajador where codtrabajador = "+cod+"";
        try {
            return rs = obj.consultarBD(strSQL);
            
        } catch (Exception e) {
             throw new Exception("No se pudo buscar");
        }
    }
    
    public void darbaja(Integer cod) throws Exception{
        strSQL = "update trabajador set  vigencia = false where codtrabajador ="+cod+" ";
        
        try {
            obj.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("No se pudo dar de baja");
        }
    }
}