package capaDatos;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jordan Oxalc Vásquez Fernández , Fecha : 31/08/2021
 */
public class clsJDBCConexion {

    private String driver, url, user, password;
    private Connection con;
    private Statement sent = null;
    private PreparedStatement ps;

    //Constructor de clases
    public clsJDBCConexion() {
        this.driver = "org.postgresql.Driver";
        this.url = "jdbc:postgresql://ec2-3-221-100-217.compute-1.amazonaws.com:5432/d325lbe00ak265";
        this.user = "mypimcwxsyjsvp";
        this.password = "d794791d083f061a077dabd47961b43acd04e71ae2798d5136c38fd6308c1547";
        this.con = null;
    }
    
    public void desconetarBD() throws Exception{
        try{
            con.close();
        } catch(SQLException e){
            throw new Exception("Error al conectar a la BD...");
        }   
    }

    //Conexión a BD
    public void conectarBD() throws Exception {
        try {
            Class.forName(this.driver);
            con = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            throw new Exception("Error al conectar a la BD...");
        }

    }

    //Desconexión BD
    public void desconectarBD() throws Exception {
        try {
            con.close();
        } catch (SQLException e) {
            throw new Exception("Error al desconectar a la BD...");
        }

    }

    //Consulta del estado de la conexión   
    public boolean getEstadoConexion() throws SQLException {
        return con.isClosed();
    }

    //Ejecutar consultas en la Base De datos : SELECT
    public ResultSet consultarBD(String strSQL) throws Exception {
        ResultSet rs = null;//almacenar un conjunto de registros 
        try {
            conectarBD();
            sent = con.createStatement();
            rs = sent.executeQuery(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al consultar base de datos... ");
        } finally {
            if (con != null) {
                desconectarBD();
            }
        }
    }
    
    /**
     *
     * @param sets
     * @return
     * @throws Exception
     */
    public ResultSet consultarBD(ArrayList sets) throws Exception {
        ResultSet rs = null;
        try {
            conectarBD();

            ps = con.prepareStatement(sets.get(0).toString());

            for (int i = 1; i < sets.size(); i++) {
                String tipo = sets.get(i).getClass().getSimpleName();
                if (tipo.equalsIgnoreCase("String")) {
                    ps.setString(i, (String) sets.get(i));
                } else if (tipo.equalsIgnoreCase("Integer")) {
                    ps.setInt(i, (int) sets.get(i));
                } else if (tipo.equalsIgnoreCase("Boolean")) {
                    ps.setBoolean(i, (boolean) sets.get(i));
                } else if (tipo.equalsIgnoreCase("Date")) {
                    ps.setDate(i, (Date) sets.get(i));
                } else if (tipo.equalsIgnoreCase("Float")) {
                    ps.setFloat(i, (float) sets.get(i));
                } else if (tipo.equalsIgnoreCase("Double")) {
                    ps.setDouble(i, (double) sets.get(i));
                }
            }

            rs = ps.executeQuery();
            return rs;

        } catch (Exception e) {
            throw new Exception("Error al ejecutar consulta...");
        } finally {
            if (con != null) {
                sets.clear();
                desconectarBD();
            }
        }
    }

    //Ejecutar INSERT,UPDATE Y DELETE
    public void ejecutarBD(String strSQL) throws Exception {
        try {
            conectarBD();
            sent = con.createStatement();
            sent.executeUpdate(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al ejecutar consulta en la base de datos... ");
        } finally {
            if (con != null) {
                desconectarBD();
            }

        }

    }
    
    /**
     *
     * @param sets consulta y parámetro(s)
     * @throws Exception
     */
    public void ejecutarBD(ArrayList sets) throws Exception {
        try {
            conectarBD();
            ps = con.prepareStatement(sets.get(0).toString());

            for (int i = 1; i < sets.size(); i++) {
                String tipo = sets.get(i).getClass().getSimpleName();
                if (tipo.equalsIgnoreCase("String")) {
                    ps.setString(i, (String) sets.get(i));
                } else if (tipo.equalsIgnoreCase("Integer")) {
                    ps.setInt(i, (int) sets.get(i));
                } else if (tipo.equalsIgnoreCase("Boolean")) {
                    ps.setBoolean(i, (boolean) sets.get(i));
                } else if (tipo.equalsIgnoreCase("Date")) {
                    ps.setDate(i, (Date) sets.get(i));
                } else if (tipo.equalsIgnoreCase("Float")) {
                    ps.setFloat(i, (float) sets.get(i));
                } else if (tipo.equalsIgnoreCase("Double")) {
                    ps.setDouble(i, (double) sets.get(i));
                }
            }

            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al ejecutar la consulta...");
        } finally {
            if (con != null) {
                sets.clear();
                desconectarBD();
            }
        }
    }
    //Ejecuta TRANSACCIÓN .-
    
    public void ejecutarTransaccionBD(ArrayList ArregloConsultas) throws Exception {
        
        try {
            conectarBD();
            con.setAutoCommit(false);
             sent = con.createStatement();
            for(Object consultas: ArregloConsultas ){               
                sent.executeUpdate((String) consultas);
            }
            con.commit();
            con.setAutoCommit(true);
            
        } catch (Exception e) {
            con.rollback();
           throw new Exception("Error al ejecutar la transaccion");
        }finally{
            if(con !=null ){
                desconectarBD();
            }
        
        }
    
    }
    
     public Connection getCon(){
        return con;
    }
    
    //Transaccion
    public void ejecutartBDTransacciones(ArrayList arregloConsulta) throws Exception{
        
        try {
            conectarBD();
            con.setAutoCommit(false);//Iniciar la transaccion
            sent = con.createStatement();
            for (Object consulta:arregloConsulta) {
                sent.executeUpdate((String)consulta);
                
            }
            //todas las sentencias de la transaccion
            con.commit();
            con.setAutoCommit(true); //Finaliza o desactiva el manejo de transaccion

        } catch (Exception e) {
            con.rollback();
            throw new Exception("Error al ejecutar la transaccion... ");

        }finally {
            if (con != null) {
                desconectarBD();
            }

        }
    }
    
}
