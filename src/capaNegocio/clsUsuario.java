
package capaNegocio;

import capaDatos.clsJDBCConexion;
import java.sql.CallableStatement;
import java.sql.*;

/**
 *
 * @author rodrigo , fecha : 17/10/21
 */
public class clsUsuario {
        clsJDBCConexion obj  = new clsJDBCConexion();
    String strSQL = "";
    ResultSet rs = null;
    Connection con ;
    CallableStatement cs = null;
    
    
    public int codigoUsuario() throws Exception{
    
        strSQL = "select COALESCE(max(codusuario),0)+1 as codigo  from usuario";
        
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
    
    public int codigoUsuarioPA() throws Exception{
    
        strSQL = "select f_codigoUsuario()";
        
        try {
            obj.conectarBD();
            con = obj.getCon();
            cs = con.prepareCall(strSQL);
            rs = cs.executeQuery();
            if(rs.next()){
                 return rs.getInt("f_codigoUsuario");
            }

        } catch (Exception e) {
            throw new Exception("No se pudo generar el codigo");
        }finally{
            obj.desconectarBD();
            cs.close();
            rs.close();
        }
        return 0;
    }
    
    public void guardarUsuario(Integer codusuario,String nombreusuario,String contraseñausuario,Boolean vigencia,String fecharegistro,Integer codtrabajador) throws Exception{
    
        strSQL = "insert into usuario (codusuario,nombreusuario,contraseñausuario,vigencia,fecharegistro,codtrabajador) values ("+codusuario+",'"+nombreusuario+"','"+contraseñausuario+"',"+vigencia+",'"+fecharegistro+"',"+codtrabajador+")";
        try {
            obj.ejecutarBD(strSQL);
            
        } catch (Exception e) {
            throw new Exception("No se pudo guardar");
        }
     
    }
    
    public ResultSet listarUsuario() throws Exception{
    
        strSQL = "select * from usuario";
        try {
           return  rs = obj.consultarBD(strSQL);
            
        } catch (Exception e) {
             throw new Exception("No se pudo guardar");
        }
    }
    
        public void darbaja(Integer cod) throws Exception{
        strSQL = "update usuario set vigencia = false where codusuario = "+cod+"";
        
        try {
            obj.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("No se pudo dar de baja");
        }
    }
        
    public ResultSet buscar(Integer cod) throws Exception{
    strSQL = "select * from usuario where codusuario = "+cod+"";
        try {
            return rs = obj.consultarBD(strSQL);
            
        } catch (Exception e) {
             throw new Exception("No se pudo buscar");
        }
    }
    
    public void eliminar(Integer codUsu) throws Exception{
    strSQL = "delete from usuario where codusuario = "+codUsu+"";
        try {
        obj.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("No se pudo eliminar");
        }
        
    }
    
    public void actualizar(Integer codusuario,String nombreusuario,String contraseñausuario,Boolean vigencia,String fecharegistro,Integer codtrabajador) throws Exception{
    
        strSQL = "update usuario set nombreusuario='"+nombreusuario+"',contraseñausuario = '"+contraseñausuario+"',vigencia = "+vigencia+", fecharegistro='"+fecharegistro+"',codtrabajador = "+codtrabajador+" where codusuario = "+codusuario+"";
        try {
            obj.ejecutarBD(strSQL);
            
        } catch (Exception e) {
            throw new Exception("No se pudo actualizar");
        }
     
    }
    
    public ResultSet cboTrabajadores() throws Exception{
    
        strSQL = "select  (trabajador.nombres ||' '|| trabajador.apellidos )  as trabajador  from usuario u inner join trabajador  on u.codtrabajador = trabajador.codtrabajador group by  (trabajador.nombres ||' '|| trabajador.apellidos ) ";
        try {
            return obj.consultarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("No se pudo listar a los trabajadores");
        }
    }
    
    public Integer codigoTrabajadorCombo(String trabajador) throws Exception{
    
        strSQL = "select trabajador.codtrabajador from usuario u inner join trabajador  on u.codtrabajador = trabajador.codtrabajador where (trabajador.nombres ||' '|| trabajador.apellidos ) = '"+trabajador+"'";
        try {
            rs = obj.consultarBD(strSQL);
            if(rs.next()){
                return rs.getInt("codtrabajador");
            }
        } catch (Exception e) {
         throw new Exception("No se pudo retornar el codigo");
        }
        return 0;
    }
}
