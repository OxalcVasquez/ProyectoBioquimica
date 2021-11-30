
package capaNegocio;

import capaDatos.clsJDBCConexion;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import de.mkammerer.argon2.Argon2Helper;
import java.security.SecureRandom;
import java.sql.CallableStatement;
import java.sql.*;
import java.util.ArrayList;

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
    ArrayList strSQLar = new ArrayList();
    Argon2 argon2 = Argon2Factory.create();
    
    
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
    
    public void guardarUsuario(Integer codusuario,String nombreusuario,char[] contraseñausuario,Boolean vigencia,String fecharegistro,String recu,Integer codtrabajador) throws Exception{
    
        try {
            int iterations = Argon2Helper.findIterations(argon2, 500, 65536, 4);

            String hashPass = argon2.hash(iterations, 65536, 4, contraseñausuario);

            String hashRecu = argon2.hash(iterations, 65536, 4, recu.toCharArray());
            
            strSQL = "insert into usuario (codusuario,nombreusuario,contraseñausuario,codigorecuperacion,vigencia,fecharegistro,codtrabajador) values ("+codusuario+",'"+nombreusuario+"','"+ hashPass+"','"+hashRecu+"',"+vigencia+",'"+fecharegistro+"',"+codtrabajador+")";

            obj.ejecutarBD(strSQL);
            
        } catch (Exception e) {
            throw new Exception("No se pudo guardar");
        }
     
    }
    
    public ResultSet listarUsuario() throws Exception{
    
        strSQL = "select u.*, (t.nombres || ' ' || t.apellidos) as nombreTrabajador from usuario u inner join trabajador t on u.codtrabajador = t.codtrabajador";
        try {
           return  rs = obj.consultarBD(strSQL);
            
        } catch (Exception e) {
             throw new Exception("No se pudo listar ");
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
    
    public String[] inicioSesion(String usu, char[] contra) throws Exception {

        strSQLar.add("select nombres||' '||apellidos as nombre, nombreusuario, contraseñausuario, codusuario, cargo,dni,fechanac,telefono, correo, direccion,fecharegistro,sexo from usuario usu inner join trabajador tr on tr.codtrabajador=usu.codtrabajador where nombreusuario=?");
        strSQLar.add(usu);
        String[] usuario = null;
        //String usuario = null;
        try {

            rs = obj.consultarBD(strSQLar);
            if (rs.next()) {
                if (argon2.verify(rs.getString("contraseñausuario"), contra)) {
                    usuario =  new String[11];
                    usuario[0] = rs.getBoolean("sexo") ? "avatar1" : "avatar2";
                    usuario[1] = String.valueOf(rs.getInt("codusuario"));
                    usuario[2] = rs.getString("cargo");
                    usuario[3] = rs.getString("nombre");
                    usuario[4] = rs.getString("nombreusuario");
                    usuario[5] = rs.getString("dni");
                    usuario[6] = rs.getDate("fechanac").toString();
                    usuario[7] = rs.getString("telefono");
                    usuario[8] = rs.getString("correo");
                    usuario[9] = rs.getString("direccion");
                    usuario[10] = rs.getDate("fecharegistro").toString();
                }
                
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            // Wipe confidential data
            argon2.wipeArray(contra);
        }
        return usuario;

    }

    // Validación de vigencia de usuario 
    public Boolean validarVigencia(String usu) throws Exception {
        strSQL = "select vigencia from usuario where nombreusuario='" + usu + "'";
        try {
            rs = obj.consultarBD(strSQL);
            if (rs.next()) {
                return rs.getBoolean("vigencia");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return false;
    }

    // clase de prueba -- ELIMINAR
    public String registrar(String codRecuperacion) throws Exception {
        try {
            // iterations = 10
            // memory = 64m
            // parallelism = 1
            int iterations = Argon2Helper.findIterations(argon2, 500, 65536, 4);
            String usu = "admin2";
            String hashPass = argon2.hash(iterations, 65536, 4, "123".toCharArray());

            //String codRecuperacion = generarCodigoRecuperacion(16);
            String hashRecu = argon2.hash(iterations, 65536, 4, codRecuperacion.toCharArray());

            strSQL = "insert into usuario(codusuario,nombreusuario,contraseñausuario,codigorecuperacion,vigencia,fecharegistro,codtrabajador) values (" + generarCodigo() + ",'" + usu + "', '" + hashPass + "','" + hashRecu + "', true, current_date,1)";

            obj.ejecutarBD(strSQL);
            return codRecuperacion;

        } catch (Exception e) {
            throw new Exception("Error en el registro...");
        } finally {
            // Wipe confidential data
            //argon2.wipeArray(cont);
        }
    }

    //new MensajeMed().mostrar(this, "<html><div style='text-align: center;'>¡Usuario creado correctamente!<br><br>Su código de recuperación es: <strong>"+cod+"</strong></div><br></html>", 2);
    // Registro de usuario
    
   
    public void registrar(Integer cod, String usu, char[] cont,String recu, Integer tra) throws Exception {

        try {
            // iterations = 10
            // memory = 64m
            // parallelism = 1
            int iterations = Argon2Helper.findIterations(argon2, 500, 65536, 4);

            String hashPass = argon2.hash(iterations, 65536, 4, cont);

            String hashRecu = argon2.hash(iterations, 65536, 4, recu.toCharArray());

            strSQL = "insert into usuario (codusuario,nombreusuario,contraseñausuario,codigorecuperacion,vigencia,fecharegistro,codtrabajador) values ("+cod+",'"+usu+"','"+ hashPass+"','"+hashRecu+"',true,current_date,"+tra+")";

            obj.ejecutarBD(strSQL);

        } catch (Exception e) {
            throw new Exception("Error en el registro...");
        } finally {
            // Wipe confidential data
            argon2.wipeArray(cont);
            argon2.wipeArray(recu.toCharArray());
        }
    }

    public Integer generarCodigo() throws Exception {
        strSQL = "select coalesce(max(codusuario),0)+1 as codigo from usuario";
        try {
            rs = obj.consultarBD(strSQL);
            while (rs.next()) {
                return rs.getInt("codigo");

            }
        } catch (Exception e) {
            throw new Exception("Error al generar nuevo código...");

        }
        return 0;
    }

    public String generarCodigoRecuperacion(int length) {
        String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
        String CHAR_UPPER = CHAR_LOWER.toUpperCase();
        String NUMBER = "0123456789";

        String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
        SecureRandom random = new SecureRandom();

        if (length < 1) {
            throw new IllegalArgumentException();
        }

        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);

            sb.append(rndChar);
        }

        return sb.toString();
    }

    public Boolean validarCodigoRecuperacion(String usu, String codR) throws Exception {
        strSQLar.add("select codigorecuperacion from usuario where nombreusuario = ?");
        strSQLar.add(usu);
        try {
            rs = obj.consultarBD(strSQLar);
            if (rs.next()) {
                if (argon2.verify(rs.getString("codigorecuperacion"), codR.toCharArray())) {
                    return true;
                }

            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            // Wipe confidential data
            argon2.wipeArray(codR.toCharArray());
        }
        return false;
    }

    public void modificarContrasenia(String usu, char[] nueCon) throws Exception {
        try {
            int iterations = Argon2Helper.findIterations(argon2, 500, 65536, 4);

            String hashPass = argon2.hash(iterations, 65536, 4, nueCon);
            strSQLar.add("update usuario set contraseñausuario= ? where nombreusuario=?");
            strSQLar.add(hashPass);
            strSQLar.add(usu);

            obj.ejecutarBD(strSQLar);
        } catch (Exception e) {
            throw new Exception("No se pudo modificar contraseña!");
        } finally {
            // Wipe confidential data
            argon2.wipeArray(nueCon);
        }
    }

    public ResultSet actualizarCodigoRecuperacion(String usu, String codR) throws Exception {

        try {
            int iterations = Argon2Helper.findIterations(argon2, 500, 65536, 4);

            String hashRecu = argon2.hash(iterations, 65536, 4, codR.toCharArray());
            strSQLar.add("update usuario usu set codigorecuperacion = ? from trabajador tra where usu.nombreusuario = ? returning nombres,apellidos,correo");
            strSQLar.add(hashRecu);
            strSQLar.add(usu);
            
            rs = obj.consultarBD(strSQLar);
            return rs;
            
        } catch (Exception e) {
            throw new Exception("No se pudo actualizar el código de recuperación!");
        } finally {
            // Wipe confidential data
            argon2.wipeArray(codR.toCharArray());
        }
    }
    
}
