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
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author rodrigo , fecha : 17/10/21
 */
public class clsTrabajador {
    clsJDBCConexion obj  = new clsJDBCConexion();
    String strSQL = "";
    ResultSet rs = null;
    Connection con;
    CallableStatement cs = null;
    
    
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
    
     public int codigoTrabajadorPA() throws Exception{
    
        strSQL = "select f_codigoTrabajador()";
        obj.conectarBD();
        con = obj.getCon();
        cs = con.prepareCall(strSQL);
        rs = cs.executeQuery();
        if(rs.next()){
            return rs.getInt("f_codigoTrabajador");
        }      
        try {
           
        } catch (Exception e) {
            throw new Exception("No se pudo generar el codigo");
        }finally{
            obj.desconectarBD();
            con.close();
            rs.close();
        
        }
        return 0;
    }
        
      public Boolean validarTrabajador (Integer cod) throws Exception{
        strSQL="select f_verificar_trabajador_ventas("+cod+")";
        try {
            obj.conectarBD();
            con=obj.getCon();
            cs=con.prepareCall(strSQL);
            rs=cs.executeQuery();
            if (rs.next()){
            return rs.getBoolean("f_verificar_trabajador_ventas");
            }   
        } catch (Exception e) {
            throw new Exception("Error al verificar el trabajador");
        }finally{
            obj.desconectarBD();
            cs.close();
        }
        return false;
    }
     
    //Proceso Almacenado
     public void registrarTrabajador(Integer codtrabajador,String nombres,String apellidos,String dni,String telefono,String correo,String direccion,Boolean sexo,String fechanac,Character cargo,Boolean vigencia) throws Exception{
        strSQL = "select fn_registrarTrabajador("+codtrabajador+",'"+nombres+"','"+apellidos+"','"+dni+" ','"+telefono+" ','"+correo+" ','"+direccion+"',"+sexo+",'"+fechanac+"','"+cargo+"',"+vigencia+")";
        try {
         obj.consultarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("No se pudo guardar");
        } 
     }
     
    
    public void guardarTrabajador(Integer codtrabajador,String nombres,String apellidos,String dni,String telefono,String correo,String direccion,Boolean sexo,String fechanac,Character cargo,Boolean vigencia) throws Exception{
    
        strSQL = "insert into trabajador (codtrabajador,nombres,apellidos,dni,telefono,correo,direccion,sexo,fechanac,cargo,vigencia) values ("+codtrabajador+",'"+nombres+"','"+apellidos+"','"+dni+" ','"+telefono+" ','"+correo+" ','"+direccion+"',"+sexo+",'"+fechanac+"','"+cargo+"',"+vigencia+")";
        try {
            obj.ejecutarBD(strSQL);
            
        } catch (Exception e) {
            throw new Exception("No se pudo guardar");
        }
     
    }

    
    public void actualizarTrabajador(Integer codtrabajador,String nombres,String apellidos,String dni,String telefono,String correo,String direccion,Boolean sexo,String fechanac,Character cargo,Boolean vigencia) throws Exception{
    
        strSQL = "update trabajador set codtrabajador = "+codtrabajador+",nombres = '"+nombres+"',apellidos = '"+apellidos+"',dni = '"+dni+"',telefono ='"+telefono+"',correo = '"+correo+"',direccion = '"+direccion+"',sexo ="+sexo+", fechanac = '"+fechanac+"',cargo = '"+cargo+"',vigencia = "+vigencia+" where codtrabajador = "+codtrabajador+"";
        try {
            obj.ejecutarBD(strSQL);
            
        } catch (Exception e) {
            throw new Exception("No se pudo actualizar");
        }
     
    }
    public void eliminarTrabajador(Integer codtrabajador) throws Exception{
        
        strSQL= "select * from comprobanteventa where codtrabajador = "+codtrabajador+"";
        ArrayList consultas = new ArrayList();
        consultas.add("delete from usuario where codtrabajador ="+codtrabajador+" ");
        consultas.add("delete from trabajador where codtrabajador ="+codtrabajador+" ");
        
        try {
            rs = obj.consultarBD(strSQL);
            if(rs.next()){
            throw new Exception("Existe una venta hecha por el trabajador, no puede ser eliminado");
            }else{
             obj.ejecutarTransaccionBD(consultas); 
        }        
        } catch (Exception e) {
        throw new Exception("No se pudo eliminar el trabajador");
        }
        
    }
     //Proceso Almacenado
    public ResultSet listarTra() throws Exception{
    
        strSQL = "select * from fn_listartrabajador()";
        try {
            rs= obj.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("No se pudo listar ");
        
        }
    
    }
    
    public ResultSet listarTrabajador() throws Exception{
    
        strSQL = "select codtrabajador,nombres,apellidos,dni,telefono,correo,direccion,sexo,fechanac,cargo,case vigencia when true then 'Vigente' else 'No vigente' end as vigencia from trabajador order by apellidos";
        try {
           return  rs = obj.consultarBD(strSQL);
            
        } catch (Exception e) {
             throw new Exception("No se pudo listar");
        }
    }
    
    //Proceso almacenado 
        
    public ResultSet buscarTra(Integer cod) throws Exception {
        strSQL = "select * from fn_Buscartrabajador(" + cod + ")";

        try {
            rs = obj.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar producto");
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
    
    public void darbajaTR(Integer cod) throws Exception{
       
        ArrayList consulta = new ArrayList();
        consulta.add("update trabajador set  vigencia = false where codtrabajador ="+cod+" ");
        consulta.add("update usuario set vigencia = false where codtrabajador = "+cod+"");
        
        try {
            obj.ejecutartBDTransacciones(consulta);
        } catch (Exception e) {
            throw new Exception("No se pudo dar de baja");
        }
    }
}
